package com.firebase.geofire;

import com.firebase.geofire.core.GeoHash;
import com.firebase.geofire.core.GeoHashQuery;
import com.firebase.geofire.util.GeoUtils;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class GeoQuery {
    private static final int KILOMETER_TO_METER = 1000;
    private GeoLocation center;
    private final ChildEventListener childEventLister = new C05381();
    private final Set<GeoQueryDataEventListener> eventListeners = new HashSet();
    private final Map<GeoHashQuery, Query> firebaseQueries = new HashMap();
    private final GeoFire geoFire;
    private final Map<String, LocationInfo> locationInfos = new HashMap();
    private final Set<GeoHashQuery> outstandingQueries = new HashSet();
    private Set<GeoHashQuery> queries;
    private double radius;

    private static class LocationInfo {
        final DataSnapshot dataSnapshot;
        final GeoHash geoHash;
        final boolean inGeoQuery;
        final GeoLocation location;

        public LocationInfo(GeoLocation geoLocation, boolean z, DataSnapshot dataSnapshot) {
            this.location = geoLocation;
            this.inGeoQuery = z;
            this.geoHash = new GeoHash(geoLocation);
            this.dataSnapshot = dataSnapshot;
        }
    }

    class C05381 implements ChildEventListener {
        C05381() {
        }

        public void onChildAdded(DataSnapshot dataSnapshot, String str) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childAdded(dataSnapshot);
            }
        }

        public void onChildChanged(DataSnapshot dataSnapshot, String str) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childChanged(dataSnapshot);
            }
        }

        public void onChildRemoved(DataSnapshot dataSnapshot) {
            synchronized (GeoQuery.this) {
                GeoQuery.this.childRemoved(dataSnapshot);
            }
        }

        public synchronized void onChildMoved(DataSnapshot dataSnapshot, String str) {
        }

        public synchronized void onCancelled(DatabaseError databaseError) {
        }
    }

    GeoQuery(GeoFire geoFire, GeoLocation geoLocation, double d) {
        this.geoFire = geoFire;
        this.center = geoLocation;
        this.radius = d * 0;
    }

    private boolean locationIsInQuery(GeoLocation geoLocation) {
        return GeoUtils.distance(geoLocation, this.center) <= this.radius ? true : null;
    }

    private void updateLocationInfo(final DataSnapshot dataSnapshot, final GeoLocation geoLocation) {
        String key = dataSnapshot.getKey();
        LocationInfo locationInfo = (LocationInfo) this.locationInfos.get(key);
        Object obj = null;
        Object obj2 = locationInfo == null ? 1 : null;
        boolean z = (locationInfo == null || locationInfo.location.equals(geoLocation)) ? false : true;
        if (locationInfo != null && locationInfo.inGeoQuery) {
            obj = 1;
        }
        boolean locationIsInQuery = locationIsInQuery(geoLocation);
        if ((obj2 != null || obj == null) && locationIsInQuery) {
            for (final GeoQueryDataEventListener geoQueryDataEventListener : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    public void run() {
                        geoQueryDataEventListener.onDataEntered(dataSnapshot, geoLocation);
                    }
                });
            }
        } else if (obj2 == null && locationIsInQuery) {
            for (final GeoQueryDataEventListener geoQueryDataEventListener2 : this.eventListeners) {
                final boolean z2 = z;
                final DataSnapshot dataSnapshot2 = dataSnapshot;
                final GeoLocation geoLocation2 = geoLocation;
                this.geoFire.raiseEvent(new Runnable() {
                    public void run() {
                        if (z2) {
                            geoQueryDataEventListener2.onDataMoved(dataSnapshot2, geoLocation2);
                        }
                        geoQueryDataEventListener2.onDataChanged(dataSnapshot2, geoLocation2);
                    }
                });
            }
        } else if (!(obj == null || locationIsInQuery)) {
            for (final GeoQueryDataEventListener geoQueryDataEventListener3 : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    public void run() {
                        geoQueryDataEventListener3.onDataExited(dataSnapshot);
                    }
                });
            }
        }
        this.locationInfos.put(key, new LocationInfo(geoLocation, locationIsInQuery(geoLocation), dataSnapshot));
    }

    private boolean geoHashQueriesContainGeoHash(GeoHash geoHash) {
        if (this.queries == null) {
            return false;
        }
        for (GeoHashQuery containsGeoHash : this.queries) {
            if (containsGeoHash.containsGeoHash(geoHash)) {
                return true;
            }
        }
        return false;
    }

    private void reset() {
        for (Entry value : this.firebaseQueries.entrySet()) {
            ((Query) value.getValue()).removeEventListener(this.childEventLister);
        }
        this.outstandingQueries.clear();
        this.firebaseQueries.clear();
        this.queries = null;
        this.locationInfos.clear();
    }

    private boolean hasListeners() {
        return this.eventListeners.isEmpty() ^ 1;
    }

    private boolean canFireReady() {
        return this.outstandingQueries.isEmpty();
    }

    private void checkAndFireReady() {
        if (canFireReady()) {
            for (final GeoQueryDataEventListener geoQueryDataEventListener : this.eventListeners) {
                this.geoFire.raiseEvent(new Runnable() {
                    public void run() {
                        geoQueryDataEventListener.onGeoQueryReady();
                    }
                });
            }
        }
    }

    private void addValueToReadyListener(Query query, final GeoHashQuery geoHashQuery) {
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                synchronized (GeoQuery.this) {
                    GeoQuery.this.outstandingQueries.remove(geoHashQuery);
                    GeoQuery.this.checkAndFireReady();
                }
            }

            public void onCancelled(final DatabaseError databaseError) {
                synchronized (GeoQuery.this) {
                    for (final GeoQueryDataEventListener geoQueryDataEventListener : GeoQuery.this.eventListeners) {
                        GeoQuery.this.geoFire.raiseEvent(new Runnable() {
                            public void run() {
                                geoQueryDataEventListener.onGeoQueryError(databaseError);
                            }
                        });
                    }
                }
            }
        });
    }

    private void setupQueries() {
        Set<GeoHashQuery> hashSet = this.queries == null ? new HashSet() : this.queries;
        Set<GeoHashQuery> queriesAtLocation = GeoHashQuery.queriesAtLocation(this.center, this.radius);
        this.queries = queriesAtLocation;
        for (GeoHashQuery geoHashQuery : hashSet) {
            if (!queriesAtLocation.contains(geoHashQuery)) {
                ((Query) this.firebaseQueries.get(geoHashQuery)).removeEventListener(this.childEventLister);
                this.firebaseQueries.remove(geoHashQuery);
                this.outstandingQueries.remove(geoHashQuery);
            }
        }
        for (GeoHashQuery geoHashQuery2 : queriesAtLocation) {
            if (!hashSet.contains(geoHashQuery2)) {
                this.outstandingQueries.add(geoHashQuery2);
                Query endAt = this.geoFire.getDatabaseReference().orderByChild("g").startAt(geoHashQuery2.getStartValue()).endAt(geoHashQuery2.getEndValue());
                endAt.addChildEventListener(this.childEventLister);
                addValueToReadyListener(endAt, geoHashQuery2);
                this.firebaseQueries.put(geoHashQuery2, endAt);
            }
        }
        for (Entry value : this.locationInfos.entrySet()) {
            LocationInfo locationInfo = (LocationInfo) value.getValue();
            if (locationInfo != null) {
                updateLocationInfo(locationInfo.dataSnapshot, locationInfo.location);
            }
        }
        Iterator it = this.locationInfos.entrySet().iterator();
        while (it.hasNext()) {
            if (!geoHashQueriesContainGeoHash(((LocationInfo) ((Entry) it.next()).getValue()).geoHash)) {
                it.remove();
            }
        }
        checkAndFireReady();
    }

    private void childAdded(DataSnapshot dataSnapshot) {
        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
        if (locationValue != null) {
            updateLocationInfo(dataSnapshot, locationValue);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got Datasnapshot without location with key ");
        stringBuilder.append(dataSnapshot.getKey());
        throw new AssertionError(stringBuilder.toString());
    }

    private void childChanged(DataSnapshot dataSnapshot) {
        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
        if (locationValue != null) {
            updateLocationInfo(dataSnapshot, locationValue);
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Got Datasnapshot without location with key ");
        stringBuilder.append(dataSnapshot.getKey());
        throw new AssertionError(stringBuilder.toString());
    }

    private void childRemoved(DataSnapshot dataSnapshot) {
        dataSnapshot = dataSnapshot.getKey();
        if (((LocationInfo) this.locationInfos.get(dataSnapshot)) != null) {
            this.geoFire.getDatabaseRefForKey(dataSnapshot).addListenerForSingleValueEvent(new ValueEventListener() {
                public void onCancelled(DatabaseError databaseError) {
                }

                public void onDataChange(DataSnapshot dataSnapshot) {
                    synchronized (GeoQuery.this) {
                        GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
                        GeoHash geoHash = locationValue != null ? new GeoHash(locationValue) : null;
                        if (geoHash == null || GeoQuery.this.geoHashQueriesContainGeoHash(geoHash) == null) {
                            final LocationInfo locationInfo = (LocationInfo) GeoQuery.this.locationInfos.remove(dataSnapshot);
                            if (locationInfo != null && locationInfo.inGeoQuery) {
                                for (final GeoQueryDataEventListener geoQueryDataEventListener : GeoQuery.this.eventListeners) {
                                    GeoQuery.this.geoFire.raiseEvent(new Runnable() {
                                        public void run() {
                                            geoQueryDataEventListener.onDataExited(locationInfo.dataSnapshot);
                                        }
                                    });
                                }
                            }
                        }
                    }
                }
            });
        }
    }

    public synchronized void addGeoQueryEventListener(GeoQueryEventListener geoQueryEventListener) {
        addGeoQueryDataEventListener(new EventListenerBridge(geoQueryEventListener));
    }

    public synchronized void addGeoQueryDataEventListener(final GeoQueryDataEventListener geoQueryDataEventListener) {
        if (this.eventListeners.contains(geoQueryDataEventListener)) {
            throw new IllegalArgumentException("Added the same listener twice to a GeoQuery!");
        }
        this.eventListeners.add(geoQueryDataEventListener);
        if (this.queries == null) {
            setupQueries();
        } else {
            for (Entry entry : this.locationInfos.entrySet()) {
                String str = (String) entry.getKey();
                final LocationInfo locationInfo = (LocationInfo) entry.getValue();
                if (locationInfo.inGeoQuery) {
                    this.geoFire.raiseEvent(new Runnable() {
                        public void run() {
                            geoQueryDataEventListener.onDataEntered(locationInfo.dataSnapshot, locationInfo.location);
                        }
                    });
                }
            }
            if (canFireReady()) {
                this.geoFire.raiseEvent(new Runnable() {
                    public void run() {
                        geoQueryDataEventListener.onGeoQueryReady();
                    }
                });
            }
        }
    }

    public synchronized void removeGeoQueryEventListener(GeoQueryEventListener geoQueryEventListener) {
        removeGeoQueryEventListener(new EventListenerBridge(geoQueryEventListener));
    }

    public synchronized void removeGeoQueryEventListener(GeoQueryDataEventListener geoQueryDataEventListener) {
        if (this.eventListeners.contains(geoQueryDataEventListener)) {
            this.eventListeners.remove(geoQueryDataEventListener);
            if (hasListeners() == null) {
                reset();
            }
        } else {
            throw new IllegalArgumentException("Trying to remove listener that was removed or not added!");
        }
    }

    public synchronized void removeAllListeners() {
        this.eventListeners.clear();
        reset();
    }

    public synchronized GeoLocation getCenter() {
        return this.center;
    }

    public synchronized void setCenter(GeoLocation geoLocation) {
        this.center = geoLocation;
        if (hasListeners() != null) {
            setupQueries();
        }
    }

    public synchronized double getRadius() {
        return this.radius / 1000.0d;
    }

    public synchronized void setRadius(double d) {
        this.radius = GeoUtils.capRadius(d) * 1000.0d;
        if (hasListeners() != null) {
            setupQueries();
        }
    }

    public synchronized void setLocation(GeoLocation geoLocation, double d) {
        this.center = geoLocation;
        this.radius = GeoUtils.capRadius(d) * 1000.0d;
        if (hasListeners() != null) {
            setupQueries();
        }
    }
}

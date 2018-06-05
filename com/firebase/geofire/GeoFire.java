package com.firebase.geofire;

import com.firebase.geofire.core.GeoHash;
import com.firebase.geofire.util.GeoUtils;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class GeoFire {
    public static Logger LOGGER = Logger.getLogger("GeoFire");
    private final DatabaseReference databaseReference;
    private final EventRaiser eventRaiser;

    public interface CompletionListener {
        void onComplete(String str, DatabaseError databaseError);
    }

    static class C05351 extends GenericTypeIndicator<Map<String, Object>> {
        C05351() {
        }
    }

    private static class LocationValueEventListener implements ValueEventListener {
        private final LocationCallback callback;

        LocationValueEventListener(LocationCallback locationCallback) {
            this.callback = locationCallback;
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getValue() == null) {
                this.callback.onLocationResult(dataSnapshot.getKey(), null);
                return;
            }
            GeoLocation locationValue = GeoFire.getLocationValue(dataSnapshot);
            if (locationValue != null) {
                this.callback.onLocationResult(dataSnapshot.getKey(), locationValue);
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("GeoFire data has invalid format: ");
            stringBuilder.append(dataSnapshot.getValue());
            this.callback.onCancelled(DatabaseError.fromException(new Throwable(stringBuilder.toString())));
        }

        public void onCancelled(DatabaseError databaseError) {
            this.callback.onCancelled(databaseError);
        }
    }

    public static com.firebase.geofire.GeoLocation getLocationValue(com.google.firebase.database.DataSnapshot r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = 0;
        r1 = new com.firebase.geofire.GeoFire$1;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1.<init>();	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6 = r6.getValue(r1);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6 = (java.util.Map) r6;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1 = "l";	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6 = r6.get(r1);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6 = (java.util.List) r6;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1 = 0;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1 = r6.get(r1);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1 = (java.lang.Number) r1;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r2 = 1;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r2 = r6.get(r2);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r2 = (java.lang.Number) r2;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r3 = r1.doubleValue();	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r1 = r2.doubleValue();	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6 = r6.size();	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r5 = 2;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        if (r6 != r5) goto L_0x003d;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
    L_0x0031:
        r6 = com.firebase.geofire.GeoLocation.coordinatesValid(r3, r1);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        if (r6 == 0) goto L_0x003d;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
    L_0x0037:
        r6 = new com.firebase.geofire.GeoLocation;	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        r6.<init>(r3, r1);	 Catch:{ NullPointerException -> 0x003f, ClassCastException -> 0x003e }
        return r6;
    L_0x003d:
        return r0;
    L_0x003e:
        return r0;
    L_0x003f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.geofire.GeoFire.getLocationValue(com.google.firebase.database.DataSnapshot):com.firebase.geofire.GeoLocation");
    }

    public GeoFire(com.google.firebase.database.DatabaseReference r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = this;
        r0.<init>();
        r0.databaseReference = r1;
        r1 = new com.firebase.geofire.AndroidEventRaiser;	 Catch:{ Throwable -> 0x000b }
        r1.<init>();	 Catch:{ Throwable -> 0x000b }
        goto L_0x0010;
    L_0x000b:
        r1 = new com.firebase.geofire.ThreadEventRaiser;
        r1.<init>();
    L_0x0010:
        r0.eventRaiser = r1;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.firebase.geofire.GeoFire.<init>(com.google.firebase.database.DatabaseReference):void");
    }

    public DatabaseReference getDatabaseReference() {
        return this.databaseReference;
    }

    DatabaseReference getDatabaseRefForKey(String str) {
        return this.databaseReference.child(str);
    }

    public void setLocation(String str, GeoLocation geoLocation) {
        setLocation(str, geoLocation, null);
    }

    public void setLocation(final String str, GeoLocation geoLocation, final CompletionListener completionListener) {
        if (str == null) {
            throw new NullPointerException();
        }
        DatabaseReference databaseRefForKey = getDatabaseRefForKey(str);
        GeoHash geoHash = new GeoHash(geoLocation);
        Map hashMap = new HashMap();
        hashMap.put("g", geoHash.getGeoHashString());
        hashMap.put("l", Arrays.asList(new Double[]{Double.valueOf(geoLocation.latitude), Double.valueOf(geoLocation.longitude)}));
        if (completionListener != null) {
            databaseRefForKey.setValue(hashMap, geoHash.getGeoHashString(), new com.google.firebase.database.DatabaseReference.CompletionListener() {
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    completionListener.onComplete(str, databaseError);
                }
            });
        } else {
            databaseRefForKey.setValue((Object) hashMap, (Object) geoHash.getGeoHashString());
        }
    }

    public void removeLocation(String str) {
        removeLocation(str, null);
    }

    public void removeLocation(final String str, final CompletionListener completionListener) {
        if (str == null) {
            throw new NullPointerException();
        }
        DatabaseReference databaseRefForKey = getDatabaseRefForKey(str);
        if (completionListener != null) {
            databaseRefForKey.setValue(null, new com.google.firebase.database.DatabaseReference.CompletionListener() {
                public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                    completionListener.onComplete(str, databaseError);
                }
            });
        } else {
            databaseRefForKey.setValue(null);
        }
    }

    public void getLocation(String str, LocationCallback locationCallback) {
        getDatabaseRefForKey(str).addListenerForSingleValueEvent(new LocationValueEventListener(locationCallback));
    }

    public GeoQuery queryAtLocation(GeoLocation geoLocation, double d) {
        return new GeoQuery(this, geoLocation, GeoUtils.capRadius(d));
    }

    public void raiseEvent(Runnable runnable) {
        this.eventRaiser.raiseEvent(runnable);
    }
}

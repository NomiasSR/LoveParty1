package com.cicari.p001270.gaveta;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoFire.CompletionListener;
import com.firebase.geofire.GeoLocation;
import com.firebase.geofire.GeoQuery;
import com.firebase.geofire.GeoQueryDataEventListener;
import com.firebase.geofire.GeoQueryEventListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapFragment extends Fragment implements OnMapReadyCallback, OnCameraChangeListener, OnMarkerClickListener, GeoQueryEventListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final GeoLocation INITIAL_CENTER = new GeoLocation(51.51211166666667d, -0.11725333333333333d);
    private static final int INITIAL_ZOOM_LEVEL = 14;
    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 0;
    private static final long MIN_TIME_BW_UPDATES = 20;
    private String TAG = "testeclass";
    private final int THREAD_TIME = 5000;
    private String URL_FIREBASESTORAGE = "gs://gaveta-ae710.appspot.com";
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapterMeusTopicos;
    private AlertDialog alerta;
    CameraPosition cameraPosition = null;
    public Circle circle = null;
    private int contador = 0;
    private int contadorContatos;
    private LatLng currentLatLng = new LatLng(51.51211166666667d, -0.11725333333333333d);
    CameraPosition currentPosition;
    public DatabaseReference dbr1;
    private TextView edFilter;
    public FirebaseUser fireBaseAccount;
    public GeoFire geoFire;
    public DatabaseReference geoFireRef = FirebaseDatabase.getInstance().getReference("User_location");
    private GeoQuery geoQuery;
    public ImageView imgUsuarios;
    public LayoutInflater li;
    private List<Marker> listaTopicos;
    private List<String> listeMeusTopicos;
    private List<String> listeTopicosSeekBar;
    LocationListener locationListenerGPS = new C03385();
    LocationManager locationManager;
    private ListView lv1 = null;
    private ListView lvMeusTopicos = null;
    private FirebaseAuth mAuth;
    Context mContext;
    private DatabaseReference mDatabaseReferenceCadastro;
    private DatabaseReference mDatabaseReferencePesquisa;
    private DatabaseReference mDatabaseReferencePesquisa1;
    private OnCommunicateInterface mListener;
    private OnCommunicateInterfaceFriends mListenerFriends;
    private GoogleMap mMap;
    private Marker mMarcadorActual;
    private String mParam1;
    private String mParam2;
    private HashMap<String, Marker> markerContatos;
    private HashMap<String, Marker> markerContatosGeoFire = new HashMap();
    public MarkerOptions markerOptionsPersonagemPrincipal;
    public Marker markerPrincipal = null;
    private Marker markerTemp = null;
    public View markerUsuarios;
    private Map<String, Marker> markers;
    public String mensagemDadosUsuario;
    public MarkerOptions moGeoFire;
    public LatLng paramLatLng;
    final Polyline[] polyline = new Polyline[]{null};
    public int primeiro = 0;
    boolean retornoIsLocationEnabled;
    private ArrayList<String[]> rota = new ArrayList();
    private int rotaIndice = 0;
    private ArrayList<Marker> rotaMarker = new ArrayList();
    private SeekBar sb1;
    private Circle searchCircle;
    private StorageReference storageRef;
    private ArrayList<String[]> topicos = new ArrayList();
    private User user;
    public View view;

    class C03385 implements LocationListener {
        public void onProviderDisabled(String str) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        C03385() {
        }

        public void onLocationChanged(Location location) {
            MapFragment.this.setParamLatLng(new LatLng(location.getLatitude(), location.getLongitude()));
        }
    }

    class C03419 implements OnClickListener {
        C03419() {
        }

        public void onClick(View view) {
            MapFragment.this.moverPersonagem(MapFragment.this.markerPrincipal, MapFragment.this.searchCircle, MapFragment.this.getParamLatLng());
            MapFragment.this.changeCamera(MapFragment.this.mMap, MapFragment.this.getParamLatLng(), 18.3f, 90.0f, 10.0f);
        }
    }

    class C05102 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05102() {
        }

        public void onDataChange(final DataSnapshot dataSnapshot) {
            if (dataSnapshot.child("logado").getValue().toString().contains("s")) {
                final boolean booleanValue = ((Boolean) dataSnapshot.child("visible").getValue()).booleanValue();
                dataSnapshot.child("email").getValue().toString();
                String obj = dataSnapshot.child("name").getValue().toString();
                String obj2 = dataSnapshot.child("posicao").child("lat").getValue().toString();
                String obj3 = dataSnapshot.child("posicao").child("lng").getValue().toString();
                String obj4 = dataSnapshot.child("hashtag").getValue().toString();
                String obj5 = dataSnapshot.child("id").getValue().toString();
                String obj6 = dataSnapshot.child("image_profile").getValue().toString();
                MapFragment mapFragment = MapFragment.this;
                MarkerOptions position = new MarkerOptions().position(new LatLng((double) Float.parseFloat(obj2), (double) Float.parseFloat(obj3)));
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Shared hashtags (");
                stringBuilder.append(obj4);
                stringBuilder.append(")\nfrom ");
                stringBuilder.append(obj);
                mapFragment.moGeoFire = position.title(stringBuilder.toString()).snippet("").visible(true);
                MapFragment mapFragment2 = MapFragment.this;
                StorageReference referenceFromUrl = FirebaseStorage.getInstance().getReferenceFromUrl(MapFragment.this.URL_FIREBASESTORAGE);
                stringBuilder = new StringBuilder();
                stringBuilder.append("Photos/Users/");
                stringBuilder.append(obj5);
                mapFragment2.storageRef = referenceFromUrl.child(stringBuilder.toString());
                if (MapFragment.this.isAdded()) {
                    Glide.with(MapFragment.this.getActivity()).load(obj6).asBitmap().into(new SimpleTarget<Bitmap>() {
                        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                            glideAnimation = (int) ((BitmapDescriptorFactory.HUE_ORANGE * MapFragment.this.getContext().getResources().getDisplayMetrics().density) + 0.3f);
                            bitmap = Bitmap.createScaledBitmap(bitmap, glideAnimation, glideAnimation, true);
                            if (booleanValue != null) {
                                MapFragment.this.imgUsuarios.setImageBitmap(bitmap);
                                MapFragment.this.moGeoFire.icon(BitmapDescriptorFactory.fromBitmap(MapFragment.createDrawableFromView(MapFragment.this.getContext(), MapFragment.this.markerUsuarios)));
                            } else {
                                MapFragment.this.moGeoFire.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.transparente));
                            }
                            MapFragment.this.markerContatosGeoFire.put(dataSnapshot.getKey(), MapFragment.this.mMap.addMarker(MapFragment.this.moGeoFire));
                        }

                        public void onLoadFailed(Exception exception, Drawable drawable) {
                            if (booleanValue != null) {
                                MapFragment.this.imgUsuarios.setImageResource(C0346R.drawable.cicari_user18);
                                MapFragment.this.moGeoFire.icon(BitmapDescriptorFactory.fromBitmap(MapFragment.createDrawableFromView(MapFragment.this.getContext(), MapFragment.this.markerUsuarios)));
                            } else {
                                MapFragment.this.moGeoFire.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.transparente));
                            }
                            MapFragment.this.markerContatosGeoFire.put(dataSnapshot.getKey(), MapFragment.this.mMap.addMarker(MapFragment.this.moGeoFire));
                        }
                    });
                }
            }
        }
    }

    class C05134 implements ValueEventListener {

        class C05681 extends SimpleTarget<Bitmap> {
            C05681() {
            }

            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                if (MapFragment.this.markerPrincipal != null) {
                    MapFragment.this.markerPrincipal.remove();
                }
                glideAnimation = (int) ((BitmapDescriptorFactory.HUE_ORANGE * MapFragment.this.getContext().getResources().getDisplayMetrics().density) + 0.3f);
                MapFragment.this.imgUsuarios.setImageBitmap(Bitmap.createScaledBitmap(bitmap, glideAnimation, glideAnimation, true));
                MapFragment.this.markerOptionsPersonagemPrincipal.icon(BitmapDescriptorFactory.fromBitmap(MapFragment.createDrawableFromView(MapFragment.this.getContext(), MapFragment.this.markerUsuarios)));
                MapFragment.this.criarPersonagemPrincipal(MapFragment.this.currentLatLng);
            }

            public void onLoadFailed(Exception exception, Drawable drawable) {
                if (MapFragment.this.markerPrincipal != null) {
                    MapFragment.this.markerPrincipal.remove();
                    MapFragment.this.circle.remove();
                }
                MapFragment.this.markerOptionsPersonagemPrincipal.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.cicari_user18));
                MapFragment.this.criarPersonagemPrincipal(MapFragment.this.currentLatLng);
            }
        }

        C05134() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            String obj = dataSnapshot.getValue().toString();
            MapFragment mapFragment = MapFragment.this;
            StorageReference referenceFromUrl = FirebaseStorage.getInstance().getReferenceFromUrl(MapFragment.this.URL_FIREBASESTORAGE);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Photos/Users/");
            stringBuilder.append(FirebaseAuth.getInstance().getUid());
            mapFragment.storageRef = referenceFromUrl.child(stringBuilder.toString());
            if (MapFragment.this.isAdded()) {
                Glide.with(MapFragment.this.getContext()).load(obj).asBitmap().into(new C05681());
                return;
            }
            if (MapFragment.this.markerPrincipal != null) {
                MapFragment.this.markerPrincipal.remove();
            }
            MapFragment.this.markerOptionsPersonagemPrincipal.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.cicari_user18));
            MapFragment.this.criarPersonagemPrincipal(MapFragment.this.currentLatLng);
        }

        public void onCancelled(DatabaseError databaseError) {
            MapFragment.this.markerPrincipal.remove();
            MapFragment.this.markerOptionsPersonagemPrincipal.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.cicari_user18));
        }
    }

    public void changeMapSatellite(int i) {
    }

    public void onGeoQueryError(DatabaseError databaseError) {
    }

    public void onGeoQueryReady() {
    }

    public void onDestroy() {
        Thread.interrupted();
        super.onDestroy();
    }

    public static Bitmap createDrawableFromView(Context context, View view) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        view.setLayoutParams(new LayoutParams(-2, -2));
        view.measure(displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        view.buildDrawingCache();
        context = Bitmap.createBitmap(view.getMeasuredWidth(), view.getMeasuredHeight(), Config.ARGB_8888);
        view.draw(new Canvas(context));
        return context;
    }

    private void createItemsOnMap() {
        this.mDatabaseReferenceCadastro = FirebaseDatabase.getInstance().getReference();
        final String string = getResources().getString(C0346R.string._USUARIOS);
        getResources().getString(C0346R.string._POSICAO);
        getResources().getString(C0346R.string._CONTATOS);
        HashMap hashMap = new HashMap();
        this.mAuth = FirebaseAuth.getInstance();
        this.fireBaseAccount = this.mAuth.getCurrentUser();
        this.listaTopicos = new ArrayList();
        this.markerContatos = new HashMap();
        new ArrayList().add(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), C0346R.drawable.house32)));
        this.mDatabaseReferencePesquisa = FirebaseDatabase.getInstance().getReference().child(string).limitToFirst(50).getRef();
        this.mDatabaseReferencePesquisa.addValueEventListener(new ValueEventListener() {

            class C05081 implements ValueEventListener {
                public void onCancelled(DatabaseError databaseError) {
                }

                C05081() {
                }

                public void onDataChange(DataSnapshot dataSnapshot) {
                    final String obj = dataSnapshot.child("id").getValue().toString();
                    final boolean booleanValue = ((Boolean) dataSnapshot.child("visible").getValue()).booleanValue();
                    if (MapFragment.this.markerContatos.get(obj) != null) {
                        ((Marker) MapFragment.this.markerContatos.get(obj)).remove();
                    }
                    if (dataSnapshot.child("logado").getValue().toString().contains("s")) {
                        dataSnapshot.child("email").getValue().toString();
                        String obj2 = dataSnapshot.child("name").getValue().toString();
                        String obj3 = dataSnapshot.child("posicao").child("lat").getValue().toString();
                        String obj4 = dataSnapshot.child("posicao").child("lng").getValue().toString();
                        String obj5 = dataSnapshot.child("hashtag").getValue().toString();
                        String obj6 = dataSnapshot.child("id").getValue().toString();
                        String obj7 = dataSnapshot.child("image_profile").getValue().toString();
                        MarkerOptions position = new MarkerOptions().position(new LatLng((double) Float.parseFloat(obj3), (double) Float.parseFloat(obj4)));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Shared hashtags (");
                        stringBuilder.append(obj5);
                        stringBuilder.append(")\nfrom ");
                        stringBuilder.append(obj2);
                        final MarkerOptions visible = position.title(stringBuilder.toString()).snippet("").visible(false);
                        MapFragment mapFragment = MapFragment.this;
                        StorageReference referenceFromUrl = FirebaseStorage.getInstance().getReferenceFromUrl(MapFragment.this.URL_FIREBASESTORAGE);
                        StringBuilder stringBuilder2 = new StringBuilder();
                        stringBuilder2.append("Photos/Users/");
                        stringBuilder2.append(obj6);
                        mapFragment.storageRef = referenceFromUrl.child(stringBuilder2.toString());
                        if (MapFragment.this.isAdded()) {
                            Glide.with(MapFragment.this.getActivity()).load(obj7).asBitmap().into(new SimpleTarget<Bitmap>() {
                                public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                                    glideAnimation = (int) ((BitmapDescriptorFactory.HUE_ORANGE * MapFragment.this.getContext().getResources().getDisplayMetrics().density) + 0.3f);
                                    bitmap = Bitmap.createScaledBitmap(bitmap, glideAnimation, glideAnimation, true);
                                    if (booleanValue != null) {
                                        MapFragment.this.imgUsuarios.setImageBitmap(bitmap);
                                        visible.icon(BitmapDescriptorFactory.fromBitmap(MapFragment.createDrawableFromView(MapFragment.this.getContext(), MapFragment.this.markerUsuarios)));
                                    } else {
                                        visible.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.transparente));
                                    }
                                    MapFragment.this.markerContatos.put(obj, MapFragment.this.mMap.addMarker(visible));
                                }

                                public void onLoadFailed(Exception exception, Drawable drawable) {
                                    if (booleanValue != null) {
                                        MapFragment.this.imgUsuarios.setImageResource(C0346R.drawable.cicari_user18);
                                        visible.icon(BitmapDescriptorFactory.fromBitmap(MapFragment.createDrawableFromView(MapFragment.this.getContext(), MapFragment.this.markerUsuarios)));
                                    } else {
                                        visible.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.transparente));
                                    }
                                    MapFragment.this.markerContatos.put(obj, MapFragment.this.mMap.addMarker(visible));
                                }
                            });
                        }
                    }
                }
            }

            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(com.google.firebase.database.DataSnapshot r6) {
                /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
                /*
                r5 = this;
                r6 = r6.getChildren();
                r6 = r6.iterator();
            L_0x0008:
                r0 = r6.hasNext();
                if (r0 == 0) goto L_0x0075;
            L_0x000e:
                r0 = r6.next();
                r0 = (com.google.firebase.database.DataSnapshot) r0;
                r1 = "id";	 Catch:{ Exception -> 0x0008 }
                r1 = r0.child(r1);	 Catch:{ Exception -> 0x0008 }
                r1 = r1.getValue();	 Catch:{ Exception -> 0x0008 }
                r1 = r1.toString();	 Catch:{ Exception -> 0x0008 }
                r2 = com.google.firebase.auth.FirebaseAuth.getInstance();	 Catch:{ Exception -> 0x0008 }
                r2 = r2.getCurrentUser();	 Catch:{ Exception -> 0x0008 }
                r2 = r2.getUid();	 Catch:{ Exception -> 0x0008 }
                r1 = r1.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x0008 }
                if (r1 != 0) goto L_0x0008;	 Catch:{ Exception -> 0x0008 }
            L_0x0034:
                r1 = com.cicari.p001270.gaveta.MapFragment.this;	 Catch:{ Exception -> 0x0008 }
                r2 = com.google.firebase.database.FirebaseDatabase.getInstance();	 Catch:{ Exception -> 0x0008 }
                r2 = r2.getReference();	 Catch:{ Exception -> 0x0008 }
                r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0008 }
                r3.<init>();	 Catch:{ Exception -> 0x0008 }
                r4 = r0;	 Catch:{ Exception -> 0x0008 }
                r3.append(r4);	 Catch:{ Exception -> 0x0008 }
                r4 = "/";	 Catch:{ Exception -> 0x0008 }
                r3.append(r4);	 Catch:{ Exception -> 0x0008 }
                r4 = "id";	 Catch:{ Exception -> 0x0008 }
                r0 = r0.child(r4);	 Catch:{ Exception -> 0x0008 }
                r0 = r0.getValue();	 Catch:{ Exception -> 0x0008 }
                r0 = r0.toString();	 Catch:{ Exception -> 0x0008 }
                r3.append(r0);	 Catch:{ Exception -> 0x0008 }
                r0 = r3.toString();	 Catch:{ Exception -> 0x0008 }
                r0 = r2.child(r0);	 Catch:{ Exception -> 0x0008 }
                r1.dbr1 = r0;	 Catch:{ Exception -> 0x0008 }
                r0 = com.cicari.p001270.gaveta.MapFragment.this;	 Catch:{ Exception -> 0x0008 }
                r0 = r0.dbr1;	 Catch:{ Exception -> 0x0008 }
                r1 = new com.cicari.p001270.gaveta.MapFragment$1$1;	 Catch:{ Exception -> 0x0008 }
                r1.<init>();	 Catch:{ Exception -> 0x0008 }
                r0.addValueEventListener(r1);	 Catch:{ Exception -> 0x0008 }
                goto L_0x0008;
            L_0x0075:
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MapFragment.1.onDataChange(com.google.firebase.database.DataSnapshot):void");
            }
        });
    }

    private void criarMarkerGeoFire(DataSnapshot dataSnapshot) {
        FirebaseDatabase instance = FirebaseDatabase.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("usuarios/");
        stringBuilder.append(dataSnapshot.getKey());
        this.mDatabaseReferencePesquisa = instance.getReference(stringBuilder.toString());
        this.mDatabaseReferencePesquisa.addListenerForSingleValueEvent(new C05102());
    }

    private void geoFireLocate(LatLng latLng) {
        new ArrayList().add(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(getResources(), C0346R.drawable.house32)));
        final ArrayList arrayList = new ArrayList();
        String str = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Radius: ");
        stringBuilder.append(0.0045d);
        Log.d(str, stringBuilder.toString());
        this.geoFire.queryAtLocation(new GeoLocation(latLng.latitude, latLng.longitude), 0.06d).addGeoQueryDataEventListener(new GeoQueryDataEventListener() {

            class C05111 implements ValueEventListener {
                public void onCancelled(DatabaseError databaseError) {
                }

                C05111() {
                }

                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.child("logado").getValue().toString().contains("s")) {
                        String obj = dataSnapshot.child("name").getValue().toString();
                        String obj2 = dataSnapshot.child("posicao").child("lat").getValue().toString();
                        String obj3 = dataSnapshot.child("posicao").child("lng").getValue().toString();
                        String obj4 = dataSnapshot.child("hashtag").getValue().toString();
                        dataSnapshot = dataSnapshot.getKey();
                        MapFragment mapFragment = MapFragment.this;
                        MarkerOptions position = new MarkerOptions().position(new LatLng((double) Float.parseFloat(obj2), (double) Float.parseFloat(obj3)));
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Shared hashtags (");
                        stringBuilder.append(obj4);
                        stringBuilder.append(")\nfrom ");
                        stringBuilder.append(obj);
                        mapFragment.moGeoFire = position.title(stringBuilder.toString()).snippet("").visible(true);
                        MapFragment.this.moGeoFire.icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.cicari_user18));
                        MapFragment.this.markerContatosGeoFire.put(dataSnapshot, MapFragment.this.mMap.addMarker(MapFragment.this.moGeoFire));
                    }
                }
            }

            public void onDataChanged(DataSnapshot dataSnapshot, GeoLocation geoLocation) {
            }

            public void onGeoQueryError(DatabaseError databaseError) {
            }

            public void onDataEntered(DataSnapshot dataSnapshot, GeoLocation geoLocation) {
                if (dataSnapshot.getKey().equalsIgnoreCase(FirebaseAuth.getInstance().getCurrentUser().getUid()) == null) {
                    geoLocation = MapFragment.this.getContext();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(dataSnapshot.getKey());
                    stringBuilder.append(" esta proximo de voce ");
                    Toast.makeText(geoLocation, stringBuilder.toString(), 0).show();
                    if (MapFragment.this.markerContatosGeoFire.get(dataSnapshot.getKey()) != null) {
                        ((Marker) MapFragment.this.markerContatosGeoFire.get(dataSnapshot.getKey())).setVisible(true);
                    } else {
                        arrayList.add(dataSnapshot.getKey());
                    }
                }
            }

            public void onDataExited(DataSnapshot dataSnapshot) {
                Context context = MapFragment.this.getContext();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(dataSnapshot.getKey());
                stringBuilder.append(" SAIU da sua area de acao");
                Toast.makeText(context, stringBuilder.toString(), 0).show();
                if (!dataSnapshot.getKey().equalsIgnoreCase(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
                    context = MapFragment.this.getContext();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dataSnapshot.getKey());
                    stringBuilder.append(" SAIU da sua area de acao");
                    Toast.makeText(context, stringBuilder.toString(), 0).show();
                    ((Marker) MapFragment.this.markerContatosGeoFire.get(dataSnapshot.getKey())).setVisible(false);
                }
            }

            public void onDataMoved(DataSnapshot dataSnapshot, GeoLocation geoLocation) {
                if (dataSnapshot.getKey().equalsIgnoreCase(FirebaseAuth.getInstance().getCurrentUser().getUid()) == null) {
                    geoLocation = MapFragment.this.getContext();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(dataSnapshot.getKey());
                    stringBuilder.append(" SE MEXEU da sua area de acao");
                    Toast.makeText(geoLocation, stringBuilder.toString(), 0).show();
                }
            }

            public void onGeoQueryReady() {
                if (arrayList.size() > 0) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        MapFragment mapFragment = MapFragment.this;
                        FirebaseDatabase instance = FirebaseDatabase.getInstance();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("usuarios/");
                        stringBuilder.append(str);
                        mapFragment.mDatabaseReferencePesquisa = instance.getReference(stringBuilder.toString());
                        MapFragment.this.mDatabaseReferencePesquisa.addListenerForSingleValueEvent(new C05111());
                    }
                }
            }
        });
    }

    public void getProfileImage() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("usuarios/");
        stringBuilder.append(FirebaseAuth.getInstance().getUid());
        stringBuilder.append("/image_profile/");
        this.mDatabaseReferencePesquisa = reference.child(stringBuilder.toString());
        this.mDatabaseReferencePesquisa.addValueEventListener(new C05134());
    }

    public void criarPersonagemPrincipal(LatLng latLng) {
        this.markerPrincipal = this.mMap.addMarker(this.markerOptionsPersonagemPrincipal);
    }

    public static MapFragment newInstance(String str, String str2) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    private boolean isLocationEnabled() {
        this.retornoIsLocationEnabled = false;
        return this.retornoIsLocationEnabled;
    }

    public void onResume() {
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
        super.onResume();
        r0.isLocationEnabled();	 Catch:{ Exception -> 0x0006 }
    L_0x0006:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MapFragment.onResume():void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        viewGroup = layoutInflater.inflate(C0346R.layout.map_fragment, viewGroup, false);
        this.markerUsuarios = layoutInflater.inflate(C0346R.layout.custom_marker_layout, null);
        this.imgUsuarios = (ImageView) this.markerUsuarios.findViewById(C0346R.id.imgInner);
        this.user = new User(getResources(), getContext());
        ((SupportMapFragment) getChildFragmentManager().findFragmentById(C0346R.id.map)).getMapAsync(this);
        return viewGroup;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCommunicateInterface) {
            this.mListener = (OnCommunicateInterface) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnCommunicateInterface");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
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
        r1 = this;
        super.onDetach();
        r0 = r1.markerPrincipal;	 Catch:{ Exception -> 0x000d }
        r0.remove();	 Catch:{ Exception -> 0x000d }
        r0 = r1.circle;	 Catch:{ Exception -> 0x000d }
        r0.remove();	 Catch:{ Exception -> 0x000d }
    L_0x000d:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MapFragment.onDetach():void");
    }

    public void changeMapType(int i) {
        this.mMap.setMapType(i);
    }

    private void changeCamera(GoogleMap googleMap, LatLng latLng, float f, float f2, float f3) {
        this.cameraPosition = new Builder().target(latLng).zoom(f).bearing(f2).tilt(f3).build();
        if (googleMap != null) {
            googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(this.cameraPosition));
        } else {
            Toast.makeText(getContext(), getString(C0346R.string.nomap_error), Float.MIN_VALUE).show();
        }
    }

    private void setParamLatLng(LatLng latLng) {
        this.paramLatLng = latLng;
    }

    private LatLng getParamLatLng() {
        return this.paramLatLng;
    }

    private void animateMarkerTo(Marker marker, double d, double d2) {
        Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final Interpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        final LatLng position = marker.getPosition();
        final double d3 = d;
        final double d4 = d2;
        final Marker marker2 = marker;
        final Handler handler2 = handler;
        handler.post(new Runnable() {
            public void run() {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - uptimeMillis)) / 1000.0f;
                double interpolation = (double) accelerateDecelerateInterpolator.getInterpolation(uptimeMillis);
                marker2.setPosition(new LatLng(((d3 - position.latitude) * interpolation) + position.latitude, ((d4 - position.longitude) * interpolation) + position.longitude));
                if (uptimeMillis < 1.0f) {
                    handler2.postDelayed(this, 16);
                }
            }
        });
    }

    private double zoomLevelToRadius(double d) {
        return 1.6384E7d / Math.pow(2.0d, d);
    }

    public void onCameraChange(CameraPosition cameraPosition) {
        LatLng latLng = cameraPosition.target;
        double zoomLevelToRadius = zoomLevelToRadius((double) cameraPosition.zoom);
        this.searchCircle.setCenter(latLng);
        this.searchCircle.setRadius(zoomLevelToRadius);
        this.geoQuery.setCenter(new GeoLocation(latLng.latitude, latLng.longitude));
        this.geoQuery.setRadius(zoomLevelToRadius / 1000.0d);
    }

    public boolean onMarkerClick(Marker marker) {
        marker.showInfoWindow();
        return true;
    }

    public void moverPersonagem(Marker marker, Circle circle, LatLng latLng) {
        final LatLng latLng2 = latLng;
        final LatLng position = marker.getPosition();
        Handler handler = new Handler();
        final long uptimeMillis = SystemClock.uptimeMillis();
        final Interpolator accelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
        this.geoFire.setLocation(FirebaseAuth.getInstance().getCurrentUser().getUid(), new GeoLocation(latLng2.latitude, latLng2.longitude), new CompletionListener() {
            public void onComplete(String str, DatabaseError databaseError) {
                MapFragment.this.mListener.limparDadosMapa();
                MapFragment.this.setParamLatLng(latLng2);
                MapFragment.this.pesquisar();
            }
        });
        final Marker marker2 = marker;
        final Circle circle2 = circle;
        final Handler handler2 = handler;
        handler.post(new Runnable() {
            long elapsed;
            float f11t;
            float f12v;

            public void run() {
                this.elapsed = SystemClock.uptimeMillis() - uptimeMillis;
                this.f11t = ((float) this.elapsed) / 1000.0f;
                this.f12v = accelerateDecelerateInterpolator.getInterpolation(this.f11t);
                LatLng latLng = new LatLng((position.latitude * ((double) (1.0f - this.f11t))) + (latLng2.latitude * ((double) this.f11t)), (position.longitude * ((double) (1.0f - this.f11t))) + (latLng2.longitude * ((double) this.f11t)));
                marker2.setPosition(latLng);
                circle2.setCenter(latLng);
                if (this.f11t < 1.0f) {
                    handler2.postDelayed(this, 16);
                } else {
                    marker2.setVisible(true);
                }
            }
        });
    }

    public void onMapReady(com.google.android.gms.maps.GoogleMap r12) {
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
        r11 = this;
        r0 = r11.getContext();
        r11.mContext = r0;
        r0 = r11.mContext;
        r1 = "location";
        r0 = r0.getSystemService(r1);
        r0 = (android.location.LocationManager) r0;
        r11.locationManager = r0;
        r0 = r11.getContext();
        r1 = "android.permission.ACCESS_FINE_LOCATION";
        r0 = android.support.v4.content.ContextCompat.checkSelfPermission(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x001e:
        r0 = r11.getContext();
        r1 = "android.permission.ACCESS_COARSE_LOCATION";
        r0 = android.support.v4.content.ContextCompat.checkSelfPermission(r0, r1);
        if (r0 == 0) goto L_0x003b;
    L_0x002a:
        r12 = r11.getContext();
        r12 = (android.app.Activity) r12;
        r0 = "android.permission.ACCESS_FINE_LOCATION";
        r0 = new java.lang.String[]{r0};
        r1 = 1;
        android.support.v4.app.ActivityCompat.requestPermissions(r12, r0, r1);
        return;
    L_0x003b:
        r0 = new com.google.android.gms.maps.model.LatLng;	 Catch:{ Exception -> 0x005a }
        r1 = r11.locationManager;	 Catch:{ Exception -> 0x005a }
        r2 = "gps";	 Catch:{ Exception -> 0x005a }
        r1 = r1.getLastKnownLocation(r2);	 Catch:{ Exception -> 0x005a }
        r1 = r1.getLatitude();	 Catch:{ Exception -> 0x005a }
        r3 = r11.locationManager;	 Catch:{ Exception -> 0x005a }
        r4 = "gps";	 Catch:{ Exception -> 0x005a }
        r3 = r3.getLastKnownLocation(r4);	 Catch:{ Exception -> 0x005a }
        r3 = r3.getLongitude();	 Catch:{ Exception -> 0x005a }
        r0.<init>(r1, r3);	 Catch:{ Exception -> 0x005a }
        r11.currentLatLng = r0;	 Catch:{ Exception -> 0x005a }
    L_0x005a:
        r5 = r11.locationManager;
        r6 = "gps";
        r7 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
        r9 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r10 = r11.locationListenerGPS;
        r5.requestLocationUpdates(r6, r7, r9, r10);
        r11.isLocationEnabled();
        r0 = r11.getActivity();
        r1 = 2131230891; // 0x7f0800ab float:1.8077848E38 double:1.0529679666E-314;
        r0 = r0.findViewById(r1);
        r0 = (android.widget.SeekBar) r0;
        r11.sb1 = r0;
        r0 = r11.sb1;
        r1 = 50;
        r0.setProgress(r1);
        r11.mMap = r12;
        r4 = new com.google.android.gms.maps.model.LatLng;
        r12 = INITIAL_CENTER;
        r0 = r12.latitude;
        r12 = INITIAL_CENTER;
        r2 = r12.longitude;
        r4.<init>(r0, r2);
        r12 = r11.searchCircle;
        if (r12 == 0) goto L_0x00c1;
    L_0x0093:
        r12 = r11.searchCircle;
        r12.remove();
        r12 = r11.markerPrincipal;
        r12.remove();
        r12 = r11.mListener;
        r12.limparDadosMapa();
        r12 = r11.markers;
        r12 = r12.values();
        r12 = r12.iterator();
    L_0x00ac:
        r0 = r12.hasNext();
        if (r0 == 0) goto L_0x00bc;
    L_0x00b2:
        r0 = r12.next();
        r0 = (com.google.android.gms.maps.model.Marker) r0;
        r0.remove();
        goto L_0x00ac;
    L_0x00bc:
        r12 = r11.markers;
        r12.clear();
    L_0x00c1:
        r12 = r11.mMap;
        r0 = new com.google.android.gms.maps.model.CircleOptions;
        r0.<init>();
        r0 = r0.center(r4);
        r1 = r11.sb1;
        r1 = r1.getProgress();
        r1 = (double) r1;
        r0 = r0.radius(r1);
        r12 = r12.addCircle(r0);
        r11.searchCircle = r12;
        r12 = r11.searchCircle;
        r0 = 255; // 0xff float:3.57E-43 double:1.26E-321;
        r1 = 66;
        r2 = 0;
        r0 = android.graphics.Color.argb(r1, r0, r2, r0);
        r12.setFillColor(r0);
        r12 = r11.searchCircle;
        r0 = android.graphics.Color.argb(r1, r2, r2, r2);
        r12.setStrokeColor(r0);
        r12 = r11.mMap;
        r0 = 1096810496; // 0x41600000 float:14.0 double:5.41896386E-315;
        r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r4, r0);
        r12.moveCamera(r0);
        r12 = new com.firebase.geofire.GeoFire;
        r0 = com.google.firebase.database.FirebaseDatabase.getInstance();
        r1 = "User_location";
        r0 = r0.getReference(r1);
        r12.<init>(r0);
        r11.geoFire = r12;
        r12 = new com.google.android.gms.maps.model.MarkerOptions;
        r12.<init>();
        r12 = r12.position(r4);
        r0 = com.google.firebase.auth.FirebaseAuth.getInstance();
        r0 = r0.getCurrentUser();
        r0 = r0.getUid();
        r12 = r12.title(r0);
        r0 = "";
        r12 = r12.snippet(r0);
        r11.markerOptionsPersonagemPrincipal = r12;
        r12 = r11.mMap;
        r0 = r11.markerOptionsPersonagemPrincipal;
        r12 = r12.addMarker(r0);
        r11.markerPrincipal = r12;
        r11.getProfileImage();
        r12 = new java.util.HashMap;
        r12.<init>();
        r11.markers = r12;
        r12 = r11.markerPrincipal;
        r0 = r11.searchCircle;
        r11.moverPersonagem(r12, r0, r4);
        r3 = r11.mMap;
        r5 = 1100113510; // 0x41926666 float:18.3 double:5.43528292E-315;
        r6 = 1119092736; // 0x42b40000 float:90.0 double:5.529052754E-315;
        r7 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r2 = r11;
        r2.changeCamera(r3, r4, r5, r6, r7);
        r12 = r11.getActivity();
        r0 = 2131230765; // 0x7f08002d float:1.8077592E38 double:1.0529679043E-314;
        r12 = r12.findViewById(r0);
        r12 = (android.widget.Button) r12;
        r0 = new com.cicari.p001270.gaveta.MapFragment$9;
        r0.<init>();
        r12.setOnClickListener(r0);
        r12 = r11.mMap;
        r0 = new com.cicari.p001270.gaveta.MapFragment$10;
        r0.<init>();
        r12.setOnMapLongClickListener(r0);
        r12 = r11.mMap;
        r0 = new com.cicari.p001270.gaveta.MapFragment$11;
        r0.<init>();
        r12.setInfoWindowAdapter(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MapFragment.onMapReady(com.google.android.gms.maps.GoogleMap):void");
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void pesquisar() {
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
        r7 = this;
        r0 = r7.getParamLatLng();
        r1 = r7.geoQuery;	 Catch:{ Exception -> 0x0009 }
        r1.removeAllListeners();	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        r1 = r7.markers;
        if (r1 == 0) goto L_0x002c;
    L_0x000d:
        r1 = r7.markers;
        r1 = r1.values();
        r1 = r1.iterator();
    L_0x0017:
        r2 = r1.hasNext();
        if (r2 == 0) goto L_0x0027;
    L_0x001d:
        r2 = r1.next();
        r2 = (com.google.android.gms.maps.model.Marker) r2;
        r2.remove();
        goto L_0x0017;
    L_0x0027:
        r1 = r7.markers;
        r1.clear();
    L_0x002c:
        r1 = r7.geoFire;
        r2 = new com.firebase.geofire.GeoLocation;
        r3 = r0.latitude;
        r5 = r0.longitude;
        r2.<init>(r3, r5);
        r3 = 4587366580439587226; // 0x3fa999999999999a float:-1.5881868E-23 double:0.05;
        r0 = r1.queryAtLocation(r2, r3);
        r7.geoQuery = r0;
        r0 = r7.geoQuery;
        r0.addGeoQueryEventListener(r7);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.MapFragment.pesquisar():void");
    }

    public void onKeyEntered(final String str, final GeoLocation geoLocation) {
        if (!str.toString().equalsIgnoreCase(FirebaseAuth.getInstance().getCurrentUser().getUid())) {
            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("usuarios/");
            stringBuilder.append(str);
            this.dbr1 = reference.child(stringBuilder.toString());
            this.dbr1.addListenerForSingleValueEvent(new ValueEventListener() {
                public void onCancelled(DatabaseError databaseError) {
                }

                public void onDataChange(DataSnapshot dataSnapshot) {
                    dataSnapshot.child("email").getValue().toString();
                    String obj = dataSnapshot.child("name").getValue().toString();
                    dataSnapshot = dataSnapshot.child("hashtag").getValue().toString();
                    GoogleMap access$300 = MapFragment.this.mMap;
                    MarkerOptions position = new MarkerOptions().position(new LatLng(geoLocation.latitude, geoLocation.longitude));
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("User: ");
                    stringBuilder.append(obj);
                    stringBuilder.append("\nTopics: ");
                    stringBuilder.append(dataSnapshot);
                    MapFragment.this.markers.put(str, access$300.addMarker(position.title(stringBuilder.toString()).icon(BitmapDescriptorFactory.fromResource(C0346R.drawable.cicari_user18))));
                    OnCommunicateInterface access$800 = MapFragment.this.mListener;
                    StringBuilder stringBuilder2 = new StringBuilder();
                    stringBuilder2.append(str);
                    stringBuilder2.append("||");
                    stringBuilder2.append(obj);
                    String stringBuilder3 = stringBuilder2.toString();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(dataSnapshot);
                    stringBuilder.append(" (from user '");
                    stringBuilder.append(obj);
                    stringBuilder.append("')");
                    access$800.setDadosMapa(stringBuilder3, stringBuilder.toString());
                }
            });
        }
    }

    public void onKeyExited(String str) {
        Marker marker = (Marker) this.markers.get(str);
        if (marker != null) {
            marker.remove();
            this.markers.remove(str);
            this.mListener.removeDadosMapa(str);
        }
    }

    public void onKeyMoved(String str, GeoLocation geoLocation) {
        Marker marker = (Marker) this.markers.get(str);
        if (marker != null) {
            animateMarkerTo(marker, geoLocation.latitude, geoLocation.longitude);
        }
    }
}

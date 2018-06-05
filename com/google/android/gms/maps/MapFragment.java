package com.google.android.gms.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzo;
import com.google.android.gms.maps.internal.IMapFragmentDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
public class MapFragment extends Fragment {
    private final zzb zzisr = new zzb(this);

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private Activity mActivity;
        private final Fragment zzgwm;
        private zzo<zza> zzisu;
        private final List<OnMapReadyCallback> zzisv = new ArrayList();

        zzb(Fragment fragment) {
            this.zzgwm = fragment;
        }

        private final void setActivity(Activity activity) {
            this.mActivity = activity;
            zzawb();
        }

        private final void zzawb() {
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
            r4 = this;
            r0 = r4.mActivity;
            if (r0 == 0) goto L_0x005b;
        L_0x0004:
            r0 = r4.zzisu;
            if (r0 == 0) goto L_0x005b;
        L_0x0008:
            r0 = r4.zzapw();
            if (r0 != 0) goto L_0x005b;
        L_0x000e:
            r0 = r4.mActivity;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            com.google.android.gms.maps.MapsInitializer.initialize(r0);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0 = r4.mActivity;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0 = com.google.android.gms.maps.internal.zzbz.zzdt(r0);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r1 = r4.mActivity;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r1 = com.google.android.gms.dynamic.zzn.zzz(r1);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0 = r0.zzaa(r1);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            if (r0 != 0) goto L_0x0026;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
        L_0x0025:
            return;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
        L_0x0026:
            r1 = r4.zzisu;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r2 = new com.google.android.gms.maps.MapFragment$zza;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r3 = r4.zzgwm;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r2.<init>(r3, r0);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r1.zza(r2);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0 = r4.zzisv;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0 = r0.iterator();	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
        L_0x0038:
            r1 = r0.hasNext();	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            if (r1 == 0) goto L_0x004e;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
        L_0x003e:
            r1 = r0.next();	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r1 = (com.google.android.gms.maps.OnMapReadyCallback) r1;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r2 = r4.zzapw();	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r2 = (com.google.android.gms.maps.MapFragment.zza) r2;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r2.getMapAsync(r1);	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            goto L_0x0038;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
        L_0x004e:
            r0 = r4.zzisv;	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            r0.clear();	 Catch:{ RemoteException -> 0x0054, GooglePlayServicesNotAvailableException -> 0x005b }
            return;
        L_0x0054:
            r0 = move-exception;
            r1 = new com.google.android.gms.maps.model.RuntimeRemoteException;
            r1.<init>(r0);
            throw r1;
        L_0x005b:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.MapFragment.zzb.zzawb():void");
        }

        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            if (zzapw() != null) {
                ((zza) zzapw()).getMapAsync(onMapReadyCallback);
            } else {
                this.zzisv.add(onMapReadyCallback);
            }
        }

        protected final void zza(zzo<zza> com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_MapFragment_zza) {
            this.zzisu = com_google_android_gms_dynamic_zzo_com_google_android_gms_maps_MapFragment_zza;
            zzawb();
        }
    }

    static class zza implements MapLifecycleDelegate {
        private final Fragment zzgwm;
        private final IMapFragmentDelegate zziss;

        public zza(Fragment fragment, IMapFragmentDelegate iMapFragmentDelegate) {
            this.zziss = (IMapFragmentDelegate) zzbq.checkNotNull(iMapFragmentDelegate);
            this.zzgwm = (Fragment) zzbq.checkNotNull(fragment);
        }

        public final void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
            try {
                this.zziss.getMapAsync(new zzab(this, onMapReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                Bundle arguments = this.zzgwm.getArguments();
                if (arguments != null && arguments.containsKey("MapOptions")) {
                    zzby.zza(bundle2, "MapOptions", arguments.getParcelable("MapOptions"));
                }
                this.zziss.onCreate(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                IObjectWrapper onCreateView = this.zziss.onCreateView(zzn.zzz(layoutInflater), zzn.zzz(viewGroup), bundle2);
                zzby.zzd(bundle2, bundle);
                return (View) zzn.zzx(onCreateView);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroy() {
            try {
                this.zziss.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            try {
                this.zziss.onDestroyView();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onEnterAmbient(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zziss.onEnterAmbient(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onExitAmbient() {
            try {
                this.zziss.onExitAmbient();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            GoogleMapOptions googleMapOptions = (GoogleMapOptions) bundle.getParcelable("MapOptions");
            try {
                Bundle bundle3 = new Bundle();
                zzby.zzd(bundle2, bundle3);
                this.zziss.onInflate(zzn.zzz(activity), googleMapOptions, bundle3);
                zzby.zzd(bundle3, bundle2);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onLowMemory() {
            try {
                this.zziss.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.zziss.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.zziss.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zziss.onSaveInstanceState(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
            try {
                this.zziss.onStart();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStop() {
            try {
                this.zziss.onStop();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }
    }

    public static MapFragment newInstance() {
        return new MapFragment();
    }

    public static MapFragment newInstance(GoogleMapOptions googleMapOptions) {
        MapFragment mapFragment = new MapFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("MapOptions", googleMapOptions);
        mapFragment.setArguments(bundle);
        return mapFragment;
    }

    public void getMapAsync(OnMapReadyCallback onMapReadyCallback) {
        zzbq.zzge("getMapAsync must be called on the main thread.");
        this.zzisr.getMapAsync(onMapReadyCallback);
    }

    public void onActivityCreated(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.zzisr.setActivity(activity);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.zzisr.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = this.zzisr.onCreateView(layoutInflater, viewGroup, bundle);
        onCreateView.setClickable(true);
        return onCreateView;
    }

    public void onDestroy() {
        this.zzisr.onDestroy();
        super.onDestroy();
    }

    public void onDestroyView() {
        this.zzisr.onDestroyView();
        super.onDestroyView();
    }

    public final void onEnterAmbient(Bundle bundle) {
        zzbq.zzge("onEnterAmbient must be called on the main thread.");
        com.google.android.gms.dynamic.zza com_google_android_gms_dynamic_zza = this.zzisr;
        if (com_google_android_gms_dynamic_zza.zzapw() != null) {
            ((zza) com_google_android_gms_dynamic_zza.zzapw()).onEnterAmbient(bundle);
        }
    }

    public final void onExitAmbient() {
        zzbq.zzge("onExitAmbient must be called on the main thread.");
        com.google.android.gms.dynamic.zza com_google_android_gms_dynamic_zza = this.zzisr;
        if (com_google_android_gms_dynamic_zza.zzapw() != null) {
            ((zza) com_google_android_gms_dynamic_zza.zzapw()).onExitAmbient();
        }
    }

    @SuppressLint({"NewApi"})
    public void onInflate(Activity activity, AttributeSet attributeSet, Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            super.onInflate(activity, attributeSet, bundle);
            this.zzisr.setActivity(activity);
            Parcelable createFromAttributes = GoogleMapOptions.createFromAttributes(activity, attributeSet);
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("MapOptions", createFromAttributes);
            this.zzisr.onInflate(activity, bundle2, bundle);
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public void onLowMemory() {
        this.zzisr.onLowMemory();
        super.onLowMemory();
    }

    public void onPause() {
        this.zzisr.onPause();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.zzisr.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MapFragment.class.getClassLoader());
        }
        super.onSaveInstanceState(bundle);
        this.zzisr.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.zzisr.onStart();
    }

    public void onStop() {
        this.zzisr.onStop();
        super.onStop();
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
    }
}

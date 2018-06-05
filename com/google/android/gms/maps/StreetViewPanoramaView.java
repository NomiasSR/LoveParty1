package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.StrictMode;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode.ThreadPolicy.Builder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.dynamic.zzn;
import com.google.android.gms.dynamic.zzo;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.zzby;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.List;

public class StreetViewPanoramaView extends FrameLayout {
    private final zzb zzitu;

    static class zzb extends com.google.android.gms.dynamic.zza<zza> {
        private zzo<zza> zzisu;
        private final ViewGroup zzita;
        private final Context zzitb;
        private final List<OnStreetViewPanoramaReadyCallback> zzitm = new ArrayList();
        private final StreetViewPanoramaOptions zzitx;

        zzb(ViewGroup viewGroup, Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
            this.zzita = viewGroup;
            this.zzitb = context;
            this.zzitx = streetViewPanoramaOptions;
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            if (zzapw() != null) {
                ((zza) zzapw()).getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
            } else {
                this.zzitm.add(onStreetViewPanoramaReadyCallback);
            }
        }

        protected final void zza(com.google.android.gms.dynamic.zzo<com.google.android.gms.maps.StreetViewPanoramaView.zza> r4) {
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
            r3 = this;
            r3.zzisu = r4;
            r4 = r3.zzisu;
            if (r4 == 0) goto L_0x0058;
        L_0x0006:
            r4 = r3.zzapw();
            if (r4 != 0) goto L_0x0058;
        L_0x000c:
            r4 = r3.zzitb;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            com.google.android.gms.maps.MapsInitializer.initialize(r4);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4 = r3.zzitb;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4 = com.google.android.gms.maps.internal.zzbz.zzdt(r4);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r0 = r3.zzitb;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r0 = com.google.android.gms.dynamic.zzn.zzz(r0);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1 = r3.zzitx;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4 = r4.zza(r0, r1);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r0 = r3.zzisu;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1 = new com.google.android.gms.maps.StreetViewPanoramaView$zza;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r2 = r3.zzita;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1.<init>(r2, r4);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r0.zza(r1);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4 = r3.zzitm;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4 = r4.iterator();	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
        L_0x0035:
            r0 = r4.hasNext();	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            if (r0 == 0) goto L_0x004b;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
        L_0x003b:
            r0 = r4.next();	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r0 = (com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback) r0;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1 = r3.zzapw();	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1 = (com.google.android.gms.maps.StreetViewPanoramaView.zza) r1;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r1.getStreetViewPanoramaAsync(r0);	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            goto L_0x0035;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
        L_0x004b:
            r4 = r3.zzitm;	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            r4.clear();	 Catch:{ RemoteException -> 0x0051, GooglePlayServicesNotAvailableException -> 0x0058 }
            return;
        L_0x0051:
            r4 = move-exception;
            r0 = new com.google.android.gms.maps.model.RuntimeRemoteException;
            r0.<init>(r4);
            throw r0;
        L_0x0058:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.maps.StreetViewPanoramaView.zzb.zza(com.google.android.gms.dynamic.zzo):void");
        }
    }

    static class zza implements StreetViewLifecycleDelegate {
        private final ViewGroup zzisx;
        private final IStreetViewPanoramaViewDelegate zzitv;
        private View zzitw;

        public zza(ViewGroup viewGroup, IStreetViewPanoramaViewDelegate iStreetViewPanoramaViewDelegate) {
            this.zzitv = (IStreetViewPanoramaViewDelegate) zzbq.checkNotNull(iStreetViewPanoramaViewDelegate);
            this.zzisx = (ViewGroup) zzbq.checkNotNull(viewGroup);
        }

        public final void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
            try {
                this.zzitv.getStreetViewPanoramaAsync(new zzaj(this, onStreetViewPanoramaReadyCallback));
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onCreate(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zzitv.onCreate(bundle2);
                zzby.zzd(bundle2, bundle);
                this.zzitw = (View) zzn.zzx(this.zzitv.getView());
                this.zzisx.removeAllViews();
                this.zzisx.addView(this.zzitw);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onDestroy() {
            try {
                this.zzitv.onDestroy();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onDestroyView() {
            throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
            throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
        }

        public final void onLowMemory() {
            try {
                this.zzitv.onLowMemory();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onPause() {
            try {
                this.zzitv.onPause();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onResume() {
            try {
                this.zzitv.onResume();
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onSaveInstanceState(Bundle bundle) {
            try {
                Bundle bundle2 = new Bundle();
                zzby.zzd(bundle, bundle2);
                this.zzitv.onSaveInstanceState(bundle2);
                zzby.zzd(bundle2, bundle);
            } catch (RemoteException e) {
                throw new RuntimeRemoteException(e);
            }
        }

        public final void onStart() {
        }

        public final void onStop() {
        }
    }

    public StreetViewPanoramaView(Context context) {
        super(context);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzitu = new zzb(this, context, null);
    }

    public StreetViewPanoramaView(Context context, StreetViewPanoramaOptions streetViewPanoramaOptions) {
        super(context);
        this.zzitu = new zzb(this, context, streetViewPanoramaOptions);
    }

    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback onStreetViewPanoramaReadyCallback) {
        zzbq.zzge("getStreetViewPanoramaAsync() must be called on the main thread");
        this.zzitu.getStreetViewPanoramaAsync(onStreetViewPanoramaReadyCallback);
    }

    public final void onCreate(Bundle bundle) {
        ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new Builder(threadPolicy).permitAll().build());
        try {
            this.zzitu.onCreate(bundle);
            if (this.zzitu.zzapw() == null) {
                com.google.android.gms.dynamic.zza.zzb((FrameLayout) this);
            }
            StrictMode.setThreadPolicy(threadPolicy);
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void onDestroy() {
        this.zzitu.onDestroy();
    }

    public final void onLowMemory() {
        this.zzitu.onLowMemory();
    }

    public final void onPause() {
        this.zzitu.onPause();
    }

    public final void onResume() {
        this.zzitu.onResume();
    }

    public final void onSaveInstanceState(Bundle bundle) {
        this.zzitu.onSaveInstanceState(bundle);
    }
}

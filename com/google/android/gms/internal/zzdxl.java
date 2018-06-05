package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzbq;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.dynamite.DynamiteModule;

public final class zzdxl extends zzab<zzdxp> implements zzdxk {
    private static zzbgg zzecc = new zzbgg("FirebaseAuth", "FirebaseAuth:");
    private final Context mContext;
    private final zzdxt zzmez;

    public zzdxl(Context context, Looper looper, zzr com_google_android_gms_common_internal_zzr, zzdxt com_google_android_gms_internal_zzdxt, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 112, com_google_android_gms_common_internal_zzr, connectionCallbacks, onConnectionFailedListener);
        this.mContext = (Context) zzbq.checkNotNull(context);
        this.zzmez = com_google_android_gms_internal_zzdxt;
    }

    protected final Bundle zzaap() {
        Bundle zzaap = super.zzaap();
        if (zzaap == null) {
            zzaap = new Bundle();
        }
        if (this.zzmez != null) {
            zzaap.putString("com.google.firebase.auth.API_KEY", this.zzmez.getApiKey());
        }
        return zzaap;
    }

    public final boolean zzagg() {
        return DynamiteModule.zzab(this.mContext, "com.google.firebase.auth") == 0;
    }

    protected final String zzakh() {
        String property = zzdyh.getProperty("firebear.preference");
        if (TextUtils.isEmpty(property)) {
            property = "default";
        }
        int hashCode = property.hashCode();
        int i = -1;
        if (hashCode != 103145323) {
            if (hashCode == 1544803905) {
                if (property.equals("default")) {
                    hashCode = 1;
                    switch (hashCode) {
                        case 0:
                        case 1:
                            break;
                        default:
                            property = "default";
                            break;
                    }
                    if (property.hashCode() != 103145323) {
                        if (property.equals("local")) {
                            i = 0;
                        }
                    }
                    if (i != 0) {
                        zzecc.zze("Loading module via FirebaseOptions.", new Object[0]);
                        if (this.zzmez.zzmei) {
                            zzecc.zze("Preparing to create service connection to fallback implementation", new Object[0]);
                            return this.mContext.getPackageName();
                        }
                        zzecc.zze("Preparing to create service connection to gms implementation", new Object[0]);
                        return "com.google.android.gms";
                    }
                    zzecc.zze("Loading fallback module override.", new Object[0]);
                    return this.mContext.getPackageName();
                }
            }
        } else if (property.equals("local")) {
            hashCode = 0;
            switch (hashCode) {
                case 0:
                case 1:
                    break;
                default:
                    property = "default";
                    break;
            }
            if (property.hashCode() != 103145323) {
                if (property.equals("local")) {
                    i = 0;
                }
            }
            if (i != 0) {
                zzecc.zze("Loading fallback module override.", new Object[0]);
                return this.mContext.getPackageName();
            }
            zzecc.zze("Loading module via FirebaseOptions.", new Object[0]);
            if (this.zzmez.zzmei) {
                zzecc.zze("Preparing to create service connection to gms implementation", new Object[0]);
                return "com.google.android.gms";
            }
            zzecc.zze("Preparing to create service connection to fallback implementation", new Object[0]);
            return this.mContext.getPackageName();
        }
        hashCode = -1;
        switch (hashCode) {
            case 0:
            case 1:
                break;
            default:
                property = "default";
                break;
        }
        if (property.hashCode() != 103145323) {
            if (property.equals("local")) {
                i = 0;
            }
        }
        if (i != 0) {
            zzecc.zze("Loading module via FirebaseOptions.", new Object[0]);
            if (this.zzmez.zzmei) {
                zzecc.zze("Preparing to create service connection to fallback implementation", new Object[0]);
                return this.mContext.getPackageName();
            }
            zzecc.zze("Preparing to create service connection to gms implementation", new Object[0]);
            return "com.google.android.gms";
        }
        zzecc.zze("Loading fallback module override.", new Object[0]);
        return this.mContext.getPackageName();
    }

    public final /* synthetic */ zzdxp zzbrm() throws DeadObjectException {
        return (zzdxp) super.zzakn();
    }

    protected final /* synthetic */ IInterface zzd(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.firebase.auth.api.internal.IFirebaseAuthService");
        return queryLocalInterface instanceof zzdxp ? (zzdxp) queryLocalInterface : new zzdxq(iBinder);
    }

    protected final String zzhi() {
        return "com.google.firebase.auth.api.gms.service.START";
    }

    protected final String zzhj() {
        return "com.google.firebase.auth.api.internal.IFirebaseAuthService";
    }
}

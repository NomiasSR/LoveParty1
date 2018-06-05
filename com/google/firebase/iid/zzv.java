package com.google.firebase.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import com.google.android.gms.iid.MessengerCompat;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzv {
    private static PendingIntent zzicn;
    private static int zzift;
    private final Context zzair;
    private Messenger zzicr;
    private Messenger zzifw;
    private MessengerCompat zzifx;
    private final zzu zznys;
    private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zznzn = new SimpleArrayMap();

    public zzv(Context context, zzu com_google_firebase_iid_zzu) {
        this.zzair = context;
        this.zznys = com_google_firebase_iid_zzu;
        this.zzicr = new Messenger(new zzw(this, Looper.getMainLooper()));
    }

    private final Bundle zzae(Bundle bundle) throws IOException {
        Bundle zzaf = zzaf(bundle);
        if (zzaf == null || !zzaf.containsKey("google.messenger")) {
            return zzaf;
        }
        zzaf = zzaf(bundle);
        return (zzaf == null || !zzaf.containsKey("google.messenger")) ? zzaf : null;
    }

    private final android.os.Bundle zzaf(android.os.Bundle r9) throws java.io.IOException {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r8 = this;
        r0 = zzavi();
        r1 = new com.google.android.gms.tasks.TaskCompletionSource;
        r1.<init>();
        r2 = r8.zznzn;
        monitor-enter(r2);
        r3 = r8.zznzn;	 Catch:{ all -> 0x012f }
        r3.put(r0, r1);	 Catch:{ all -> 0x012f }
        monitor-exit(r2);	 Catch:{ all -> 0x012f }
        r2 = r8.zznys;
        r2 = r2.zzcjf();
        if (r2 != 0) goto L_0x0022;
    L_0x001a:
        r9 = new java.io.IOException;
        r0 = "MISSING_INSTANCEID_SERVICE";
        r9.<init>(r0);
        throw r9;
    L_0x0022:
        r2 = new android.content.Intent;
        r2.<init>();
        r3 = "com.google.android.gms";
        r2.setPackage(r3);
        r3 = r8.zznys;
        r3 = r3.zzcjf();
        r4 = 2;
        if (r3 != r4) goto L_0x003b;
    L_0x0035:
        r3 = "com.google.iid.TOKEN_REQUEST";
    L_0x0037:
        r2.setAction(r3);
        goto L_0x003e;
    L_0x003b:
        r3 = "com.google.android.c2dm.intent.REGISTER";
        goto L_0x0037;
    L_0x003e:
        r2.putExtras(r9);
        r9 = r8.zzair;
        zzd(r9, r2);
        r9 = "kid";
        r3 = 5;
        r5 = java.lang.String.valueOf(r0);
        r5 = r5.length();
        r3 = r3 + r5;
        r5 = new java.lang.StringBuilder;
        r5.<init>(r3);
        r3 = "|ID|";
        r5.append(r3);
        r5.append(r0);
        r3 = "|";
        r5.append(r3);
        r3 = r5.toString();
        r2.putExtra(r9, r3);
        r9 = "FirebaseInstanceId";
        r3 = 3;
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x009d;
    L_0x0074:
        r9 = "FirebaseInstanceId";
        r5 = r2.getExtras();
        r5 = java.lang.String.valueOf(r5);
        r6 = 8;
        r7 = java.lang.String.valueOf(r5);
        r7 = r7.length();
        r6 = r6 + r7;
        r7 = new java.lang.StringBuilder;
        r7.<init>(r6);
        r6 = "Sending ";
        r7.append(r6);
        r7.append(r5);
        r5 = r7.toString();
        android.util.Log.d(r9, r5);
    L_0x009d:
        r9 = "google.messenger";
        r5 = r8.zzicr;
        r2.putExtra(r9, r5);
        r9 = r8.zzifw;
        if (r9 != 0) goto L_0x00ac;
    L_0x00a8:
        r9 = r8.zzifx;
        if (r9 == 0) goto L_0x00d1;
    L_0x00ac:
        r9 = android.os.Message.obtain();
        r9.obj = r2;
        r5 = r8.zzifw;	 Catch:{ RemoteException -> 0x00c2 }
        if (r5 == 0) goto L_0x00bc;	 Catch:{ RemoteException -> 0x00c2 }
    L_0x00b6:
        r5 = r8.zzifw;	 Catch:{ RemoteException -> 0x00c2 }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00c2 }
        goto L_0x00e4;	 Catch:{ RemoteException -> 0x00c2 }
    L_0x00bc:
        r5 = r8.zzifx;	 Catch:{ RemoteException -> 0x00c2 }
        r5.send(r9);	 Catch:{ RemoteException -> 0x00c2 }
        goto L_0x00e4;
    L_0x00c2:
        r9 = "FirebaseInstanceId";
        r9 = android.util.Log.isLoggable(r9, r3);
        if (r9 == 0) goto L_0x00d1;
    L_0x00ca:
        r9 = "FirebaseInstanceId";
        r3 = "Messenger failed, fallback to startService";
        android.util.Log.d(r9, r3);
    L_0x00d1:
        r9 = r8.zznys;
        r9 = r9.zzcjf();
        if (r9 != r4) goto L_0x00df;
    L_0x00d9:
        r9 = r8.zzair;
        r9.sendBroadcast(r2);
        goto L_0x00e4;
    L_0x00df:
        r9 = r8.zzair;
        r9.startService(r2);
    L_0x00e4:
        r9 = r1.getTask();	 Catch:{ InterruptedException -> 0x0113, InterruptedException -> 0x0113, ExecutionException -> 0x0101 }
        r1 = 30000; // 0x7530 float:4.2039E-41 double:1.4822E-319;	 Catch:{ InterruptedException -> 0x0113, InterruptedException -> 0x0113, ExecutionException -> 0x0101 }
        r3 = java.util.concurrent.TimeUnit.MILLISECONDS;	 Catch:{ InterruptedException -> 0x0113, InterruptedException -> 0x0113, ExecutionException -> 0x0101 }
        r9 = com.google.android.gms.tasks.Tasks.await(r9, r1, r3);	 Catch:{ InterruptedException -> 0x0113, InterruptedException -> 0x0113, ExecutionException -> 0x0101 }
        r9 = (android.os.Bundle) r9;	 Catch:{ InterruptedException -> 0x0113, InterruptedException -> 0x0113, ExecutionException -> 0x0101 }
        r1 = r8.zznzn;
        monitor-enter(r1);
        r2 = r8.zznzn;	 Catch:{ all -> 0x00fc }
        r2.remove(r0);	 Catch:{ all -> 0x00fc }
        monitor-exit(r1);	 Catch:{ all -> 0x00fc }
        return r9;	 Catch:{ all -> 0x00fc }
    L_0x00fc:
        r9 = move-exception;	 Catch:{ all -> 0x00fc }
        monitor-exit(r1);	 Catch:{ all -> 0x00fc }
        throw r9;
    L_0x00ff:
        r9 = move-exception;
        goto L_0x0122;
    L_0x0101:
        r9 = move-exception;
        r9 = r9.getCause();	 Catch:{ all -> 0x00ff }
        r1 = r9 instanceof java.io.IOException;	 Catch:{ all -> 0x00ff }
        if (r1 == 0) goto L_0x010d;	 Catch:{ all -> 0x00ff }
    L_0x010a:
        r9 = (java.io.IOException) r9;	 Catch:{ all -> 0x00ff }
        throw r9;	 Catch:{ all -> 0x00ff }
    L_0x010d:
        r1 = new java.io.IOException;	 Catch:{ all -> 0x00ff }
        r1.<init>(r9);	 Catch:{ all -> 0x00ff }
        throw r1;	 Catch:{ all -> 0x00ff }
    L_0x0113:
        r9 = "FirebaseInstanceId";	 Catch:{ all -> 0x00ff }
        r1 = "No response";	 Catch:{ all -> 0x00ff }
        android.util.Log.w(r9, r1);	 Catch:{ all -> 0x00ff }
        r9 = new java.io.IOException;	 Catch:{ all -> 0x00ff }
        r1 = "TIMEOUT";	 Catch:{ all -> 0x00ff }
        r9.<init>(r1);	 Catch:{ all -> 0x00ff }
        throw r9;	 Catch:{ all -> 0x00ff }
    L_0x0122:
        r1 = r8.zznzn;
        monitor-enter(r1);
        r2 = r8.zznzn;	 Catch:{ all -> 0x012c }
        r2.remove(r0);	 Catch:{ all -> 0x012c }
        monitor-exit(r1);	 Catch:{ all -> 0x012c }
        throw r9;
    L_0x012c:
        r9 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x012c }
        throw r9;
    L_0x012f:
        r9 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x012f }
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.zzaf(android.os.Bundle):android.os.Bundle");
    }

    private static synchronized String zzavi() {
        String num;
        synchronized (zzv.class) {
            int i = zzift;
            zzift = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzbl(java.lang.String r4, java.lang.String r5) {
        /*
        r3 = this;
        r0 = r3.zznzn;
        monitor-enter(r0);
        if (r4 != 0) goto L_0x0027;
    L_0x0005:
        r4 = 0;
    L_0x0006:
        r1 = r3.zznzn;	 Catch:{ all -> 0x0058 }
        r1 = r1.size();	 Catch:{ all -> 0x0058 }
        if (r4 >= r1) goto L_0x0021;
    L_0x000e:
        r1 = r3.zznzn;	 Catch:{ all -> 0x0058 }
        r1 = r1.valueAt(r4);	 Catch:{ all -> 0x0058 }
        r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1;	 Catch:{ all -> 0x0058 }
        r2 = new java.io.IOException;	 Catch:{ all -> 0x0058 }
        r2.<init>(r5);	 Catch:{ all -> 0x0058 }
        r1.setException(r2);	 Catch:{ all -> 0x0058 }
        r4 = r4 + 1;
        goto L_0x0006;
    L_0x0021:
        r4 = r3.zznzn;	 Catch:{ all -> 0x0058 }
        r4.clear();	 Catch:{ all -> 0x0058 }
        goto L_0x0056;
    L_0x0027:
        r1 = r3.zznzn;	 Catch:{ all -> 0x0058 }
        r1 = r1.remove(r4);	 Catch:{ all -> 0x0058 }
        r1 = (com.google.android.gms.tasks.TaskCompletionSource) r1;	 Catch:{ all -> 0x0058 }
        if (r1 != 0) goto L_0x004e;
    L_0x0031:
        r5 = "FirebaseInstanceId";
        r1 = "Missing callback for ";
        r4 = java.lang.String.valueOf(r4);	 Catch:{ all -> 0x0058 }
        r2 = r4.length();	 Catch:{ all -> 0x0058 }
        if (r2 == 0) goto L_0x0044;
    L_0x003f:
        r4 = r1.concat(r4);	 Catch:{ all -> 0x0058 }
        goto L_0x0049;
    L_0x0044:
        r4 = new java.lang.String;	 Catch:{ all -> 0x0058 }
        r4.<init>(r1);	 Catch:{ all -> 0x0058 }
    L_0x0049:
        android.util.Log.w(r5, r4);	 Catch:{ all -> 0x0058 }
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x004e:
        r4 = new java.io.IOException;	 Catch:{ all -> 0x0058 }
        r4.<init>(r5);	 Catch:{ all -> 0x0058 }
        r1.setException(r4);	 Catch:{ all -> 0x0058 }
    L_0x0056:
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        return;
    L_0x0058:
        r4 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x0058 }
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.zzbl(java.lang.String, java.lang.String):void");
    }

    private static synchronized void zzd(Context context, Intent intent) {
        synchronized (zzv.class) {
            if (zzicn == null) {
                Intent intent2 = new Intent();
                intent2.setPackage("com.google.example.invalidpackage");
                zzicn = PendingIntent.getBroadcast(context, 0, intent2, 0);
            }
            intent.putExtra("app", zzicn);
        }
    }

    private final void zze(Message message) {
        if (message == null || !(message.obj instanceof Intent)) {
            Log.w("FirebaseInstanceId", "Dropping invalid message");
            return;
        }
        Intent intent = (Intent) message.obj;
        intent.setExtrasClassLoader(MessengerCompat.class.getClassLoader());
        if (intent.hasExtra("google.messenger")) {
            Parcelable parcelableExtra = intent.getParcelableExtra("google.messenger");
            if (parcelableExtra instanceof MessengerCompat) {
                this.zzifx = (MessengerCompat) parcelableExtra;
            }
            if (parcelableExtra instanceof Messenger) {
                this.zzifw = (Messenger) parcelableExtra;
            }
        }
        Intent intent2 = (Intent) message.obj;
        String action = intent2.getAction();
        String valueOf;
        String str;
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            CharSequence stringExtra = intent2.getStringExtra("registration_id");
            if (stringExtra == null) {
                stringExtra = intent2.getStringExtra("unregistered");
            }
            if (stringExtra == null) {
                action = intent2.getStringExtra("error");
                if (action == null) {
                    valueOf = String.valueOf(intent2.getExtras());
                    StringBuilder stringBuilder = new StringBuilder(49 + String.valueOf(valueOf).length());
                    stringBuilder.append("Unexpected response, no error or registration id ");
                    stringBuilder.append(valueOf);
                    Log.w("FirebaseInstanceId", stringBuilder.toString());
                    return;
                }
                String str2;
                String valueOf2;
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    str2 = "FirebaseInstanceId";
                    String str3 = "Received InstanceID error ";
                    valueOf2 = String.valueOf(action);
                    Log.d(str2, valueOf2.length() != 0 ? str3.concat(valueOf2) : new String(str3));
                }
                str2 = null;
                if (action.startsWith("|")) {
                    String[] split = action.split("\\|");
                    if (!"ID".equals(split[1])) {
                        valueOf2 = "FirebaseInstanceId";
                        String str4 = "Unexpected structured response ";
                        action = String.valueOf(action);
                        Log.w(valueOf2, action.length() != 0 ? str4.concat(action) : new String(str4));
                    }
                    if (split.length > 2) {
                        action = split[2];
                        str = split[3];
                        if (str.startsWith(":")) {
                            str = str.substring(1);
                        }
                        str2 = action;
                        action = str;
                    } else {
                        action = "UNKNOWN";
                    }
                    intent2.putExtra("error", action);
                }
                zzbl(str2, action);
                return;
            }
            Matcher matcher = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(stringExtra);
            if (matcher.matches()) {
                action = matcher.group(1);
                str = matcher.group(2);
                Bundle extras = intent2.getExtras();
                extras.putString("registration_id", str);
                synchronized (this.zznzn) {
                    TaskCompletionSource taskCompletionSource = (TaskCompletionSource) this.zznzn.remove(action);
                    if (taskCompletionSource == null) {
                        valueOf = "FirebaseInstanceId";
                        String str5 = "Missing callback for ";
                        action = String.valueOf(action);
                        Log.w(valueOf, action.length() != 0 ? str5.concat(action) : new String(str5));
                        return;
                    }
                    taskCompletionSource.setResult(extras);
                    return;
                }
            }
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                valueOf = "FirebaseInstanceId";
                str = "Unexpected response string: ";
                action = String.valueOf(stringExtra);
                Log.d(valueOf, action.length() != 0 ? str.concat(action) : new String(str));
            }
            return;
        }
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            valueOf = "FirebaseInstanceId";
            str = "Unexpected response action: ";
            action = String.valueOf(action);
            Log.d(valueOf, action.length() != 0 ? str.concat(action) : new String(str));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    final android.os.Bundle zzad(android.os.Bundle r6) throws java.io.IOException {
        /*
        r5 = this;
        r0 = r5.zznys;
        r0 = r0.zzcji();
        r1 = 12000000; // 0xb71b00 float:1.6815582E-38 double:5.9287878E-317;
        if (r0 < r1) goto L_0x0068;
    L_0x000b:
        r0 = r5.zzair;
        r0 = com.google.firebase.iid.zzi.zzev(r0);
        r1 = 1;
        r0 = r0.zzi(r1, r6);
        r0 = com.google.android.gms.tasks.Tasks.await(r0);	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        r0 = (android.os.Bundle) r0;	 Catch:{ InterruptedException -> 0x001d, InterruptedException -> 0x001d }
        return r0;
    L_0x001d:
        r0 = move-exception;
        r1 = "FirebaseInstanceId";
        r2 = 3;
        r1 = android.util.Log.isLoggable(r1, r2);
        if (r1 == 0) goto L_0x004c;
    L_0x0027:
        r1 = "FirebaseInstanceId";
        r2 = java.lang.String.valueOf(r0);
        r3 = 22;
        r4 = java.lang.String.valueOf(r2);
        r4 = r4.length();
        r3 = r3 + r4;
        r4 = new java.lang.StringBuilder;
        r4.<init>(r3);
        r3 = "Error making request: ";
        r4.append(r3);
        r4.append(r2);
        r2 = r4.toString();
        android.util.Log.d(r1, r2);
    L_0x004c:
        r1 = r0.getCause();
        r1 = r1 instanceof com.google.firebase.iid.zzs;
        if (r1 == 0) goto L_0x0066;
    L_0x0054:
        r0 = r0.getCause();
        r0 = (com.google.firebase.iid.zzs) r0;
        r0 = r0.getErrorCode();
        r1 = 4;
        if (r0 != r1) goto L_0x0066;
    L_0x0061:
        r6 = r5.zzae(r6);
        return r6;
    L_0x0066:
        r6 = 0;
        return r6;
    L_0x0068:
        r6 = r5.zzae(r6);
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzv.zzad(android.os.Bundle):android.os.Bundle");
    }
}

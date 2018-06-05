package com.cicari.p001270.gaveta;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.firebase.geofire.GeoFire;
import com.firebase.geofire.GeoFire.CompletionListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.IgnoreExtraProperties;
import com.google.firebase.database.ValueEventListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@IgnoreExtraProperties
public class User {
    private String MSG_CANT_ADD_YOURSELF = "You can't add yourself as contact.";
    private String MSG_CANT_FIND_FRIEND = "The email filled can't be found on our database.";
    private String MSG_ERROR_SAVE_DATA = "Error while saving your data. Please try again.";
    private String MSG_FRIEND_EXISTS = "The email filled already exists on your friends list.";
    private String MSG_SAVE_DATA = "Data saved successfully.";
    private String MSG_WAIT_SAVE_DATA = "Saving data, please wait...";
    public String TAG = "testeclass";
    Map<String, Object> childUpdates = new HashMap();
    public Context context1;
    public boolean encontrou_amigo;
    String firebaseUserUID = FirebaseAuth.getInstance().getCurrentUser().getUid();
    private GeoFire geoFire;
    DatabaseReference mDataBaseReference = FirebaseDatabase.getInstance().getReference();
    Resources res;
    public boolean salvarAmigo;
    String tbContatos;
    String tbPerfis;
    String tbPosicao;
    String tbUsuario;

    class C05251 implements CompletionListener {
        public void onComplete(String str, DatabaseError databaseError) {
        }

        C05251() {
        }
    }

    class C05262 implements OnSuccessListener<Void> {
        C05262() {
        }

        public void onSuccess(Void voidR) {
            Toast.makeText(User.this.context1, User.this.MSG_SAVE_DATA, 1).show();
        }
    }

    class C05273 implements OnFailureListener {
        C05273() {
        }

        public void onFailure(@NonNull Exception exception) {
            Toast.makeText(User.this.context1, User.this.MSG_ERROR_SAVE_DATA, 1).show();
        }
    }

    public User(Resources resources, Context context) {
        this.res = resources;
        this.tbUsuario = this.res.getString(C0346R.string._USUARIOS);
        this.tbPosicao = this.res.getString(C0346R.string._POSICAO);
        this.tbPerfis = this.res.getString(C0346R.string._PERFIS);
        this.tbContatos = this.res.getString(C0346R.string._CONTATOS);
        this.context1 = context;
    }

    public boolean updateUserData(java.lang.String r4, java.lang.String r5, java.util.Map r6, java.util.Map r7, java.lang.String r8) {
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
        r3 = this;
        r0 = r3.mDataBaseReference;
        r1 = r3.tbUsuario;
        r0 = r0.child(r1);
        r1 = r3.firebaseUserUID;
        r0 = r0.child(r1);
        r1 = "id";
        r0 = r0.child(r1);
        r1 = r3.firebaseUserUID;
        r0.setValue(r1);
        r0 = r3.mDataBaseReference;
        r1 = r3.tbUsuario;
        r0 = r0.child(r1);
        r1 = r3.firebaseUserUID;
        r0 = r0.child(r1);
        r1 = "email";
        r0 = r0.child(r1);
        r1 = com.google.firebase.auth.FirebaseAuth.getInstance();
        r1 = r1.getCurrentUser();
        r1 = r1.getEmail();
        r0.setValue(r1);
        r0 = r3.mDataBaseReference;
        r1 = r3.tbUsuario;
        r0 = r0.child(r1);
        r1 = r3.firebaseUserUID;
        r0 = r0.child(r1);
        r1 = "name";
        r0 = r0.child(r1);
        r0.setValue(r8);
        r8 = r3.mDataBaseReference;
        r0 = r3.tbUsuario;
        r8 = r8.child(r0);
        r0 = r3.firebaseUserUID;
        r8 = r8.child(r0);
        r0 = "hashtag";
        r8 = r8.child(r0);
        r0 = "#";
        r8.setValue(r0);
        r8 = r3.mDataBaseReference;
        r0 = r3.tbUsuario;
        r8 = r8.child(r0);
        r0 = r3.firebaseUserUID;
        r8 = r8.child(r0);
        r0 = "quote";
        r8 = r8.child(r0);
        r0 = "New User";
        r8.setValue(r0);
        r8 = r3.mDataBaseReference;
        r0 = r3.tbUsuario;
        r8 = r8.child(r0);
        r0 = r3.firebaseUserUID;
        r8 = r8.child(r0);
        r0 = "image_profile";
        r8 = r8.child(r0);
        r0 = "";
        r8.setValue(r0);
        r8 = r3.mDataBaseReference;
        r0 = r3.tbUsuario;
        r8 = r8.child(r0);
        r0 = r3.firebaseUserUID;
        r8 = r8.child(r0);
        r0 = "image";
        r8 = r8.child(r0);
        r0 = "";
        r8.setValue(r0);
        r8 = r3.mDataBaseReference;
        r0 = r3.tbUsuario;
        r8 = r8.child(r0);
        r0 = r3.firebaseUserUID;
        r8 = r8.child(r0);
        r0 = "visible";
        r8 = r8.child(r0);
        r0 = 1;
        r1 = java.lang.Boolean.valueOf(r0);
        r8.setValue(r1);
        r8 = r3.childUpdates;
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        r2 = "/";
        r1.append(r2);
        r2 = r3.tbUsuario;
        r1.append(r2);
        r2 = "/";
        r1.append(r2);
        r2 = r3.firebaseUserUID;
        r1.append(r2);
        r2 = "/";
        r1.append(r2);
        r2 = r3.tbPosicao;
        r1.append(r2);
        r2 = "/lat";
        r1.append(r2);
        r1 = r1.toString();
        r8.put(r1, r4);
        r4 = r3.childUpdates;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r1 = "/";
        r8.append(r1);
        r1 = r3.tbUsuario;
        r8.append(r1);
        r1 = "/";
        r8.append(r1);
        r1 = r3.firebaseUserUID;
        r8.append(r1);
        r1 = "/";
        r8.append(r1);
        r1 = r3.tbPosicao;
        r8.append(r1);
        r1 = "/lng";
        r8.append(r1);
        r8 = r8.toString();
        r4.put(r8, r5);
        r4 = r3.childUpdates;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r8 = "/";
        r5.append(r8);
        r8 = r3.tbUsuario;
        r5.append(r8);
        r8 = "/";
        r5.append(r8);
        r8 = r3.firebaseUserUID;
        r5.append(r8);
        r8 = "/";
        r5.append(r8);
        r8 = r3.tbPerfis;
        r5.append(r8);
        r8 = "";
        r5.append(r8);
        r5 = r5.toString();
        r4.put(r5, r6);
        r4 = r3.childUpdates;
        r5 = new java.lang.StringBuilder;
        r5.<init>();
        r6 = "/";
        r5.append(r6);
        r6 = r3.tbUsuario;
        r5.append(r6);
        r6 = "/";
        r5.append(r6);
        r6 = r3.firebaseUserUID;
        r5.append(r6);
        r6 = "/";
        r5.append(r6);
        r6 = r3.tbContatos;
        r5.append(r6);
        r6 = "/";
        r5.append(r6);
        r5 = r5.toString();
        r4.put(r5, r7);
        r4 = r3.mDataBaseReference;	 Catch:{ Exception -> 0x019f }
        r5 = r3.childUpdates;	 Catch:{ Exception -> 0x019f }
        r4.updateChildren(r5);	 Catch:{ Exception -> 0x019f }
        goto L_0x01a0;
    L_0x019f:
        r0 = 0;
    L_0x01a0:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.User.updateUserData(java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.lang.String):boolean");
    }

    public void updateUserDataLatLng(double d, double d2) {
        Map map = this.childUpdates;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(this.firebaseUserUID);
        stringBuilder.append("/");
        stringBuilder.append(this.tbPosicao);
        stringBuilder.append("/lat");
        map.put(stringBuilder.toString(), Double.valueOf(d));
        map = this.childUpdates;
        stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(this.firebaseUserUID);
        stringBuilder.append("/");
        stringBuilder.append(this.tbPosicao);
        stringBuilder.append("/lng");
        map.put(stringBuilder.toString(), Double.valueOf(d2));
        this.mDataBaseReference.updateChildren(this.childUpdates);
        String str = this.TAG;
        stringBuilder = new StringBuilder();
        stringBuilder.append("Atualizando: Lat->");
        stringBuilder.append(d);
        stringBuilder.append("  Lng: ");
        stringBuilder.append(d2);
        Log.d(str, stringBuilder.toString());
    }

    public void updateUserLogin(String str) {
        Map map = this.childUpdates;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(this.firebaseUserUID);
        stringBuilder.append("/logado/");
        map.put(stringBuilder.toString(), str);
        this.mDataBaseReference.updateChildren(this.childUpdates);
        if (str.equalsIgnoreCase("n") != null) {
            this.geoFire = new GeoFire(FirebaseDatabase.getInstance().getReference("User_location"));
            this.geoFire.removeLocation(this.firebaseUserUID, new C05251());
        }
    }

    public void updateUserNameAndHashTag(String str, String str2, String str3, Boolean bool) {
        Map map = this.childUpdates;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/");
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(this.firebaseUserUID);
        stringBuilder.append("/name/");
        map.put(stringBuilder.toString(), str);
        str = this.childUpdates;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("/");
        stringBuilder2.append(this.tbUsuario);
        stringBuilder2.append("/");
        stringBuilder2.append(this.firebaseUserUID);
        stringBuilder2.append("/hashtag/");
        str.put(stringBuilder2.toString(), str2);
        str = this.childUpdates;
        str2 = new StringBuilder();
        str2.append("/");
        str2.append(this.tbUsuario);
        str2.append("/");
        str2.append(this.firebaseUserUID);
        str2.append("/image_profile/");
        str.put(str2.toString(), str3);
        str = this.childUpdates;
        str2 = new StringBuilder();
        str2.append("/");
        str2.append(this.tbUsuario);
        str2.append("/");
        str2.append(this.firebaseUserUID);
        str2.append("/visible/");
        str.put(str2.toString(), bool);
        Toast.makeText(this.context1, this.MSG_WAIT_SAVE_DATA, 1).show();
        this.mDataBaseReference.updateChildren(this.childUpdates).addOnFailureListener(new C05273()).addOnSuccessListener(new C05262());
    }

    public void addFriend(final String str, final int i) {
        this.salvarAmigo = true;
        Toast.makeText(this.context1, this.MSG_WAIT_SAVE_DATA, 1).show();
        FirebaseDatabase.getInstance().getReference(this.tbUsuario).orderByChild("email").equalTo(str).addListenerForSingleValueEvent(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                        final String obj = child.child("id").getValue().toString();
                        if (FirebaseAuth.getInstance().getCurrentUser().getEmail().equalsIgnoreCase(str)) {
                            Toast.makeText(User.this.context1, User.this.MSG_CANT_ADD_YOURSELF, 1).show();
                        } else {
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append(User.this.tbUsuario);
                            stringBuilder.append("/");
                            stringBuilder.append(FirebaseAuth.getInstance().getUid());
                            stringBuilder.append("/");
                            stringBuilder.append(User.this.tbContatos);
                            reference.child(stringBuilder.toString()).addListenerForSingleValueEvent(new ValueEventListener() {

                                class C05281 implements OnSuccessListener<Void> {
                                    C05281() {
                                    }

                                    public void onSuccess(Void voidR) {
                                        Toast.makeText(User.this.context1, User.this.MSG_SAVE_DATA, 1).show();
                                    }
                                }

                                class C05292 implements OnFailureListener {
                                    C05292() {
                                    }

                                    public void onFailure(@NonNull Exception exception) {
                                        Toast.makeText(User.this.context1, User.this.MSG_ERROR_SAVE_DATA, 1).show();
                                    }
                                }

                                public void onCancelled(DatabaseError databaseError) {
                                }

                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    for (DataSnapshot child : dataSnapshot.getChildren()) {
                                        if (child.child("id").getValue().toString().equalsIgnoreCase(obj)) {
                                            Toast.makeText(User.this.context1, User.this.MSG_FRIEND_EXISTS, 1).show();
                                            User.this.encontrou_amigo = true;
                                            break;
                                        }
                                    }
                                    if (User.this.encontrou_amigo == null) {
                                        dataSnapshot = User.this.childUpdates;
                                        StringBuilder stringBuilder = new StringBuilder();
                                        stringBuilder.append("/");
                                        stringBuilder.append(User.this.tbUsuario);
                                        stringBuilder.append("/");
                                        stringBuilder.append(User.this.firebaseUserUID);
                                        stringBuilder.append("/");
                                        stringBuilder.append(User.this.tbContatos);
                                        stringBuilder.append("/contato");
                                        stringBuilder.append(i);
                                        stringBuilder.append("/id");
                                        dataSnapshot.put(stringBuilder.toString(), obj);
                                        User.this.mDataBaseReference.updateChildren(User.this.childUpdates).addOnFailureListener(new C05292()).addOnSuccessListener(new C05281());
                                    }
                                }
                            });
                        }
                    }
                    return;
                }
                Toast.makeText(User.this.context1, User.this.MSG_CANT_FIND_FRIEND, 1).show();
            }
        });
    }

    public void sendMessageToFriend(String str, String str2) {
        String format = new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
        Map map = this.childUpdates;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/mensagens/");
        stringBuilder.append(str);
        stringBuilder.append("/");
        stringBuilder.append(format);
        str = stringBuilder.toString();
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(FirebaseAuth.getInstance().getCurrentUser().getEmail());
        stringBuilder2.append("': ");
        stringBuilder2.append(str2);
        map.put(str, stringBuilder2.toString());
        this.mDataBaseReference.updateChildren(this.childUpdates);
    }

    public void clearMessage(String str) {
        Map map = this.childUpdates;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("/mensagens/");
        stringBuilder.append(str);
        map.remove(stringBuilder.toString());
        this.mDataBaseReference.updateChildren(this.childUpdates);
    }
}

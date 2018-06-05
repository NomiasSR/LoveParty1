package com.cicari.p001270.gaveta;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageMetadata;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask.TaskSnapshot;

public class UserActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_IMAGE_PICK = 2;
    private String MSG_ERROR_READING_IMAGE = "An Error occurred while reading your image. Please try again";
    private String MSG_ERROR_UPLOAD_FILE = "An Error ocurred while upload the file. Please try again.";
    private String MSG_SUCCESS_READ_IMAGE = "Image loaded successfully!";
    private String MSG_SUCCESS_UPLOAD = "File uploaded successfully!";
    private String MSG_WAIT_LOAD_IMAGE = "Please wait while your profile image is being loaded...";
    private String MSG_WAIT_UPLOAD_IMAGE = "Please wait while your profile image is being uploaded...";
    private String TAG = "testeclass";
    private String URL_FIREBASESTORAGE = "gs://gaveta-ae710.appspot.com";
    private byte[] byteArray = null;
    private FirebaseUser fireBaseAccount;
    private FirebaseStorage firebaseStorage;
    public String imageLink;
    private DatabaseReference mDatabaseReferencePesquisa;
    private StorageReference mStorageRef;
    private ImageView mUserPhotoImageView;
    private StorageReference storageRef;
    private User user;

    class C03521 implements OnClickListener {

        class C03501 implements DialogInterface.OnClickListener {
            C03501() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface = new Intent("android.intent.action.PICK");
                dialogInterface.setType("image/*");
                UserActivity.this.startActivityForResult(dialogInterface, 2);
            }
        }

        class C03512 implements DialogInterface.OnClickListener {
            C03512() {
            }

            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface = new Intent("android.media.action.IMAGE_CAPTURE");
                if (dialogInterface.resolveActivity(UserActivity.this.getPackageManager()) != 0) {
                    UserActivity.this.startActivityForResult(dialogInterface, 1);
                }
            }
        }

        C03521() {
        }

        public void onClick(View view) {
            view = new Builder(UserActivity.this);
            view.setTitle((CharSequence) "Update your profile's photo");
            view.setMessage((CharSequence) "Choose source");
            view.setPositiveButton((CharSequence) "Upload", new C03501());
            view.setNegativeButton((CharSequence) "Camera", new C03512());
            view.create().show();
        }
    }

    class C05345 implements ValueEventListener {

        class C05691 extends SimpleTarget<Bitmap> {
            public void onLoadFailed(Exception exception, Drawable drawable) {
            }

            C05691() {
            }

            public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
                UserActivity.this.mUserPhotoImageView.setImageBitmap(bitmap);
            }
        }

        public void onCancelled(DatabaseError databaseError) {
        }

        C05345() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            String obj = dataSnapshot.getValue().toString();
            UserActivity.this.imageLink = obj;
            UserActivity userActivity = UserActivity.this;
            StorageReference referenceFromUrl = FirebaseStorage.getInstance().getReferenceFromUrl(UserActivity.this.URL_FIREBASESTORAGE);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Photos/Users/");
            stringBuilder.append(FirebaseAuth.getInstance().getUid());
            userActivity.storageRef = referenceFromUrl.child(stringBuilder.toString());
            Glide.with(UserActivity.this.getApplicationContext()).load(obj).asBitmap().into(new C05691());
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_user);
        setSupportActionBar((Toolbar) findViewById(C0346R.id.toolbar));
        final EditText editText = (EditText) findViewById(C0346R.id.edDisplayName);
        final EditText editText2 = (EditText) findViewById(C0346R.id.edHashTag);
        String string = getResources().getString(C0346R.string._USUARIOS);
        final CheckBox checkBox = (CheckBox) findViewById(C0346R.id.isVisible);
        this.firebaseStorage = FirebaseStorage.getInstance();
        this.mStorageRef = FirebaseStorage.getInstance().getReference().child("Photos").child("Users");
        StorageReference referenceFromUrl = this.firebaseStorage.getReferenceFromUrl(this.URL_FIREBASESTORAGE);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Photos/Users/");
        stringBuilder.append(FirebaseAuth.getInstance().getCurrentUser().getUid());
        this.storageRef = referenceFromUrl.child(stringBuilder.toString());
        this.fireBaseAccount = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append("/");
        stringBuilder.append(this.fireBaseAccount.getUid());
        this.mDatabaseReferencePesquisa = reference.child(stringBuilder.toString());
        this.user = new User(getResources(), getApplicationContext());
        this.mUserPhotoImageView = (ImageView) findViewById(C0346R.id.ivUserImage);
        this.mUserPhotoImageView.setOnClickListener(new C03521());
        ((FloatingActionButton) findViewById(C0346R.id.fab)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UserActivity.this.updateUserData(editText.getText().toString(), editText2.getText().toString(), UserActivity.this.byteArray, checkBox.isChecked());
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.mDatabaseReferencePesquisa.addValueEventListener(new ValueEventListener() {
            public void onCancelled(DatabaseError databaseError) {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                editText.setText(dataSnapshot.child("name").getValue().toString());
                editText2.setText(dataSnapshot.child("hashtag").getValue().toString());
                checkBox.setChecked(((Boolean) dataSnapshot.child("visible").getValue()).booleanValue());
                UserActivity.this.loadImageFromProfile();
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onActivityResult(int r3, int r4, android.content.Intent r5) {
        /*
        r2 = this;
        super.onActivityResult(r3, r4, r5);
        r0 = -1;
        r1 = 1;
        switch(r3) {
            case 1: goto L_0x002e;
            case 2: goto L_0x0009;
            default: goto L_0x0008;
        };
    L_0x0008:
        goto L_0x003d;
    L_0x0009:
        if (r4 != r0) goto L_0x003d;
    L_0x000b:
        r3 = r2.getApplicationContext();	 Catch:{ IOException -> 0x001c }
        r3 = r3.getContentResolver();	 Catch:{ IOException -> 0x001c }
        r4 = r5.getData();	 Catch:{ IOException -> 0x001c }
        r3 = android.provider.MediaStore.Images.Media.getBitmap(r3, r4);	 Catch:{ IOException -> 0x001c }
        goto L_0x003e;
    L_0x001c:
        r3 = move-exception;
        r3.printStackTrace();
        r3 = r2.getApplicationContext();
        r4 = r2.MSG_ERROR_UPLOAD_FILE;
        r3 = android.widget.Toast.makeText(r3, r4, r1);
        r3.show();
        goto L_0x003d;
    L_0x002e:
        if (r4 != r0) goto L_0x003d;
    L_0x0030:
        r3 = r5.getExtras();
        r4 = "data";
        r3 = r3.get(r4);
        r3 = (android.graphics.Bitmap) r3;
        goto L_0x003e;
    L_0x003d:
        r3 = 0;
    L_0x003e:
        if (r3 == 0) goto L_0x0099;
    L_0x0040:
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x0062 }
        r4.<init>();	 Catch:{ Exception -> 0x0062 }
        r5 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x0062 }
        r0 = 100;
        r3.compress(r5, r0, r4);	 Catch:{ Exception -> 0x0062 }
        r4 = r4.toByteArray();	 Catch:{ Exception -> 0x0062 }
        r2.byteArray = r4;	 Catch:{ Exception -> 0x0062 }
        r4 = r2.getApplicationContext();	 Catch:{ Exception -> 0x0062 }
        r5 = r2.MSG_WAIT_UPLOAD_IMAGE;	 Catch:{ Exception -> 0x0062 }
        r4 = android.widget.Toast.makeText(r4, r5, r1);	 Catch:{ Exception -> 0x0062 }
        r4.show();	 Catch:{ Exception -> 0x0062 }
        goto L_0x0073;
    L_0x0060:
        r4 = move-exception;
        goto L_0x0086;
    L_0x0062:
        r4 = move-exception;
        r4.printStackTrace();	 Catch:{ all -> 0x0060 }
        r4 = r2.getApplicationContext();	 Catch:{ all -> 0x0060 }
        r5 = r2.MSG_ERROR_UPLOAD_FILE;	 Catch:{ all -> 0x0060 }
        r4 = android.widget.Toast.makeText(r4, r5, r1);	 Catch:{ all -> 0x0060 }
        r4.show();	 Catch:{ all -> 0x0060 }
    L_0x0073:
        r4 = r2.mUserPhotoImageView;
        r4.setImageBitmap(r3);
        r3 = r2.getApplicationContext();
        r4 = r2.MSG_SUCCESS_UPLOAD;
        r3 = android.widget.Toast.makeText(r3, r4, r1);
        r3.show();
        goto L_0x0099;
    L_0x0086:
        r5 = r2.mUserPhotoImageView;
        r5.setImageBitmap(r3);
        r3 = r2.getApplicationContext();
        r5 = r2.MSG_SUCCESS_UPLOAD;
        r3 = android.widget.Toast.makeText(r3, r5, r1);
        r3.show();
        throw r4;
    L_0x0099:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.UserActivity.onActivityResult(int, int, android.content.Intent):void");
    }

    private void updateUserData(final String str, final String str2, byte[] bArr, final boolean z) {
        StorageMetadata build = new StorageMetadata.Builder().setContentType(null).setContentLanguage("en").build();
        if (bArr != null) {
            this.mStorageRef.child(this.fireBaseAccount.getUid()).putBytes(bArr, build).addOnCompleteListener(new OnCompleteListener<TaskSnapshot>() {
                public void onComplete(@NonNull Task<TaskSnapshot> task) {
                    if (task.isSuccessful()) {
                        UserActivity.this.imageLink = ((TaskSnapshot) task.getResult()).getDownloadUrl().toString();
                        UserActivity.this.user.updateUserNameAndHashTag(str, str2, UserActivity.this.imageLink, Boolean.valueOf(z));
                        return;
                    }
                    Toast.makeText(UserActivity.this.getApplicationContext(), UserActivity.this.MSG_ERROR_READING_IMAGE, 1).show();
                }
            });
        } else {
            this.user.updateUserNameAndHashTag(str, str2, this.imageLink, Boolean.valueOf(z));
        }
    }

    private void loadImageFromProfile() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("usuarios/");
        stringBuilder.append(FirebaseAuth.getInstance().getUid());
        stringBuilder.append("/image_profile/");
        this.mDatabaseReferencePesquisa = reference.child(stringBuilder.toString());
        this.mDatabaseReferencePesquisa.addValueEventListener(new C05345());
    }
}

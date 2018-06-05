package com.cicari.p001270.gaveta;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.ContactsContract.Profile;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements LoaderCallbacks<Cursor> {
    private static final String[] DUMMY_CREDENTIALS = new String[]{"foo@example.com:hello", "bar@example.com:world"};
    private static final int REQUEST_READ_CONTACTS = 0;
    private String TAG = "testeclass";
    private EditText email;
    public FirebaseUser fireBaseAccount;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private UserLoginTask mAuthTask = null;
    private DatabaseReference mDatabaseReferenceCadastro;
    private AutoCompleteTextView mEmailView;
    private View mLoginFormView;
    private EditText mPasswordView;
    private View mProgressView;
    private EditText password;
    private ProgressBar progressBar;
    public TextView tvRetornoUsuario;
    private User user;

    class C03342 implements OnClickListener {
        C03342() {
        }

        public void onClick(View view) {
            if (LoginActivity.this.email.getText().toString().isEmpty() != null) {
                Toast.makeText(LoginActivity.this, "Please provide a email", 0).show();
            } else if (LoginActivity.this.password.getText().toString().isEmpty() != null) {
                Toast.makeText(LoginActivity.this, "Please provide a password", 0).show();
            } else {
                LoginActivity.this.progressBar.setVisibility(0);
                LoginActivity.this.loginUsuarioFireBase(LoginActivity.this.email.getText().toString(), LoginActivity.this.password.getText().toString());
            }
        }
    }

    class C03353 implements OnClickListener {
        C03353() {
        }

        public void onClick(View view) {
            LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        }
    }

    private interface ProfileQuery {
        public static final int ADDRESS = 0;
        public static final int IS_PRIMARY = 1;
        public static final String[] PROJECTION = new String[]{"data1", "is_primary"};
    }

    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
        private final String mEmail;
        private final String mPassword;

        UserLoginTask(String str, String str2) {
            this.mEmail = str;
            this.mPassword = str2;
        }

        protected java.lang.Boolean doInBackground(java.lang.Void... r8) {
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
            r7 = this;
            r0 = 2000; // 0x7d0 float:2.803E-42 double:9.88E-321;
            r8 = 0;
            java.lang.Thread.sleep(r0);	 Catch:{ InterruptedException -> 0x0036 }
            r0 = com.cicari.p001270.gaveta.LoginActivity.DUMMY_CREDENTIALS;
            r1 = r0.length;
            r2 = r8;
        L_0x000c:
            r3 = 1;
            if (r2 >= r1) goto L_0x0031;
        L_0x000f:
            r4 = r0[r2];
            r5 = ":";
            r4 = r4.split(r5);
            r5 = r4[r8];
            r6 = r7.mEmail;
            r5 = r5.equals(r6);
            if (r5 == 0) goto L_0x002e;
        L_0x0021:
            r8 = r4[r3];
            r0 = r7.mPassword;
            r8 = r8.equals(r0);
            r8 = java.lang.Boolean.valueOf(r8);
            return r8;
        L_0x002e:
            r2 = r2 + 1;
            goto L_0x000c;
        L_0x0031:
            r8 = java.lang.Boolean.valueOf(r3);
            return r8;
        L_0x0036:
            r8 = java.lang.Boolean.valueOf(r8);
            return r8;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.cicari.p001270.gaveta.LoginActivity.UserLoginTask.doInBackground(java.lang.Void[]):java.lang.Boolean");
        }

        protected void onPostExecute(Boolean bool) {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
            if (bool.booleanValue() != null) {
                LoginActivity.this.finish();
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                return;
            }
            LoginActivity.this.mPasswordView.setError(LoginActivity.this.getString(C0346R.string.error_incorrect_password));
            LoginActivity.this.mPasswordView.requestFocus();
        }

        protected void onCancelled() {
            LoginActivity.this.mAuthTask = null;
            LoginActivity.this.showProgress(false);
        }
    }

    class C05071 implements OnCompleteListener<AuthResult> {
        C05071() {
        }

        public void onComplete(@NonNull Task<AuthResult> task) {
            if (!task.isSuccessful()) {
                LoginActivity.this.tvRetornoUsuario.setText(task.getException().getMessage());
                String access$000 = LoginActivity.this.TAG;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("signInWithEmail:failure ");
                stringBuilder.append(task.getException());
                Log.d(access$000, stringBuilder.toString());
            } else if (FirebaseAuth.getInstance() != null) {
                new User(LoginActivity.this.getResources(), LoginActivity.this.getApplicationContext()).updateUserLogin("s");
                LoginActivity.this.loadApplication();
            }
            LoginActivity.this.progressBar.setVisibility(4);
        }
    }

    public void onLoaderReset(Loader<Cursor> loader) {
    }

    public void loadApplication() {
        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

    public void loginUsuarioFireBase(String str, String str2) {
        this.mAuth.signInWithEmailAndPassword(str, str2).addOnCompleteListener((Activity) this, new C05071());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_login);
        this.mDatabaseReferenceCadastro = FirebaseDatabase.getInstance().getReference();
        this.mAuth = FirebaseAuth.getInstance();
        this.tvRetornoUsuario = (TextView) findViewById(C0346R.id.tvRetornoUsuario);
        this.email = (EditText) findViewById(C0346R.id.edEmail);
        this.password = (EditText) findViewById(C0346R.id.edPassword);
        this.progressBar = (ProgressBar) findViewById(C0346R.id.progressbar);
        this.progressBar.setVisibility(4);
        Button button = (Button) findViewById(C0346R.id.btnCreateAccount);
        if (this.mAuth.getCurrentUser() != null) {
            loadApplication();
        }
        findViewById(C0346R.id.btnLogarFireBase).setOnClickListener(new C03342());
        button.setOnClickListener(new C03353());
    }

    private void attemptLogin() {
        if (this.mAuthTask == null) {
            View view;
            boolean z;
            this.mEmailView.setError(null);
            this.mPasswordView.setError(null);
            String obj = this.mEmailView.getText().toString();
            String obj2 = this.mPasswordView.getText().toString();
            if (TextUtils.isEmpty(obj2) || isPasswordValid(obj2)) {
                view = null;
                z = false;
            } else {
                this.mPasswordView.setError(getString(C0346R.string.error_invalid_password));
                view = this.mPasswordView;
                z = true;
            }
            if (TextUtils.isEmpty(obj)) {
                this.mEmailView.setError(getString(C0346R.string.error_field_required));
                view = this.mEmailView;
            } else {
                if (!isEmailValid(obj)) {
                    this.mEmailView.setError(getString(C0346R.string.error_invalid_email));
                    view = this.mEmailView;
                }
                if (z) {
                    showProgress(true);
                    this.mAuthTask = new UserLoginTask(obj, obj2);
                    this.mAuthTask.execute(new Void[]{(Void) null});
                } else {
                    view.requestFocus();
                }
            }
            z = true;
            if (z) {
                showProgress(true);
                this.mAuthTask = new UserLoginTask(obj, obj2);
                this.mAuthTask.execute(new Void[]{(Void) null});
            } else {
                view.requestFocus();
            }
        }
    }

    private boolean isEmailValid(String str) {
        return str.contains("@");
    }

    private boolean isPasswordValid(String str) {
        return str.length() > 4 ? true : null;
    }

    @TargetApi(13)
    private void showProgress(final boolean z) {
        int i = 0;
        if (VERSION.SDK_INT >= 13) {
            int integer = getResources().getInteger(17694720);
            this.mLoginFormView.setVisibility(z ? 8 : 0);
            long j = (long) integer;
            float f = 1.0f;
            this.mLoginFormView.animate().setDuration(j).alpha(z ? 0.0f : 1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    LoginActivity.this.mLoginFormView.setVisibility(z ? 8 : 0);
                }
            });
            View view = this.mProgressView;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
            ViewPropertyAnimator duration = this.mProgressView.animate().setDuration(j);
            if (!z) {
                f = 0.0f;
            }
            duration.alpha(f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    LoginActivity.this.mProgressView.setVisibility(z ? 0 : 8);
                }
            });
            return;
        }
        this.mProgressView.setVisibility(z ? 0 : 8);
        view = this.mLoginFormView;
        if (z) {
            i = 8;
        }
        view.setVisibility(i);
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(this, Uri.withAppendedPath(Profile.CONTENT_URI, "data"), ProfileQuery.PROJECTION, "mimetype = ?", new String[]{"vnd.android.cursor.item/email_v2"}, "is_primary DESC");
    }

    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        loader = new ArrayList();
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            loader.add(cursor.getString(0));
            cursor.moveToNext();
        }
        addEmailsToAutoComplete(loader);
    }

    private void addEmailsToAutoComplete(List<String> list) {
        this.mEmailView.setAdapter(new ArrayAdapter(this, 17367050, list));
    }
}

package com.cicari.p001270.gaveta;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
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
import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {
    private String TAG = "testeclass";
    private Button btnBackToLogin;
    private Button btnSignUp;
    private EditText edEmail;
    private EditText edName;
    private EditText edPassword;
    public FirebaseUser fireBaseAccount;
    private FirebaseUser firebaseUser;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReferenceCadastro;
    private ProgressBar progressBar;
    public TextView tvRetornoUsuario;
    private User user;

    class C03471 implements OnClickListener {
        C03471() {
        }

        public void onClick(View view) {
            view = SignUpActivity.this.edName.getText().toString();
            String trim = SignUpActivity.this.edEmail.getText().toString().trim();
            String trim2 = SignUpActivity.this.edPassword.getText().toString().trim();
            if (view.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please provide a Name.", 0).show();
            } else if (trim.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please provide a Email.", 0).show();
            } else if (trim2.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Please provide a Password.", 0).show();
            } else {
                SignUpActivity.this.progressBar.setVisibility(0);
                SignUpActivity.this.criarUsuarioFireBase(view, trim, trim2);
            }
        }
    }

    class C03482 implements OnClickListener {
        C03482() {
        }

        public void onClick(View view) {
            SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
        }
    }

    private void createUserInDb(String str, String str2, String str3) {
    }

    private void goToChartUsersActivity() {
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_sign_up);
        this.mDatabaseReferenceCadastro = FirebaseDatabase.getInstance().getReference();
        this.mAuth = FirebaseAuth.getInstance();
        this.tvRetornoUsuario = (TextView) findViewById(C0346R.id.tvRetornoUsuario);
        this.edName = (EditText) findViewById(C0346R.id.edName);
        this.edEmail = (EditText) findViewById(C0346R.id.edEmail);
        this.edPassword = (EditText) findViewById(C0346R.id.edPassword);
        this.btnSignUp = (Button) findViewById(C0346R.id.btnSignUp);
        this.btnBackToLogin = (Button) findViewById(C0346R.id.btnBackToLogin);
        this.progressBar = (ProgressBar) findViewById(C0346R.id.progressbar);
        this.progressBar.setVisibility(4);
        this.tvRetornoUsuario = (TextView) findViewById(C0346R.id.tvRetornoUsuario);
        this.btnSignUp.setOnClickListener(new C03471());
        this.btnBackToLogin.setOnClickListener(new C03482());
    }

    public void criarUsuarioFireBase(final String str, String str2, String str3) {
        this.mAuth.createUserWithEmailAndPassword(str2, str3).addOnCompleteListener((Activity) this, new OnCompleteListener<AuthResult>() {
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    SignUpActivity.this.firebaseUser = SignUpActivity.this.mAuth.getCurrentUser();
                    SignUpActivity.this.user = new User(SignUpActivity.this.getResources(), SignUpActivity.this.getApplicationContext());
                    Map hashMap = new HashMap();
                    Map hashMap2 = new HashMap();
                    hashMap.put("tudo", "#");
                    if (SignUpActivity.this.user.updateUserData("0", "0", hashMap, hashMap2, str) != null) {
                        SignUpActivity.this.user.updateUserLogin("s");
                        SignUpActivity.this.finish();
                        SignUpActivity.this.startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }
                } else {
                    SignUpActivity.this.tvRetornoUsuario.setText(task.getException().getMessage());
                }
                SignUpActivity.this.progressBar.setVisibility(4);
            }
        });
    }
}

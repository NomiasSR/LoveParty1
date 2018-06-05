package com.cicari.p001270.gaveta;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FriendActivity extends AppCompatActivity {
    private String TAG = "testeclass";
    private int contadorAmigos = 0;
    private FirebaseUser fireBaseAccount;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReferenceCadastro;
    private DatabaseReference mDatabaseReferencePesquisa;
    private String tbUsuario;
    private User user;

    class C05061 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05061() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            FriendActivity.this.contadorAmigos = (int) dataSnapshot.getChildrenCount();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_friend);
        setSupportActionBar((Toolbar) findViewById(C0346R.id.toolbar));
        final EditText editText = (EditText) findViewById(C0346R.id.edEmailFriend);
        this.tbUsuario = getResources().getString(C0346R.string._USUARIOS);
        this.user = new User(getResources(), getApplicationContext());
        this.mAuth = FirebaseAuth.getInstance();
        this.fireBaseAccount = this.mAuth.getCurrentUser();
        this.mDatabaseReferenceCadastro = FirebaseDatabase.getInstance().getReference();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(FirebaseAuth.getInstance().getCurrentUser().getUid());
        stringBuilder.append("/contatos");
        this.mDatabaseReferencePesquisa = reference.child(stringBuilder.toString());
        this.mDatabaseReferencePesquisa.addListenerForSingleValueEvent(new C05061());
        ((FloatingActionButton) findViewById(C0346R.id.fab)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                FriendActivity.this.user.addFriend(editText.getText().toString(), FriendActivity.this.contadorAmigos);
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}

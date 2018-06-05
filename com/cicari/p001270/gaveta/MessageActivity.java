package com.cicari.p001270.gaveta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.cicari.p001270.gaveta.model.ChatMessage;
import com.cicari.p001270.gaveta.model.User1;
import com.cicari.p001270.gaveta.util.UsersAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class MessageActivity extends AppCompatActivity {
    private String TAG = "testeclass";
    private UsersAdapter adapter;
    private String chave;
    private String complemento;
    private int contadorAmigos = 0;
    private EditText edMessageToSend;
    private String emailAmigo;
    private FirebaseUser fireBaseAccount;
    private String idAmigo;
    private ListView listView;
    public List<String> listaaa;
    private FirebaseAuth mAuth;
    private RecyclerView mChatsRecyclerView;
    private DatabaseReference mDatabaseMensagens;
    private DatabaseReference mDatabaseMensagensListener;
    private DatabaseReference mDatabaseReferencePesquisa;
    private DatabaseReference mDatabaseReferencePesquisaMensagens;
    private LinearLayoutManager mLayoutManager;
    private EditText mMessageEditText;
    private DatabaseReference mMessagesDBRef;
    private List<ChatMessage> mMessagesList = new ArrayList();
    private String mReceiverId;
    private String mReceiverName;
    private ImageButton mSendImageButton;
    private List<User> mUsersList = new ArrayList();
    private DatabaseReference mUsersRef;
    private String tbUsuario;
    private User user;

    class C03421 implements OnClickListener {
        C03421() {
        }

        public void onClick(View view) {
            view = MessageActivity.this.mMessageEditText.getText().toString();
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            if (view.isEmpty()) {
                Toast.makeText(MessageActivity.this, "You must enter a message", 0).show();
            } else {
                MessageActivity.this.sendMessageToFirebase(view, uid, MessageActivity.this.idAmigo);
            }
        }
    }

    class C05152 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05152() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            MessageActivity.this.mMessagesList.clear();
        }
    }

    class C05163 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05163() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            MessageActivity.this.mReceiverName = ((User1) dataSnapshot.getValue(User1.class)).getDisplayName();
            try {
                MessageActivity.this.getSupportActionBar().setTitle(MessageActivity.this.mReceiverName);
                MessageActivity.this.getActionBar().setTitle(MessageActivity.this.mReceiverName);
            } catch (DataSnapshot dataSnapshot2) {
                dataSnapshot2.printStackTrace();
            }
        }
    }

    class C05174 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05174() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                if (dataSnapshot2.child("email").getValue().toString().contains(MessageActivity.this.emailAmigo)) {
                    MessageActivity.this.idAmigo = dataSnapshot2.child("id").getValue().toString();
                    return;
                }
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_chat_messages);
        this.mChatsRecyclerView = (RecyclerView) findViewById(C0346R.id.messagesRecyclerView);
        this.mMessageEditText = (EditText) findViewById(C0346R.id.messageEditText);
        this.mSendImageButton = (ImageButton) findViewById(C0346R.id.sendMessageImagebutton);
        this.mChatsRecyclerView.setHasFixedSize(true);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mLayoutManager.setStackFromEnd(true);
        this.mChatsRecyclerView.setLayoutManager(this.mLayoutManager);
        setSupportActionBar((Toolbar) findViewById(C0346R.id.toolbar));
        TextView textView = (TextView) findViewById(C0346R.id.tvSendMessage);
        this.edMessageToSend = (EditText) findViewById(C0346R.id.edMessageToSend);
        this.tbUsuario = getResources().getString(C0346R.string._USUARIOS);
        this.mDatabaseMensagensListener = FirebaseDatabase.getInstance().getReference().child("mensagens");
        this.mMessagesDBRef = FirebaseDatabase.getInstance().getReference().child("mensagens");
        this.mUsersRef = FirebaseDatabase.getInstance().getReference().child("Users");
        this.mAuth = FirebaseAuth.getInstance();
        this.fireBaseAccount = this.mAuth.getCurrentUser();
        this.chave = "";
        pesquisaIdAmigo();
        this.mSendImageButton.setOnClickListener(new C03421());
        bundle = getIntent().getExtras();
        if (bundle != null) {
            this.emailAmigo = bundle.getString("amigoParaContato");
        }
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void sendMessageToFirebase(String str, String str2, String str3) {
        this.mMessagesList.clear();
    }

    private void querymessagesBetweenThisUserAndClickedUser() {
        this.mMessagesDBRef.addValueEventListener(new C05152());
    }

    private void queryRecipientName(String str) {
        this.mUsersRef.child(str).addValueEventListener(new C05163());
    }

    public void pesquisaIdAmigo() {
        this.mDatabaseReferencePesquisa = FirebaseDatabase.getInstance().getReference().child(this.tbUsuario);
        this.mDatabaseReferencePesquisa.addValueEventListener(new C05174());
    }
}

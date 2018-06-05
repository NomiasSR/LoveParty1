package com.cicari.p001270.gaveta;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.cicari.p001270.gaveta.model.ChatMessage;
import com.cicari.p001270.gaveta.util.MessagesAdapter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ChatMessagesActivity extends AppCompatActivity {
    private MessagesAdapter adapter = null;
    private RecyclerView mChatsRecyclerView;
    private LinearLayoutManager mLayoutManager;
    private EditText mMessageEditText;
    private DatabaseReference mMessagesDBRef;
    private List<ChatMessage> mMessagesList = new ArrayList();
    private String mReceiverId;
    private String mReceiverName;
    private ImageButton mSendImageButton;
    private DatabaseReference mUsersRef;

    class C03321 implements OnClickListener {
        C03321() {
        }

        public void onClick(View view) {
            view = ChatMessagesActivity.this.mMessageEditText.getText().toString();
            String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
            if (view.isEmpty()) {
                Toast.makeText(ChatMessagesActivity.this, "You must enter a message", 0).show();
            } else {
                ChatMessagesActivity.this.sendMessageToFirebase(view, uid, ChatMessagesActivity.this.mReceiverId);
            }
        }
    }

    class C05022 implements OnCompleteListener<Void> {
        C05022() {
        }

        public void onComplete(@NonNull Task<Void> task) {
            if (task.isSuccessful()) {
                Toast.makeText(ChatMessagesActivity.this, "Message sent successfully!", 0).show();
                ChatMessagesActivity.this.mMessageEditText.setText(null);
                ChatMessagesActivity.this.hideSoftKeyboard();
                return;
            }
            Context context = ChatMessagesActivity.this;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Error ");
            stringBuilder.append(task.getException().getLocalizedMessage());
            Toast.makeText(context, stringBuilder.toString(), 0).show();
        }
    }

    class C05033 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05033() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            ChatMessagesActivity.this.mMessagesList.clear();
            for (DataSnapshot value : dataSnapshot.getChildren()) {
                ChatMessage chatMessage = (ChatMessage) value.getValue(ChatMessage.class);
                if ((chatMessage.getSenderId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()) && chatMessage.getReceiverId().equals(ChatMessagesActivity.this.mReceiverId)) || (chatMessage.getSenderId().equals(ChatMessagesActivity.this.mReceiverId) && chatMessage.getReceiverId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()))) {
                    ChatMessagesActivity.this.mMessagesList.add(chatMessage);
                }
            }
            ChatMessagesActivity.this.populateMessagesRecyclerView();
        }
    }

    class C05044 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05044() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            ChatMessagesActivity.this.mReceiverName = dataSnapshot.child("name").getValue().toString();
            try {
                ChatMessagesActivity.this.getSupportActionBar().setTitle(ChatMessagesActivity.this.mReceiverName);
                ChatMessagesActivity.this.getActionBar().setTitle(ChatMessagesActivity.this.mReceiverName);
            } catch (DataSnapshot dataSnapshot2) {
                dataSnapshot2.printStackTrace();
            }
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_chat_messages);
        this.mChatsRecyclerView = (RecyclerView) findViewById(C0346R.id.messagesRecyclerView);
        this.mMessageEditText = (EditText) findViewById(C0346R.id.messageEditText);
        this.mSendImageButton = (ImageButton) findViewById(C0346R.id.sendMessageImagebutton);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mChatsRecyclerView.setHasFixedSize(true);
        this.mLayoutManager.setStackFromEnd(true);
        this.mChatsRecyclerView.setLayoutManager(this.mLayoutManager);
        this.mMessagesDBRef = FirebaseDatabase.getInstance().getReference().child("mensagens");
        this.mUsersRef = FirebaseDatabase.getInstance().getReference().child("usuarios");
        this.mReceiverId = getIntent().getStringExtra("USER_ID");
        this.mSendImageButton.setOnClickListener(new C03321());
    }

    protected void onStart() {
        super.onStart();
        querymessagesBetweenThisUserAndClickedUser();
        queryRecipientName(this.mReceiverId);
    }

    private void sendMessageToFirebase(String str, String str2, String str3) {
        this.mMessagesList.clear();
        this.mMessagesDBRef.push().setValue(new ChatMessage(str, str2, str3)).addOnCompleteListener(new C05022());
    }

    public void hideSoftKeyboard() {
        if (getCurrentFocus() != null) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    private void querymessagesBetweenThisUserAndClickedUser() {
        this.mMessagesDBRef.addValueEventListener(new C05033());
    }

    private void populateMessagesRecyclerView() {
        this.adapter = new MessagesAdapter(this.mMessagesList, this);
        this.mChatsRecyclerView.setAdapter(this.adapter);
    }

    private void queryRecipientName(String str) {
        this.mUsersRef.child(str).addValueEventListener(new C05044());
    }
}

package com.cicari.p001270.gaveta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import com.cicari.p001270.gaveta.model.User1;
import com.cicari.p001270.gaveta.util.UsersAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class ChatUsersActivity extends AppCompatActivity {
    private UsersAdapter adapter;
    private FirebaseAuth mAuth;
    private LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private DatabaseReference mUsersDBRef;
    private List<User1> mUsersList = new ArrayList();

    class C05051 implements ValueEventListener {
        public void onCancelled(DatabaseError databaseError) {
        }

        C05051() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            if (dataSnapshot.getChildrenCount() > 0) {
                for (DataSnapshot value : dataSnapshot.getChildren()) {
                    User1 user1 = (User1) value.getValue(User1.class);
                    try {
                        if (!user1.getUserId().equals(ChatUsersActivity.this.mAuth.getCurrentUser().getUid())) {
                            ChatUsersActivity.this.mUsersList.add(user1);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            ChatUsersActivity.this.populaterecyclerView();
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C0346R.layout.activity_chat_users);
        this.mAuth = FirebaseAuth.getInstance();
        bundle = FirebaseDatabase.getInstance().getReference();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("usuarios/");
        stringBuilder.append(FirebaseAuth.getInstance().getUid());
        stringBuilder.append("/contatos/");
        this.mUsersDBRef = bundle.child(stringBuilder.toString());
        this.mRecyclerView.setHasFixedSize(true);
        this.mLayoutManager = new LinearLayoutManager(this);
        this.mRecyclerView.setLayoutManager(this.mLayoutManager);
    }

    private void populaterecyclerView() {
        this.adapter = new UsersAdapter(this.mUsersList, this);
        this.mRecyclerView.setAdapter(this.adapter);
    }

    private void queryUsersAndAddthemToList() {
        this.mUsersDBRef.addValueEventListener(new C05051());
    }

    protected void onStart() {
        super.onStart();
        queryUsersAndAddthemToList();
    }
}

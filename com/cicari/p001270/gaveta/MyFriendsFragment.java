package com.cicari.p001270.gaveta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class MyFriendsFragment extends ListFragment implements OnItemClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String TAG = "testeclass";
    public ArrayAdapter<String> adapter;
    private HashMap<String, String> dadosTemp;
    private FirebaseUser fireBaseAccount;
    private boolean limparLista = true;
    public List<String> listaaa;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabaseReferencePesquisa;
    private DatabaseReference mDatabaseReferencePesquisa1;
    private DatabaseReference mDbRef;
    private OnCommunicateInterfaceFriends mListenerFriends;
    private String mParam1;
    private String mParam2;
    private String tbContatos;
    private String tbUsuario;
    public TabLayout tbl_pages;

    class C03431 implements OnClickListener {
        C03431() {
        }

        public void onClick(View view) {
            MyFriendsFragment.this.getActivity().startActivity(new Intent(MyFriendsFragment.this.getActivity(), FriendActivity.class));
        }
    }

    class C05192 implements ValueEventListener {

        class C03441 extends HashMap<String, String> {
            C03441() {
            }
        }

        class C05182 implements ValueEventListener {
            public void onCancelled(DatabaseError databaseError) {
            }

            C05182() {
            }

            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnapshot2 : dataSnapshot.getChildren()) {
                    String str = "- offline";
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(dataSnapshot2.child("name").getValue().toString());
                    stringBuilder.append(" (");
                    stringBuilder.append(dataSnapshot2.child("email").getValue().toString());
                    stringBuilder.append(") ");
                    String stringBuilder2 = stringBuilder.toString();
                    if (dataSnapshot2.child("logado").getValue().toString().equalsIgnoreCase("n")) {
                        MyFriendsFragment.this.dadosTemp.remove(stringBuilder2);
                        HashMap access$000 = MyFriendsFragment.this.dadosTemp;
                        StringBuilder stringBuilder3 = new StringBuilder();
                        stringBuilder3.append(stringBuilder2);
                        stringBuilder3.append(str);
                        access$000.put(stringBuilder3.toString(), null);
                    } else {
                        HashMap access$0002 = MyFriendsFragment.this.dadosTemp;
                        StringBuilder stringBuilder4 = new StringBuilder();
                        stringBuilder4.append(stringBuilder2);
                        stringBuilder4.append(str);
                        access$0002.remove(stringBuilder4.toString());
                        MyFriendsFragment.this.dadosTemp.put(stringBuilder2, dataSnapshot2.child("id").getValue().toString());
                    }
                }
                MyFriendsFragment.this.adapter.clear();
                for (Entry key : MyFriendsFragment.this.dadosTemp.entrySet()) {
                    MyFriendsFragment.this.listaaa.add(key.getKey().toString());
                }
            }
        }

        public void onCancelled(DatabaseError databaseError) {
        }

        C05192() {
        }

        public void onDataChange(DataSnapshot dataSnapshot) {
            MyFriendsFragment.this.dadosTemp = new C03441();
            MyFriendsFragment.this.dadosTemp.clear();
            MyFriendsFragment.this.listaaa.clear();
            for (DataSnapshot value : dataSnapshot.getChildren()) {
                FirebaseDatabase.getInstance().getReference(MyFriendsFragment.this.tbUsuario).orderByChild("id").equalTo(value.getValue().toString()).addValueEventListener(new C05182());
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0346R.layout.myfriends_fragment, viewGroup, false);
    }

    public static MyFriendsFragment newInstance(String str, String str2) {
        MyFriendsFragment myFriendsFragment = new MyFriendsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        myFriendsFragment.setArguments(bundle);
        return myFriendsFragment;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        ((Button) getActivity().findViewById(C0346R.id.btnAddFriend)).setOnClickListener(new C03431());
        this.listaaa = new ArrayList();
        this.adapter = new ArrayAdapter(getContext(), C0346R.layout.rowlayout, C0346R.id.label, this.listaaa);
        setListAdapter(this.adapter);
        this.adapter.notifyDataSetChanged();
        getListView().setOnItemClickListener(this);
        this.tbUsuario = getResources().getString(C0346R.string._USUARIOS);
        this.tbContatos = getResources().getString(C0346R.string._CONTATOS);
        bundle = FirebaseDatabase.getInstance();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.tbUsuario);
        stringBuilder.append("/");
        stringBuilder.append(FirebaseAuth.getInstance().getUid());
        stringBuilder.append("/");
        stringBuilder.append(this.tbContatos);
        this.mDatabaseReferencePesquisa = bundle.getReference(stringBuilder.toString());
        this.mDatabaseReferencePesquisa.addValueEventListener(new C05192());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public void onResume() {
        super.onResume();
        if (!getUserVisibleHint()) {
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (z && isResumed()) {
            onResume();
        }
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String str = (String) getListAdapter().getItem(i);
        view = new Intent(getActivity(), ChatMessagesActivity.class);
        view.putExtra("amigoParaContato", str);
        if (this.dadosTemp.get(str) == 0) {
            Toast.makeText(getActivity(), "You can't send message because the user is offline.", 1).show();
        } else if (this.dadosTemp.containsKey(str) != 0) {
            view.putExtra("USER_ID", (String) this.dadosTemp.get(str));
            getActivity().startActivity(view);
        }
    }
}

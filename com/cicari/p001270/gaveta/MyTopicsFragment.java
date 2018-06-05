package com.cicari.p001270.gaveta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ListFragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class MyTopicsFragment extends ListFragment implements OnItemClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public ArrayAdapter<String> adapter;
    HashMap<Integer, String> dadosTemp = new HashMap();
    private DatabaseReference mDatabaseReferencePesquisa;
    private OnCommunicateInterface mListener;
    private String mParam1;
    private String mParam2;
    public EditText nameCapture;
    private ArrayList<String> partialNames = new ArrayList();
    private ArrayList<String> searchNames = new ArrayList();
    private String tbContatos;
    private String tbUsuario;
    private User user;

    class C03451 implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        C03451() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            MyTopicsFragment.this.AlterAdapter();
        }
    }

    class C05233 implements OnFailureListener {
        public void onFailure(@NonNull Exception exception) {
        }

        C05233() {
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(C0346R.layout.mytopics_fragment, viewGroup, false);
    }

    public static MyTopicsFragment newInstance(String str, String str2) {
        MyTopicsFragment myTopicsFragment = new MyTopicsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ARG_PARAM1, str);
        bundle.putString(ARG_PARAM2, str2);
        myTopicsFragment.setArguments(bundle);
        return myTopicsFragment;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.nameCapture = (EditText) getActivity().findViewById(C0346R.id.edTopicoPesquisar);
        this.adapter = new ArrayAdapter(getContext(), C0346R.layout.rowlayout, C0346R.id.label, this.partialNames);
        this.adapter.notifyDataSetChanged();
        setListAdapter(this.adapter);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.mParam1 = getArguments().getString(ARG_PARAM1);
            this.mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private void AlterAdapter() {
        this.partialNames.clear();
        int i = 0;
        if (this.nameCapture.getText().toString().isEmpty()) {
            while (i < this.searchNames.size()) {
                this.partialNames.add(((String) this.searchNames.get(i)).toString());
                i++;
            }
        } else {
            while (i < this.searchNames.size()) {
                if (((String) this.searchNames.get(i)).toString().toUpperCase().contains(this.nameCapture.getText().toString().toUpperCase())) {
                    this.partialNames.add(((String) this.searchNames.get(i)).toString());
                }
                i++;
            }
        }
        this.adapter.notifyDataSetChanged();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCommunicateInterface) {
            this.mListener = (OnCommunicateInterface) context;
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(context.toString());
        stringBuilder.append(" must implement OnCommunicateInterface");
        throw new RuntimeException(stringBuilder.toString());
    }

    public void onDetach() {
        super.onDetach();
    }

    public void onResume() {
        super.onResume();
        if (!getUserVisibleHint()) {
        }
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
        if (isVisible() && z && this.mListener) {
            z = false;
            HashMap dadosMapa = this.mListener.getDadosMapa();
            Collection arrayList = new ArrayList();
            for (Entry entry : dadosMapa.entrySet()) {
                arrayList.add(entry.getValue());
                this.dadosTemp.put(Integer.valueOf(z), entry.getKey().toString());
                z++;
            }
            this.searchNames.clear();
            this.searchNames.addAll(arrayList);
            this.adapter = new ArrayAdapter(getContext(), C0346R.layout.rowlayout, C0346R.id.label, this.partialNames);
            setListAdapter(this.adapter);
            this.adapter.notifyDataSetChanged();
            getListView().setOnItemClickListener(this);
            this.nameCapture.setText("");
            AlterAdapter();
            this.nameCapture.addTextChangedListener(new C03451());
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        adapterView = ((String) this.dadosTemp.get(Integer.valueOf(i))).toString().split("\\|\\|");
        final String str = adapterView[null];
        final String str2 = adapterView[1];
        final Intent intent = new Intent(getActivity(), ChatMessagesActivity.class);
        final String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        this.user = new User(getResources(), getActivity().getApplicationContext());
        this.tbUsuario = getResources().getString(C0346R.string._USUARIOS);
        this.tbContatos = getResources().getString(C0346R.string._CONTATOS);
        final DatabaseReference reference = FirebaseDatabase.getInstance().getReference();
        final Map hashMap = new HashMap();
        adapterView = new StringBuilder();
        adapterView.append("/");
        adapterView.append(this.tbUsuario);
        adapterView.append("/");
        adapterView.append(str);
        adapterView.append("/");
        adapterView.append(this.tbContatos);
        adapterView.append("/");
        adapterView.append(uid);
        hashMap.put(adapterView.toString(), uid);
        reference.updateChildren(hashMap).addOnFailureListener(new C05233()).addOnSuccessListener(new OnSuccessListener<Void>() {

            class C05201 implements OnSuccessListener<Void> {
                C05201() {
                }

                public void onSuccess(Void voidR) {
                    intent.putExtra("amigoParaContato", str2);
                    intent.putExtra("USER_ID", str);
                    MyTopicsFragment.this.getActivity().startActivity(intent);
                }
            }

            class C05212 implements OnFailureListener {
                public void onFailure(@NonNull Exception exception) {
                }

                C05212() {
                }
            }

            public void onSuccess(Void voidR) {
                voidR = hashMap;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("/");
                stringBuilder.append(MyTopicsFragment.this.tbUsuario);
                stringBuilder.append("/");
                stringBuilder.append(uid);
                stringBuilder.append("/");
                stringBuilder.append(MyTopicsFragment.this.tbContatos);
                stringBuilder.append("/");
                stringBuilder.append(str);
                voidR.put(stringBuilder.toString(), str);
                reference.updateChildren(hashMap).addOnFailureListener(new C05212()).addOnSuccessListener(new C05201());
            }
        });
    }
}

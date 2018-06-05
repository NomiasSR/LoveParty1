package com.cicari.p001270.gaveta.util;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cicari.p001270.gaveta.C0346R;
import com.cicari.p001270.gaveta.MessageActivity;
import com.cicari.p001270.gaveta.model.User1;
import com.squareup.picasso.Picasso;
import java.util.List;

public class UsersAdapter extends Adapter<ViewHolder> {
    private Context mContext;
    private List<User1> mUsersList;

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public View layout;
        public ImageView personImageImgV;
        public TextView personNameTxtV;

        public ViewHolder(View view) {
            super(view);
            this.layout = view;
            this.personNameTxtV = (TextView) view.findViewById(C0346R.id.userName);
            this.personImageImgV = (ImageView) view.findViewById(C0346R.id.userImage);
        }
    }

    public void add(int i, User1 user1) {
        this.mUsersList.add(i, user1);
        notifyItemInserted(i);
    }

    public void remove(int i) {
        this.mUsersList.remove(i);
        notifyItemRemoved(i);
    }

    public UsersAdapter(List<User1> list, Context context) {
        this.mUsersList = list;
        this.mContext = context;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C0346R.layout.user_single_row, viewGroup, false));
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final User1 user1 = (User1) this.mUsersList.get(i);
        viewHolder.personNameTxtV.setText(user1.getDisplayName());
        try {
            Picasso.with(this.mContext).load(user1.getImage()).placeholder((int) C0346R.mipmap.ic_launcher).into(viewHolder.personImageImgV);
        } catch (Exception e) {
            e.printStackTrace();
        }
        viewHolder.layout.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                UsersAdapter.this.goToUpdateActivity(user1.getUserId());
            }
        });
    }

    private void goToUpdateActivity(String str) {
        Intent intent = new Intent(this.mContext, MessageActivity.class);
        intent.putExtra("USER_ID", str);
        this.mContext.startActivity(intent);
    }

    public int getItemCount() {
        return this.mUsersList.size();
    }
}

package com.cicari.p001270.gaveta.util;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cicari.p001270.gaveta.C0346R;
import com.cicari.p001270.gaveta.model.ChatMessage;
import com.google.firebase.auth.FirebaseAuth;
import java.util.List;

public class MessagesAdapter extends Adapter<ViewHolder> {
    public static final int ITEM_TYPE_RECEIVED = 1;
    public static final int ITEM_TYPE_SENT = 0;
    int anterior = 300;
    private Context mContext;
    private List<ChatMessage> mMessagesList;
    View f18v = null;

    public class ViewHolder2 extends android.support.v7.widget.RecyclerView.ViewHolder {
        public View layout;
        public TextView messageTextView;

        public ViewHolder2(View view) {
            super(view);
            this.layout = view;
            this.messageTextView = (TextView) view.findViewById(C0346R.id.chatMsgTextView);
        }
    }

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        public View layout;
        public TextView messageTextView;

        public ViewHolder(View view) {
            super(view);
            this.layout = view;
            this.messageTextView = (TextView) view.findViewById(C0346R.id.chatMsgTextView);
        }
    }

    public void add(int i, ChatMessage chatMessage) {
        this.mMessagesList.add(i, chatMessage);
        notifyItemInserted(i);
    }

    public void remove(int i) {
        this.mMessagesList.remove(i);
        notifyItemRemoved(i);
    }

    public MessagesAdapter(List<ChatMessage> list, Context context) {
        this.mMessagesList = list;
        this.mContext = context;
    }

    public int getItemViewType(int i) {
        return ((ChatMessage) this.mMessagesList.get(i)).getSenderId().equals(FirebaseAuth.getInstance().getCurrentUser().getUid()) != 0 ? 0 : 1;
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.anterior != i) {
            this.anterior = i;
            viewGroup = 20;
        } else {
            viewGroup = 1;
        }
        if (i == 0) {
            this.f18v = LayoutInflater.from(this.mContext).inflate(C0346R.layout.sent_msg_row, null);
        } else if (i == 1) {
            this.f18v = LayoutInflater.from(this.mContext).inflate(C0346R.layout.received_msg_row, null);
        }
        this.f18v.setPadding(10, 10, 10, viewGroup);
        return new ViewHolder(this.f18v);
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        viewHolder.messageTextView.setText(((ChatMessage) this.mMessagesList.get(i)).getMessage());
    }

    public int getItemCount() {
        return this.mMessagesList.size();
    }

    public static String convertDate(String str, String str2) {
        return DateFormat.format(str2, Long.parseLong(str)).toString();
    }
}

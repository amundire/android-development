package com.example.ninegag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

class CommentItemViewHolder extends RecyclerView.ViewHolder {

    TextView txt_comment;
    TextView txt_user;
    TextView txt_time;
    TextView txt_date;

    public CommentItemViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_comment = itemView.findViewById(R.id.txt_comment);
        txt_user = itemView.findViewById(R.id.txt_user);
        txt_time = itemView.findViewById(R.id.txt_time);
        txt_date = itemView.findViewById(R.id.txt_date);
    }
}

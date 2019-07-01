package com.example.ninegag;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CommentAdapter extends RecyclerView.Adapter<CommentItemViewHolder> {

    ArrayList<CommentItem> comments;
    private Context context ;

    public CommentAdapter(ArrayList<CommentItem> comments, Context context) {
        this.comments = comments;
        this.context = context;

    }

    @NonNull
    @Override
    public CommentItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_comment, viewGroup, false);
        CommentItemViewHolder holder = new CommentItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentItemViewHolder commentItemViewHolder, int position) {
        CommentItem commentItem = comments.get(position);
        commentItemViewHolder.txt_date.setText(commentItem.date);
        commentItemViewHolder.txt_comment.setText(commentItem.text);
        commentItemViewHolder.txt_time.setText(commentItem.time);
        commentItemViewHolder.txt_user.setText(commentItem.user);
    }

    @Override
    public int getItemCount() {
        return comments.size();
    }
}

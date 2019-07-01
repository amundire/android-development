package com.example.ninegag;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MemeItemViewHolder extends RecyclerView.ViewHolder{

    ImageView image;
    TextView txt_title;
    TextView txt_points;
    TextView txt_comments;
    Button btnUpvote;
    Button btnDownvote;
    Button btnComment;
    Button btnShare;
    Button btnBuy;
    MemeItem dataItem;

    public MemeItemViewHolder(@NonNull View itemView, final MemeItemUpListener upListener, final MemeItemDownListener downListener, final MemeItemCommentListener commentListener, final MemeItemShareListener shareListener, final AdItemBuyListener buyListener) {
        super(itemView);
        image = itemView.findViewById(R.id.image);
        txt_title = itemView.findViewById(R.id.txt_title);
        txt_points = itemView.findViewById(R.id.txt_points);
        txt_comments = itemView.findViewById(R.id.txt_comments);
        btnUpvote = itemView.findViewById(R.id.btnUpvote);
        btnDownvote = itemView.findViewById(R.id.btnDownvote);
        btnComment = itemView.findViewById(R.id.btnComment);
        btnShare = itemView.findViewById(R.id.btnShare);
        btnBuy = itemView.findViewById(R.id.btnBuy);

        if(btnUpvote != null){
            btnUpvote.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    upListener.onMemeItemUpClicked(dataItem);
                }
            });
            btnDownvote.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    downListener.onMemeItemDownClicked(dataItem);
                }
            });
            btnComment.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    commentListener.onMemeItemCommentClicked(dataItem);
                }
            });
            btnShare.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    shareListener.onMemeItemShareClicked(dataItem);
                }
            });
        }else{
            btnBuy.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    buyListener.onAdItemBuyClicked(dataItem);
                }
            });
        }

    }

    public void setDataItem(MemeItem dataItem) {
        this.dataItem = dataItem;
    }

    public interface MemeItemUpListener{
        void onMemeItemUpClicked(MemeItem item);
    }

    public interface MemeItemDownListener{
        void onMemeItemDownClicked(MemeItem item);
    }

    public interface MemeItemShareListener{
        void onMemeItemShareClicked(MemeItem item);
    }

    public interface MemeItemCommentListener{
        void onMemeItemCommentClicked(MemeItem item);
    }

    public interface AdItemBuyListener{
        void onAdItemBuyClicked(MemeItem item);
    }
}

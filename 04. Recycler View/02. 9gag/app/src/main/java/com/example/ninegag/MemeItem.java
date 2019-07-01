package com.example.ninegag;

import android.widget.Button;

public class MemeItem {


    public MemeItem(int imageSrc, String title, String points, String comments, Boolean isUpvoted, Boolean isDownvoted) {
        this.imageSrc = imageSrc;
        this.title = title;
        this.points = points;
        this.comments = comments;
        this.isUpvoted = isUpvoted;
        this.isDownvoted = isDownvoted;
        this.btnDownvote = btnDownvote;
        this.btnUpvote = btnUpvote;
        this.btnShare = btnShare;
        this.btnComment = btnComment;
        this.btnBuy = btnBuy;
    }

    int imageSrc;
    String title;
    String points;
    String comments;
    Boolean isUpvoted;
    Boolean isDownvoted;
    Button btnDownvote;
    Button btnUpvote;
    Button btnShare;
    Button btnComment;
    Button btnBuy;
}

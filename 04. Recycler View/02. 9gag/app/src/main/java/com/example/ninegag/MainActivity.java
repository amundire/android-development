package com.example.ninegag;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.MenuItemHoverListener;
import android.widget.Toast;

import com.example.ninegag.databinding.ActivityMainBinding;

import org.w3c.dom.Comment;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    MemeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setUpRecView();
    }

    private void setUpRecView() {
        adapter = new MemeAdapter(getDownClickListener(), getUpClickListener(), getShareClickListener(), getCommentClickListener(), getBuyClickListener());
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
    }

    private MemeItemViewHolder.AdItemBuyListener getBuyClickListener() {
        return new MemeItemViewHolder.AdItemBuyListener() {
            @Override
            public void onAdItemBuyClicked(MemeItem item) {
                String url = "http://www.google.com";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
    }

    private MemeItemViewHolder.MemeItemShareListener getShareClickListener(){
        return new MemeItemViewHolder.MemeItemShareListener() {
            @Override
            public void onMemeItemShareClicked(MemeItem item) {
                Intent shareIntent = new Intent();
                shareIntent.setAction(Intent.ACTION_SEND);
                shareIntent.setType("image/png");
                Uri uri = Uri.parse("android.resource://your package name/" + item.imageSrc);
                shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
                shareIntent.putExtra(Intent.EXTRA_TEXT, item.title);
                startActivity(Intent.createChooser(shareIntent, "Send your image"));
            }
        };
    }

    private MemeItemViewHolder.MemeItemCommentListener getCommentClickListener(){
        return new MemeItemViewHolder.MemeItemCommentListener() {
            @Override
            public void onMemeItemCommentClicked(MemeItem item) {
                Intent redirectToComment = new Intent(MainActivity.this, CommentActivity.class);
                redirectToComment.putExtra("meme_title", item.title);
                startActivity(redirectToComment);
            }
        };
    }

    private MemeItemViewHolder.MemeItemUpListener getUpClickListener() {
        return new MemeItemViewHolder.MemeItemUpListener() {
            @Override
            public void onMemeItemUpClicked(MemeItem item) {
                item.isDownvoted = false;
                item.isUpvoted = true;
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Upvoted " + item.title, Toast.LENGTH_SHORT).show();

            }
        };
    }
    private MemeItemViewHolder.MemeItemDownListener getDownClickListener() {
        return new MemeItemViewHolder.MemeItemDownListener() {
            @Override
            public void onMemeItemDownClicked(MemeItem item) {
                item.isDownvoted = true;
                item.isUpvoted = false;
                adapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Downvoted " + item.title, Toast.LENGTH_SHORT).show();
            }
        };
    }
}

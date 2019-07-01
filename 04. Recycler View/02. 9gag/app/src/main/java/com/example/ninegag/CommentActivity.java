package com.example.ninegag;

import android.annotation.SuppressLint;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ninegag.databinding.ActivityCommentBinding;

import org.w3c.dom.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CommentActivity extends AppCompatActivity {

    CommentAdapter adapter;
    ActivityCommentBinding binding;
    EditText commentInput;
    Button commentButton;
    ArrayList<CommentItem> comments = new ArrayList<CommentItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Comments for " + getIntent().getStringExtra("meme_title"));

        setUpCommentInputs();
        setUpRecView();
    }

    private void setUpCommentInputs() {
        commentButton = binding.btnComment;
        commentInput = binding.inputComment;

        commentButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String input = commentInput.getText().toString();
                @SuppressLint("SimpleDateFormat")
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date date = new Date();
                System.out.println(dateFormat.format(date));
                String[] dateAndTime = dateFormat.format(date).split("\\s+");

                CommentItem newComment = new CommentItem(dateAndTime[0], "username123", dateAndTime[1], input);

                comments.add(newComment);

                adapter.notifyDataSetChanged();
            }
        });

    }

    private void setUpRecView() {
        CommentItem placeholder = new CommentItem("5/09/2019", "username", "12:45", "Comment Text");
        CommentItem placeholder2 = new CommentItem("5/09/2019", "username", "12:45", "Long comment with a lot of text. Consider it when designing the Layout of the views.");

        comments.add(placeholder);
        comments.add(placeholder2);

        adapter = new CommentAdapter(comments, CommentActivity.this);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
    }
}

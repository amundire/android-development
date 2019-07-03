package com.example.catfacts;

import android.content.Intent;
import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catfacts.databinding.ActivityMainBinding;
import com.example.catfacts.models.FactService.RetrofitWrapper;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    Button refresh;
    Button share;
    SwipeRefreshLayout refreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupButtons();
        setupSwipeRefresh();
    }

    private void setupButtons() {
        refresh = binding.btnRefresh;
        share = binding.btnShare;
        refresh.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onRefreshAction();
            }
        });
        share.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                onShare();
            }
        });
    }

    private void onShare() {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, binding.txtFact.getText().toString());
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    private void onRefreshAction(){
        RetrofitWrapper wrapper = RetrofitWrapper.getInstance();
        //https://cat-fact.herokuapp.com/facts/random
        wrapper.getFact(MainActivity.this, binding);
        share.setVisibility(View.VISIBLE);
        refreshLayout.setRefreshing(false);
    }

    private void setupSwipeRefresh(){
        refreshLayout = binding.refreshLayout;
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                onRefreshAction();
            }
        });
    }
}

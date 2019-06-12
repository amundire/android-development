package com.example.library;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //String appTitle = getResources().getString(R.string.app_name);
        //displayTitle(appTitle);
    }
    //protected void displayTitle(String Title){
    //    TextView title = findViewById(R.id.textView);
    //    title.setText(Title);
    //}
}
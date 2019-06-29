package com.example.loginscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //data passed from activity to activity via extra
        String email = getIntent().getStringExtra("user_email");
        TextView emailMain = findViewById(R.id.main_email);

        emailMain.setText(email);
    };
}

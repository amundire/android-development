package com.example.loginscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onStart(){
        super.onStart();

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);

        email.setHint(R.string.email);
        password.setHint(R.string.password);


        Button btn = (Button)findViewById(R.id.loginButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButtonClick(v);
                //startEmailClient();
            }
        });

        TextView registerhref = (TextView)findViewById(R.id.loginNewAcc);
        registerhref.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                redirectToRegister();
            }

        });
    }

    private void redirectToRegister() {
        Intent registerActInt = new Intent(this, RegisterActivity.class);
        startActivity(registerActInt);
    }

    private void startEmailClient() {
        String emailString = email.getText().toString();

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, emailString);
        sendIntent.setType("text/plain");

        if(sendIntent.resolveActivity(getPackageManager()) != null){
            startActivity(sendIntent);
        }
    }

    protected void loginButtonClick(View v){
        Intent mainActInt = new Intent(this, MainActivity.class);
        String emailText = email.getText().toString();
        mainActInt.putExtra("user_email", emailText);
        startActivity(mainActInt);
    }
}

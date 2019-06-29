package com.example.loginscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText email;
    private EditText password;
    private EditText passwordRepeat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    protected void onStart(){
        super.onStart();

        email = findViewById(R.id.emailText);
        password = findViewById(R.id.passwordText);
        passwordRepeat = findViewById(R.id.passwordRepeatText);

        email.setHint(R.string.email);
        password.setHint(R.string.password);
        passwordRepeat.setHint(R.string.passwordRepeat);

        Button btn = (Button)findViewById(R.id.registerButton);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerButtonClick(v);
                //startEmailClient();
            }
        });

    }

    protected void registerButtonClick(View v){
        String pw = password.getText().toString();
        String rpw = passwordRepeat.getText().toString();

        if(rpw.equals(pw)){
            Intent mainActInt = new Intent(this, MainActivity.class);
            String emailText = email.getText().toString();
            mainActInt.putExtra("user_email", emailText);
            startActivity(mainActInt);
        }else{
            Context context = getApplicationContext();
            int duration = Toast.LENGTH_LONG;
            //had to unblock notifications from the app settings in the phone for this to work
            Toast toast = Toast.makeText(context, "Passwords not matching", duration);
            toast.show();
        }
    }
}
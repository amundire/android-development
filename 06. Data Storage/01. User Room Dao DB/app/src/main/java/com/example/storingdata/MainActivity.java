package com.example.storingdata;

import android.arch.persistence.room.Room;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.storingdata.data.local.AppDatabase;
import com.example.storingdata.data.local.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<User> allUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final AppDatabase db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "db-name-db").build();

        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                User userEntity = new User();

                userEntity.setFirstName("First");
                userEntity.setLastName("Last");
                db.userDao().insertSingleUser(userEntity);

                for (int i = 0; i < 20; i++) {

                    User user = new User();
                    user.setFirstName("First " + i);
                    user.setLastName("Last");

                    db.userDao().insertSingleUser(user);
                }
                allUsers = db.userDao().getAll();

                for (User u : allUsers) {
                    Log.e("user", u.toString());
                }
            }
        });


    }
}

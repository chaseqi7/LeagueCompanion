package com.example.zqi4525.leaguecompanion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class RegisterActivity extends AppCompatActivity {
    private User user;
    private AppDatabase database;
    private EditText ign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = AppDatabase.getDatabase(getApplicationContext());
        database.userDao().removeAllUsers();
        List<User> users = database.userDao().getAllUser();
        if (users.size()==0) {
            database.userDao().addUser(new User(1, "Test 1", "123"));
            user = database.userDao().getAllUser().get(0);
            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
            database.userDao().addUser(new User(2, "Test 2", "213"));
        }

        updateFirstUserData();
        ign = (EditText)findViewById(R.id.ignText);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                            Context context = getApplicationContext();
                            CharSequence text = ign.getText().toString()+" successfully registered.";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                            startActivity(intent);
                    }
                }
        );
    }

    private void updateFirstUserData() {
        List<User> user = database.userDao().getAllUser();
        

    }
}

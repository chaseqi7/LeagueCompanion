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
    private EditText emailText;
    private EditText passwordText;
    private EditText ignText;
    private User user;

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        database = AppDatabase.getDatabase(getApplicationContext());

//        if (users.size()==0) {
//            database.userDao().addUser(new User("Test 1", "123"));
//            user = database.userDao().getAllUser().get(0);
//            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
//            database.userDao().addUser(new User("Test 2", "213"));
//
//            user = database.userDao().getAllUser().get(1);
//            Toast.makeText(this, String.valueOf(user.id), Toast.LENGTH_SHORT).show();
//
//        }

        emailText=(EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        ignText = (EditText)findViewById(R.id.ignText);
        Button registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {


                        String emailAddress=emailText.getText().toString();
                        String password=passwordText.getText().toString();
                        String ign=ignText.getText().toString();
                        long id=database.userDao().addUser(new User(0,emailAddress, password,ign));
                        Toast.makeText(getApplicationContext(),  String.valueOf(id), Toast.LENGTH_SHORT).show();

                        user = database.userDao().getAllUser().get((int)id-1);
                        Context context = getApplicationContext();
                        CharSequence text = ign+user.email+" successfully registered.";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}

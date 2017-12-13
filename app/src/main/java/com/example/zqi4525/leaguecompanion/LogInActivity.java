package com.example.zqi4525.leaguecompanion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Button;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;

public class LogInActivity extends AppCompatActivity {
    private EditText emailText;
    private EditText passwordText;
    private CheckBox chkRemember;
    private User user;
    private AppDatabase database;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        database = AppDatabase.getDatabase(getApplicationContext());

        emailText=(EditText)findViewById(R.id.emailText);
        passwordText = (EditText)findViewById(R.id.passwordText);
        chkRemember=(CheckBox)findViewById(R.id.chkRem);
        Button logInButton = (Button) findViewById(R.id.logInButton);
        Button regButton = (Button) findViewById(R.id.regButton);

        String lastUser=database.rememberLogInDao().getLastUser();
        Toast.makeText(getApplicationContext(), lastUser, Toast.LENGTH_SHORT).show();
        if(lastUser != null && !lastUser.isEmpty())
        {
            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
            intent.putExtra("ign",lastUser);
            startActivity(intent);
        }

        logInButton.setOnClickListener(
                new OnClickListener() {
                    public void onClick(View v) {
                        if(logIn()){
                            String ign=database.userDao().getIgn(emailText.getText().toString()).toString();
                            if(chkRemember.isChecked()){
                                database.rememberLogInDao().insert(new RememberLogIn(0, ign));
                                String lastUser=database.rememberLogInDao().getLastUser();
                                Toast.makeText(getApplicationContext(), lastUser, Toast.LENGTH_SHORT).show();
                            }
                            CharSequence text = ign+" successfully logged in.";

                            Toast toast = Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT);
                            toast.show();
                            Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
                            intent.putExtra("ign",ign);
                            startActivity(intent);
                        }
                        else{
                            Context context = getApplicationContext();
                            CharSequence text = emailText.getText().toString()+" failed to log in.";
                            int duration = Toast.LENGTH_SHORT;

                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                        }
                    }
                }
        );
        regButton.setOnClickListener(
                new OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }
    public boolean logIn(){
        String emailAddress=emailText.getText().toString();
        String password=passwordText.getText().toString();
        if(password.equals(database.userDao().verifyPassword(emailAddress)))
        {
            return true;
        }


        return false;
    }
}

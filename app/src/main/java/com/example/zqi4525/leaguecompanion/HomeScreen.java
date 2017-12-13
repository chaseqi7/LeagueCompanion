package com.example.zqi4525.leaguecompanion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    private TextView welcomeMsg;

    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        database = AppDatabase.getDatabase(getApplicationContext());
        setContentView(R.layout.activity_home_screen);
        String ign = getIntent().getExtras().getString("ign");
        welcomeMsg= findViewById(R.id.welcomeMsg);
        welcomeMsg.setText("Welcome, " + ign+"!!");
        Button timerButton = (Button) findViewById(R.id.timer);
        Button matchPreviewButton = (Button) findViewById(R.id.matchPreview);
        Button logOutButton = (Button) findViewById(R.id.logOut);
        timerButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), TimerActivity.class);
                        startActivity(intent);
                    }
                }
        );
        matchPreviewButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(getApplicationContext(), "Coming Soon™.", duration);
                        toast.show();
                    }
                }
        );
        logOutButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        database.rememberLogInDao().removeAllUsers();
                        Intent intent = new Intent(getApplicationContext(), LogInActivity.class);
                        startActivity(intent);
                    }
                }
        );
    }
}

package com.example.zqi4525.leaguecompanion;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);
        Button timerButton = (Button) findViewById(R.id.timer);
        Button matchPreviewButton = (Button) findViewById(R.id.matchPreview);
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

                        Toast toast = Toast.makeText(getApplicationContext(), "Coming soonTM.", duration);
                        toast.show();
                    }
                }
        );
    }
}

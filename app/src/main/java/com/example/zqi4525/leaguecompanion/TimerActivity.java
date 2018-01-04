package com.example.zqi4525.leaguecompanion;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {
    private TextView teleTimerText;
    private TextView flashTimerText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        ImageButton flashImageButton = (ImageButton) findViewById(R.id.flashButton);
        ImageButton teleImageButton = (ImageButton) findViewById(R.id.teleButton);
        flashImageButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        flashTimerText= findViewById(R.id.flashText);
                        new CountDownTimer(5000, 100) {

                            public void onTick(long millisUntilFinished) {
                                flashTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
                            }

                            public void onFinish() {
                                flashTimerText.setText("Flash is up!");
                                Toast.makeText(getApplicationContext(), "Flash is up!", Toast.LENGTH_SHORT).show();
                            }
                        }.start();

                    }
                }
        );
        teleImageButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {

                        teleTimerText= findViewById(R.id.teleText);
                        new CountDownTimer(5000, 100) {

                            public void onTick(long millisUntilFinished) {
                                teleTimerText.setText("seconds remaining: " + millisUntilFinished / 1000);
                            }

                            public void onFinish() {
                                teleTimerText.setText("Teleport is up!");
                                Toast.makeText(getApplicationContext(), "Teleport is up!", Toast.LENGTH_SHORT).show();
                            }
                        }.start();
                    }
                }
        );




    }
}

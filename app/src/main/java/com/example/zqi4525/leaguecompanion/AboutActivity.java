package com.example.zqi4525.leaguecompanion;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.InputStream;

public class AboutActivity extends AppCompatActivity {
    ListView listView;

    private AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        database = AppDatabase.getDatabase(getApplicationContext());

        Button contactButton = (Button) findViewById(R.id.call);
        contactButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {

                        String phone = "+1234567890";
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
                        startActivity(intent);
                    }
                }
        );

        Button githubButton = (Button) findViewById(R.id.github);
        githubButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chaseqi7"));
                        startActivity(intent);

                    }
                }
        );
        Button bgServiceButton = (Button) findViewById(R.id.sendNotifications);
        bgServiceButton.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View v) {
                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/chaseqi7"));
                        startActivity(intent);

                    }
                }
        );

        new DownloadImageTask((ImageView) findViewById(R.id.meIcon)).execute("https://avatars0.githubusercontent.com/u/15069824");
        listView = (ListView) findViewById(R.id.list);
        String[] values = new String[] { "Ziming Qi",
                "PROG3210",
                "Programming: Mobile Applications"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        // Assign adapter to ListView
        listView.setAdapter(adapter);

        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }
        });
    }
    public void onClick(View v) {
        startActivity(new Intent(this, AboutActivity.class));
        finish();

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


}

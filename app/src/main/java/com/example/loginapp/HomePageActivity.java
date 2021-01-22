package com.example.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {
    private static final String TAG = "HomePageActivity";
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Log.d(TAG, "onCreate: started");

        image = findViewById(R.id.image);
       // image.setImageResource(R.drawable.elephant);
        image.setImageDrawable(getDrawable(R.drawable.elephant));

    }
}
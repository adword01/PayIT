package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.payit.R;

public class Bus404Activity extends AppCompatActivity {

    private TextView location;
    private String loc;
    private String loc1;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus404);

        VideoView videoView = (VideoView) findViewById(R.id.bus_vid);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.bus_vid);
        videoView.start();

        location = findViewById(R.id.text3);

//        Intent intent = getIntent();
//        String drop = intent.getStringExtra("message_key");
//        String pick = intent.getStringExtra("message_key1");

        loc=getIntent().getExtras().getString("Value");
        loc1=getIntent().getExtras().getString("Value1");
        location.setText("No bus found between "+loc+" and "+loc1);

//        location.setText(loc);

    }
}
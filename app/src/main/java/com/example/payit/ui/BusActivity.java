package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.payit.R;

public class BusActivity extends AppCompatActivity {

    private EditText drop_location;
    private EditText pick_location;
    private Button bus;
    private String loc;
    private String loc1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus);

        VideoView videoView = (VideoView) findViewById(R.id.bus_vid1);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.bus_vid1);
        videoView.start();


        drop_location = findViewById(R.id.drop);
        pick_location = findViewById(R.id.pickup);
        bus = findViewById(R.id.bus_btn);


        String drop = drop_location.getText().toString();
        String pick= pick_location.getText().toString();

        bus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BusActivity.this, Bus404Activity.class);
                loc=drop_location.getText().toString();
                loc1=pick_location.getText().toString();

                intent.putExtra("Value",loc);
                intent.putExtra("Value1",loc1);
                startActivity(intent);
                finish();


//                intent = new Intent(getApplicationContext(), Bus404Activity.class);
//                intent.putExtra("message_key", drop);
//                intent.putExtra("message_key1", pick);




                Toast.makeText(BusActivity.this, "No Bus Found", Toast.LENGTH_SHORT).show();
            }
        });



    }
}
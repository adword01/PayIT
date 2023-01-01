package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.VideoView;

import com.example.payit.R;

public class uicred extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uicred);

        MediaPlayer music = MediaPlayer.create(uicred.this, R.raw.shri_ram_jaanki);
        music.start();

        VideoView videoView = (VideoView) findViewById(R.id.vid2);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.valf);
        videoView.start();
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        LinearLayout layout = (LinearLayout)findViewById(R.id.ui_off);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(uicred.this,Game.class);
                startActivity(intent );
            }
        });



//        VideoView videoView = (VideoView) findViewById(R.id.vid1);
//        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.v3);
//        videoView.start();
    }
}
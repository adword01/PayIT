package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.payit.R;

import java.util.Random;

public class Game extends AppCompatActivity {

    Button btnSpin;
    ImageView ivWheel;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // initializing views
        btnSpin = findViewById(R.id.btnSpin);
        ivWheel = findViewById(R.id.ivWheel);

        // creating an object of Random class
        // to generate random numbers for the spin
        Random random = new Random();

        // on click listener for btnSpin
        btnSpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // disabling the button so that user
                // should not click on the button
                // while the wheel is spinning
                btnSpin.setEnabled(false);

                // reading random value between 10 to 30
                int spin = random.nextInt(12)+10;

                // since the wheel has 12 divisions, the
                // rotation should be a multiple of
                // 360/12 = 30 degrees
                spin = spin * 30;

                // timer for each degree movement
                timer = new CountDownTimer(spin*20,1) {
                    @Override
                    public void onTick(long l) {
                        // rotate the wheel
                        float rotation = ivWheel.getRotation() + 2;
                        ivWheel.setRotation(rotation);
                    }

                    @Override
                    public void onFinish() {
                        // enabling the button again
                        btnSpin.setEnabled(true);
                        Toast.makeText(Game.this, "Better Luck! Next Time", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(Game.this,MainActivity.class);
                        startActivity(intent );
                    }
                }.start();

            }
        });

    }
}

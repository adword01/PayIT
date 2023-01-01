package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.payit.R;

public class ZomatoActivity extends AppCompatActivity {
    int view = R.layout.activity_zomato;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(view);

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.application.zomato");
        if (launchIntent != null) {
                    startActivity(launchIntent);
                } else {
                    Toast.makeText(ZomatoActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
                }

//        final LinearLayout parent = findViewById(R.id.parent);
//        textView = findViewById(R.id.text);
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
//                if (launchIntent != null) {
//                    startActivity(launchIntent);
//                } else {
//                    Toast.makeText(ZomatoActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
    }
}
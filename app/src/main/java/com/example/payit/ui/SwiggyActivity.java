
package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.payit.R;

public class SwiggyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swiggy);
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("in.swiggy.android");
        if (launchIntent != null) {
            startActivity(launchIntent);
        } else {
            Toast.makeText(SwiggyActivity.this, "There is no package available in android", Toast.LENGTH_LONG).show();
        }
    }
}
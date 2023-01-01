package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.payit.R;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class InsuranceActivity extends AppCompatActivity {

    private EditText ins_amt;
    private Button ins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insurance);


        VideoView videoView = (VideoView) findViewById(R.id.ins_vid);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.insurance_vid);
        videoView.start();
        ins_amt = findViewById(R.id.ins_amt);
        ins = findViewById(R.id.ins_btn);

        // adding on click listener to our button.
        ins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = ins_amt.getText().toString();

                // rounding off the amount.
                int amount = Math.round(Float.parseFloat(samount) * 100);

                // initialize Razorpay account.
                Checkout checkout = new Checkout();

                // set your id as below
                checkout.setKeyID("rzp_test_mGigrcg6Z5n9AS");

                // set image
                checkout.setImage(R.drawable.payit_1);

                // initialize json object
                JSONObject object = new JSONObject();
                try {
                    // to put name
                    object.put("name", "PayIT");

                    // put description
                    object.put("description", "Insurance Reciepts");

                    // to set theme color
                    object.put("theme.color", "black");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "8743032954");

                    // put email
                    object.put("prefill.email", "adityak@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(InsuranceActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
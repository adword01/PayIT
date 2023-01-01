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

public class CreditActivity extends AppCompatActivity {

    private EditText credit_amt;
    private Button credit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);


        VideoView videoView = (VideoView) findViewById(R.id.credit_vid);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.creditcard_vid);
        videoView.start();
        credit_amt = findViewById(R.id.credit_amt);
        credit = findViewById(R.id.credit_btn);

        // adding on click listener to our button.
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = credit_amt.getText().toString();
                Toast.makeText(CreditActivity.this, "Use Credit Card to Make this Payment.", Toast.LENGTH_LONG).show();

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
                    object.put("description", "Credit Card Bills");

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
                    checkout.open(CreditActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
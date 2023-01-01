package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class ContactActivity extends AppCompatActivity {

    Button contact_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);


        VideoView videoView = (VideoView) findViewById(R.id.contact_vid);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.contact_v);
        videoView.start();



        EditText mobileNumberEditText = findViewById(R.id.contact_no);
        String mobileNumber = mobileNumberEditText.getText().toString();
        contact_btn = findViewById(R.id.contact_btn);
        contact_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText amountEditText = findViewById(R.id.contact_amt);
                String amount = amountEditText.getText().toString();
                int samount = Math.round(Float.parseFloat(amount) * 100);

                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_mGigrcg6Z5n9AS");
                checkout.setImage(R.drawable.payit_1);
                JSONObject object = new JSONObject();
                try {
                    object.put("name", "PayIT");
                    object.put("description", "Contact Payment");
                    object.put("theme.color", "black");
                    object.put("currency", "INR");
                    object.put("amount", samount);
                    object.put("contact", mobileNumber);
                    object.put("prefill.email", "adityak@gmail.com");
                    checkout.open(ContactActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }




//    public void onPaymentSuccess(String s) {
//        // this method is called on payment success.
//        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
//    }
//
//
//    public void onPaymentError(int i, String s) {
//        // on payment failed.
//        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
//
//
//    }
}
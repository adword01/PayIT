package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.payit.R;
import com.google.android.material.textfield.TextInputEditText;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class UpiActivity extends AppCompatActivity {



    private EditText amountEdt;
    private Button payBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upi);

        amountEdt = findViewById(R.id.idEdtAmount);
        payBtn = findViewById(R.id.idBtnPay);

        VideoView videoView = (VideoView) findViewById(R.id.vid_upi);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.online_pay);
        videoView.start();
        //Payment gateway integration
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String samount = amountEdt.getText().toString();
                int amount = Math.round(Float.parseFloat(samount) * 100);
                Checkout checkout = new Checkout();
                checkout.setKeyID("rzp_test_mGigrcg6Z5n9AS");
                checkout.setImage(R.drawable.payit_logo);
                JSONObject object = new JSONObject();
                try {
                    object.put("name", "PayIT");
                    object.put("description", "Master Payment");
                    object.put("theme.color", "black");
                    object.put("currency", "INR");
                    object.put("amount", amount);
                    object.put("prefill.contact", "8743032954");
                    object.put("prefill.email", "21304@iiitu.ac.in");
                    checkout.open(UpiActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void onPaymentSuccess(String s) {
        // this method is called on payment success.
        Toast.makeText(this, "Payment is successful : " + s, Toast.LENGTH_SHORT).show();
    }


    public void onPaymentError(int i, String s) {
        // on payment failed.
        Toast.makeText(this, "Payment Failed due to error : " + s, Toast.LENGTH_SHORT).show();
    }
}






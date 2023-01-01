package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.payit.R;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RechargeActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner operator_spinner, plan_spinner,circle_spinner;
    private TextView mobile_amt;
    private EditText mobileNo;
    private Button payBtn;

    String[] operator_spin = { "Airtel", "JIO", "VI","BSNL","MTNL" };
    String[] circle_spin = {"Select Circle","Delhi-NCR","Mumbai-MMR","Bangalore","Hyderabad","Kolkata","Himachal Pradesh"};

    ArrayList Airtel = new ArrayList();
    ArrayList JIO = new ArrayList();
    ArrayList VI = new ArrayList();
    ArrayList BSNL = new ArrayList();
    ArrayList MTNL = new ArrayList();

    ArrayAdapter adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharge);

        operator_spinner = findViewById(R.id.operator_spinner);
        plan_spinner = findViewById(R.id.plan_spinner);
        circle_spinner=findViewById(R.id.circle_spinner);

        mobile_amt = findViewById(R.id.amount_mobile);
        mobileNo = findViewById(R.id.mobile_n);
//        EditText text =findViewById(R.id.mobile_n);
        payBtn = findViewById(R.id.mobile_btn);

        loadArrayList();

        operator_spinner.setOnItemSelectedListener(this);
        plan_spinner.setOnItemSelectedListener(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, operator_spin);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        operator_spinner.setAdapter(adapter);

        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_list_item_1, circle_spin);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        circle_spinner.setAdapter(adapter1);

        mobile_amt = findViewById(R.id.amount_mobile);
        payBtn = findViewById(R.id.mobile_btn);

        // adding on click listener to our button.
        payBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // on below line we are getting
                // amount that is entered by user.
                String samount = mobile_amt.getText().toString();

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
                    object.put("description", "Mobile Recharge");

                    // to set theme color
                    object.put("theme.color", "#000000");

                    // put the currency
                    object.put("currency", "INR");

                    // put amount
                    object.put("amount", amount);

                    // put mobile number
                    object.put("prefill.contact", "8743032954");

                    // put email
                    object.put("prefill.email", "adityak@gmail.com");

                    // open razorpay to checkout activity
                    checkout.open(RechargeActivity.this, object);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId() == R.id.operator_spinner)
        {


            if(position == 0) {
                adapter2 = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, Airtel);
            } else if(position == 1) {
                adapter2 = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, JIO);
            } else if(position == 2) {
                adapter2 = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, VI);
            }
            else if(position == 3) {
                adapter2 = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, BSNL);
            }
            else if(position == 4) {
                adapter2 = new ArrayAdapter(this,
                        android.R.layout.simple_list_item_1, MTNL);
            }


            adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            plan_spinner.setAdapter(adapter2);

        }
        else if(parent.getId() == R.id.plan_spinner)
        {
            TextView textView2 = findViewById(R.id.textView2);
            textView2.setText(""+plan_spinner.getSelectedItem().toString());

            Toast.makeText(this, ""+plan_spinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    private void loadArrayList() {

        Airtel.add("Select Airtel Plan");
        Airtel.add("Airtel - "+"₹ 3359 - 2.5GB/Day"+" 365 Days Validity");
        Airtel.add("Airtel - "+"₹ 2999 - 2GB/Day"+" 365 Days Validity");
        Airtel.add("Airtel - "+"₹ 1799 - 24GB"+" 365 Days Validity");
        Airtel.add("Airtel - "+"₹ 999 - 2.5GB/Day"+" 84 Days Validity");
        Airtel.add("Airtel - "+"₹ 839 - 2GB/Day"+" 84 Days Validity");
        Airtel.add("Airtel - "+"₹ 779 - 1.5GB/Day"+" 90 Days Validity");
        Airtel.add("Airtel - "+"₹ 719 - 2.5GB/Day"+" 84 Days Validity");
        Airtel.add("Airtel - "+"₹ 699 - 3GB/Day"+" 56 Days Validity");
        Airtel.add("Airtel - "+"₹ 666 - 1.5GB/Day"+" 77 Days Validity");
        Airtel.add("Airtel - "+"₹ 599 - 3GB/Day"+" 28 Days Validity");
        Airtel.add("Airtel - "+"₹ 549 - 2GB/Day"+" 56 Days Validity");
        Airtel.add("Airtel - "+"₹ 519 - 1.5GB/Day"+" 60 Days Validity");

        JIO.add("Select JIO Plan");
        JIO.add("JIO - "+"₹ 2999 - 2.5GB/Day"+" 365 Days Validity");
        JIO.add("JIO - "+"₹ 749 - 2GB/Day"+" 90 Days Validity");
        JIO.add("JIO - "+"₹ 719 - 2GB/Day"+" 84 Days Validity");
        JIO.add("JIO - "+"₹ 2545 - 1.5GB/Day"+" 336 Days Validity");
        JIO.add("JIO - "+"₹ 666 - 1.5GB/Day"+" 84 Days Validity");
        JIO.add("JIO - "+"₹ 479 - 1.5GB/Day"+" 56 Days Validity");
        JIO.add("JIO - "+"₹ 2879 - 2GB/Day"+" 365 Days Validity");
        JIO.add("JIO - "+"₹ 719 - 2GB/Day"+" 84 Days Validity");
        JIO.add("JIO - "+"₹ 533 - 2GB/Day"+" 56 Days Validity");
        JIO.add("JIO - "+"₹ 209 - 1GB/Day"+" 28 Days Validity");
        JIO.add("JIO - "+"₹ 179 - 1GB/Day"+" 24 Days Validity");
        JIO.add("JIO - "+"₹ 149 - 1GB/Day"+" 20 Days Validity");
        JIO.add("JIO - "+"₹ 1199 - 3GB/Day"+" 84 Days Validity");
        JIO.add("JIO - "+"₹ 419 - 3GB/Day"+" 28 Days Validity");
        JIO.add("JIO - "+"₹ 296 - 25GB"+" 30 Days Validity");



        VI.add("Select VI Plan");
        VI.add("VI - "+"₹ 3099 - 2GB/Day"+" 365 Days Validity");
        VI.add("VI - "+"₹ 299 - 1.5GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 479 - 1.5GB/Day"+" 56 Days Validity");
        VI.add("VI - "+"₹ 359 - 3GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 719 - 1.5GB/Day"+" 84 Days Validity");
        VI.add("VI - "+"₹ 399 - 2.5GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 499 - 2GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 901 - 3GB/Day"+" 70 Days Validity");
        VI.add("VI - "+"₹ 601 - 3GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 475 - 4GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 319 - 2GB/Day"+" 30 Days Validity");
        VI.add("VI - "+"₹ 699 - 3GB/Day"+" 56 Days Validity");
        VI.add("VI - "+"₹ 666 - 1.5GB/Day"+" 77 Days Validity");
        VI.add("VI - "+"₹ 539 - 2GB/Day"+" 84 Days Validity");
        VI.add("VI - "+"₹ 2899 - 1.5GB/Day"+" 365 Days Validity");
        VI.add("VI - "+"₹ 409 - 3.5GB/Day"+" 28 Days Validity");
        VI.add("VI - "+"₹ 1066 - 2GB/Day"+" 84 Days Validity");



        BSNL.add("Select BSNL Plan");
        BSNL.add("Currently unavailable");

        MTNL.add("Select MTNL Plan");
        MTNL.add("Currently unavailable");
    }
}
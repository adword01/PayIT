package com.example.payit.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.payit.R;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class BillsActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    EditText Credit;
    EditText Broadband;
    EditText Water;
    EditText Electricity;
    EditText Gas;
    EditText Others;
    EditText BillAmount;
    Button bills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);

        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);
        Credit=findViewById(R.id.Credit);
        Broadband=findViewById(R.id.Broadband);
        Water=findViewById(R.id.water);
        Electricity=findViewById(R.id.electricity);
        Gas=findViewById(R.id.gas);
        Others=findViewById(R.id.others);
        BillAmount=findViewById(R.id.bill_amount);
        bills=findViewById(R.id.paybills);
//        CreditNumber.findViewById(R.id.credit_txt);

//        Credit.setVisibility(View.INVISIBLE);
//        CreditNumber.setVisibility(View.INVISIBLE);

        //We will use this data to inflate the drop-down items
        String[] Subjects = new String[]{"Credit Cards", "Broadband", "Water","Electricity","Gas","Others"};

        // create an array adapter and pass the required parameter
        // in our case pass the context, drop down layout , and array.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.bill_drop_down, Subjects);
        autoCompleteTextView.setAdapter(adapter);



        //to get selected value add item click listener
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Credit.setVisibility(View.VISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    Water.setVisibility(View.INVISIBLE);
                    Electricity.setVisibility(View.INVISIBLE);
                    Gas.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);
//
                Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();
            }else if (position==1){
                    Credit.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.VISIBLE);
                    Water.setVisibility(View.INVISIBLE);
                    Electricity.setVisibility(View.INVISIBLE);
                    Gas.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);



                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }
                else if (position==2){
                    Credit.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    Water.setVisibility(View.VISIBLE);
                    Electricity.setVisibility(View.INVISIBLE);
                    Gas.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);


                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }
                else if (position==3){
                    Credit.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    Water.setVisibility(View.INVISIBLE);
                    Electricity.setVisibility(View.VISIBLE);
                    Gas.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);


                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }
                else if (position==4){
                    Credit.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    Water.setVisibility(View.INVISIBLE);
                    Electricity.setVisibility(View.INVISIBLE);
                    Gas.setVisibility(View.VISIBLE);
                    Others.setVisibility(View.INVISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);


                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }
                else if (position==5){
                    Credit.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    Water.setVisibility(View.INVISIBLE);
                    Electricity.setVisibility(View.INVISIBLE);
                    Gas.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.VISIBLE);

                    BillAmount.setVisibility(View.VISIBLE);
                    bills.setVisibility(View.VISIBLE);


                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView.getText().toString(), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Not Selected",Toast.LENGTH_SHORT).show();
                }
                bills.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String samount = BillAmount.getText().toString();
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
                            object.put("prefill.email", "adityak@gmail.com");
                            checkout.open(BillsActivity.this, object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
}
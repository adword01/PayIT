package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.payit.R;
import com.razorpay.Checkout;

import org.json.JSONException;
import org.json.JSONObject;

public class Recharges extends AppCompatActivity {


    AutoCompleteTextView autoCompleteTextView1;
    EditText Mobile;
    EditText Broadband;
    EditText D2h;
    EditText FasTag;
    EditText Others;
    EditText BillAmount;
    Button Bill_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recharges);
        autoCompleteTextView1 = findViewById(R.id.autoCompleteTextView1);
        Mobile=findViewById(R.id.phone);
        Broadband=findViewById(R.id.modem);
        D2h=findViewById(R.id.D2h);
        FasTag=findViewById(R.id.fastag);
        Others=findViewById(R.id.others);
        BillAmount=findViewById(R.id.bill_amount);
        Bill_btn=findViewById(R.id.bill_btn);
//         MobileNumber.findViewById(R.id. Mobile_txt);
//         Mobile.setVisibility(View.INVISIBLE);
//         MobileNumber.setVisibility(View.INVISIBLE);
        String[] Subjects = new String[]{"Mobile", "Broadband", "D2h","FasTag","Others"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.bill_drop_down, Subjects);
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Mobile.setVisibility(View.VISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    D2h.setVisibility(View.INVISIBLE);
                    FasTag.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
                }else if (position==1){
                    Mobile.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.VISIBLE);
                    D2h.setVisibility(View.INVISIBLE);
                    FasTag.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else if (position==2){
                    Mobile.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                    D2h.setVisibility(View.VISIBLE);
                    FasTag.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else if (position==3){
                     Mobile.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                     D2h.setVisibility(View.INVISIBLE);
                     FasTag.setVisibility(View.VISIBLE);
                    Others.setVisibility(View.INVISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else if (position==4){
                     Mobile.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                     D2h.setVisibility(View.INVISIBLE);
                     FasTag.setVisibility(View.INVISIBLE);
                    Others.setVisibility(View.INVISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();
                }
                else if (position==5){
                     Mobile.setVisibility(View.INVISIBLE);
                    Broadband.setVisibility(View.INVISIBLE);
                     D2h.setVisibility(View.INVISIBLE);
                     FasTag.setVisibility(View.INVISIBLE);
                    Bill_btn.setVisibility(View.VISIBLE);
                    Others.setVisibility(View.VISIBLE);
                    BillAmount.setVisibility(View.VISIBLE);
                    Toast.makeText(getApplicationContext(), "" + autoCompleteTextView1.getText().toString(), Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(getApplicationContext(),"Not Selected",Toast.LENGTH_SHORT).show();
                }
                Bill_btn.setOnClickListener(new View.OnClickListener() {
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
                            checkout.open(Recharges.this, object);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                });
                    }


        });
    }
}
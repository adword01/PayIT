package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.payit.R;
import com.hbb20.CountryCodePicker;

public class manageOTP extends AppCompatActivity
{
    CountryCodePicker ccp;
    EditText t1;
    Button b1;
    String num;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_otp);

        FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        t1=(EditText)findViewById(R.id.t1);
        ccp=(CountryCodePicker)findViewById(R.id.ccp);
        ccp.registerCarrierNumberEditText(t1);
        b1=(Button)findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(manageOTP.this,VerifyPhoneActivity.class);
                num=t1.getText().toString();

//                Bundle b=new Bundle();
//                b.putString("Number",t1.getText().toString());
//                AccountFragment.setArgument(b);
//                fragmentTransaction.add(R.id.frameLayout, AccountFragment.newInstance()).commit();



                intent.putExtra("Number",num);
                intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
                startActivity(intent);
            }
        });
    }
}
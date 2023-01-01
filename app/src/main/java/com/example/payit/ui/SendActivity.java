package com.example.payit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.payit.R;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wallet.callback.OnCompleteListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;


public class SendActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        final EditText inputMobile=findViewById(R.id.inputMobile);
        Button buttonGetOtp=findViewById(R.id.get_otp);

        buttonGetOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(SendActivity.this,"Enter Mobile Number",Toast.LENGTH_SHORT).show();
                    return;
                }
                buttonGetOtp.setVisibility(View.INVISIBLE);

                Intent intent = new Intent(SendActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phone", "+91"+inputMobile.getText().toString().trim());
                startActivity(intent);

//                PhoneAuthProvider.getInstance().verifyPhoneNumber(
//                        "+91"+inputMobile.getText().toString(),
//                        60,
//                        TimeUnit.SECONDS,
//                        SendActivity.this,
//                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//                            @Override
//                            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
//                                buttonGetOtp.setVisibility(View.VISIBLE);
//                            }
//
//                            @Override
//                            public void onVerificationFailed(@NonNull FirebaseException e) {
//                                buttonGetOtp.setVisibility(View.VISIBLE);
//                                Toast.makeText(SendActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
//                            }
//                            @Override
//                            public void onCodeSent(@NonNull String VerificationId,@NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken){
//                                buttonGetOtp.setVisibility(View.VISIBLE);
//                                Intent intent=new Intent(getApplicationContext(),VerifyPhoneActivity.class);
//                                intent.putExtra("Mobile",inputMobile.getText().toString());
//                                intent.putExtra("VerificationId",VerificationId);
//                                startActivity(intent);
//                        }}
//                );

            }
        });

    }


}

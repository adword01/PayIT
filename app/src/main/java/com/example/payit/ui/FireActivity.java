package com.example.payit.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.payit.R;

public class FireActivity extends AppCompatActivity {


    private EditText editTextMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire);

        editTextMobile = findViewById(R.id.editTextMobile);

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mobile = editTextMobile.getText().toString().trim();

                if(mobile.isEmpty() || mobile.length() < 10){
                    editTextMobile.setError("Enter a valid mobile");
                    editTextMobile.requestFocus();
                    return;
                }

                Intent intent = new Intent(FireActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });
    }

}






































//package com.example.payit.ui;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.example.payit.R;
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.android.gms.tasks.TaskExecutors;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.AuthResult;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//
//import java.util.concurrent.TimeUnit;
//
//public class FireActivity extends AppCompatActivity {
//
//    // variable for FirebaseAuth class
//    private FirebaseAuth mAuth;
//
//    // variable for our text input
//    // field for phone and OTP.
//    private EditText edtPhone, edtOTP;
//
//    // buttons for generating OTP and verifying OTP
//    private Button verifyOTPBtn, generateOTPBtn;
//
//    // string for storing our verification ID
//    private String verificationId;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_fire);
//
//        // below line is for getting instance
//        // of our FirebaseAuth.
//        mAuth = FirebaseAuth.getInstance();
//
//        // initializing variables for button and Edittext.
//        edtPhone = findViewById(R.id.idEdtPhoneNumber);
//        edtOTP = findViewById(R.id.idEdtOtp);
//        verifyOTPBtn = findViewById(R.id.idBtnVerify);
//        generateOTPBtn = findViewById(R.id.idBtnGetOtp);
//
//        // setting onclick listener for generate OTP button.
//        generateOTPBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // below line is for checking whether the user
//                // has entered his mobile number or not.
//                if (TextUtils.isEmpty(edtPhone.getText().toString())) {
//                    // when mobile number text field is empty
//                    // displaying a toast message.
//                    Toast.makeText(FireActivity.this, "Please enter a valid phone number.", Toast.LENGTH_SHORT).show();
//                } else {
//                    // if the text field is not empty we are calling our
//                    // send OTP method for getting OTP from Firebase.
//                    String phone = "+91" + edtPhone.getText().toString();
//                    sendVerificationCode(phone);
//                }
//            }
//        });
//
//        // initializing on click listener
//        // for verify otp button
//        verifyOTPBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // validating if the OTP text field is empty or not.
//                if (TextUtils.isEmpty(edtOTP.getText().toString())) {
//                    // if the OTP text field is empty display
//                    // a message to user to enter OTP
//                    Toast.makeText(FireActivity.this, "Please enter OTP", Toast.LENGTH_SHORT).show();
//                } else {
//                    // if OTP field is not empty calling
//                    // method to verify the OTP.
//                    verifyCode(edtOTP.getText().toString());
//                }
//            }
//        });
//    }
//
//    private void signInWithCredential(PhoneAuthCredential credential) {
//        // inside this method we are checking if
//        // the code entered is correct or not.
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // if the code is correct and the task is successful
//                            // we are sending our user to new activity.
//                            Intent i = new Intent(FireActivity.this, MainActivity.class);
//                            startActivity(i);
//                            finish();
//                        } else {
//                            // if the code is not correct then we are
//                            // displaying an error message to the user.
//                            Toast.makeText(FireActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
//                        }
//                    }
//                });
//    }
//
//
//    private void sendVerificationCode(String number) {
//        // this method is used for getting
//        // OTP on user phone number.
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber(number)		 // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)				 // Activity (for callback binding)
//                        .setCallbacks(mCallBack)		 // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//
//    // callback method is called on Phone auth provider.
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
//
//            // initializing our callbacks for on
//            // verification callback method.
//            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//        // below method is used when
//        // OTP is sent from Firebase
//        @Override
//        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
//            super.onCodeSent(s, forceResendingToken);
//            // when we receive the OTP it
//            // contains a unique id which
//            // we are storing in our string
//            // which we have already created.
//            verificationId = s;
//        }
//
//        // this method is called when user
//        // receive OTP from Firebase.
//        @Override
//        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
//            // below line is used for getting OTP code
//            // which is sent in phone auth credentials.
//            final String code = phoneAuthCredential.getSmsCode();
//
//            // checking if the code
//            // is null or not.
//            if (code != null) {
//                // if the code is not null then
//                // we are setting that code to
//                // our OTP edittext field.
//                edtOTP.setText(code);
//
//                // after setting this code
//                // to OTP edittext field we
//                // are calling our verifycode method.
//                verifyCode(code);
//            }
//        }
//
//        // this method is called when firebase doesn't
//        // sends our OTP code due to any error or issue.
//        @Override
//        public void onVerificationFailed(FirebaseException e) {
//            // displaying error message with firebase exception.
//            Toast.makeText(FireActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
//        }
//    };
//
//    // below method is use to verify code from Firebase.
//    private void verifyCode(String code) {
//        // below line is used for getting
//        // credentials from our verification id and code.
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//
//        // after getting credential we are
//        // calling sign in method.
//        signInWithCredential(credential);
//    }
//}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
////import android.content.Intent;
////import android.os.Bundle;
////import android.widget.Button;
////import android.widget.EditText;
////
////import androidx.appcompat.app.AppCompatActivity;
////
////import com.example.payit.R;
////import com.hbb20.CountryCodePicker;
////
////public class FireActivity extends AppCompatActivity {
////
////    CountryCodePicker ccp;
////    EditText t1;
////    Button b1;
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState){
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_fire);
////
////
////        t1=findViewById(R.id.t1);
////        ccp= findViewById(R.id.ccp);
////        ccp.registerCarrierNumberEditText(t1);
////        b1= findViewById(R.id.b1);
////
////        b1.setOnClickListener(view -> {
////            Intent intent=new Intent(FireActivity.this,MainActivity.class);
////            intent.putExtra("mobile",ccp.getFullNumberWithPlus().replace(" ",""));
////            startActivity(intent);
////        });
////
////    }
////}
////
//////    private static final String TAG = "PhoneAuthActivity";
//////
//////    //Adding a member variable for the key verification in progress
//////    private static final String KEY_VERIFY_IN_PROGRESS = "key_verify_in_progress";
//////
//////    //Creating FirebaseAuth member variable
//////    private FirebaseAuth mAuth;
//////
//////    //Adding a bunch of member variables for view groups, edit text, and buttons.
//////    private ViewGroup mPhoneNumberViews;
//////    private ViewGroup mSignedInViews;
//////
//////    private EditText mPhoneNumberField;
//////    private EditText mVerificationField;
//////
//////    private Button mStartButton;
//////    private Button mVerifyButton;
//////    private Button mResendButton;
//////    private Button mSignOutButton;
//////
//////    //Setting Boolean to say whether or not we are in progress.
//////    private boolean mVerificationInProgress = false;
//////
//////    //Adding verification id as a member variable.
//////    private String mVerificationId;
//////
//////    //Adding a member variable for PhoneAuthProvider.ForceResendingToken callback.
//////    private PhoneAuthProvider.ForceResendingToken mResendToken;
//////
//////    //Adding a member variable for a callback which is our PhoneAuthProvider.OnVerificationStateChangeCallbacks.
//////    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
//////
//////    @Override
//////    protected void onCreate(Bundle savedInstanceState) {
//////        super.onCreate(savedInstanceState);
//////
//////        setContentView(R.layout.activity_fire);
//////
//////        // Restoring the instance state
//////        if (savedInstanceState != null) {
//////            onRestoreInstanceState(savedInstanceState);
//////        }
//////
//////        // Assigning all the views
//////
//////
//////        mPhoneNumberField = findViewById(R.id.EdtPhoneNumber);
//////        mVerificationField = findViewById(R.id.EdtOtp);
//////
//////        mStartButton = findViewById(R.id.BtnGetOtp);
//////        mVerifyButton = findViewById(R.id.BtnVerify);
//////        mResendButton = findViewById(R.id.buttonResend);
//////
//////        // Setting all the click listeners
//////        mStartButton.setOnClickListener(this);
//////        mVerifyButton.setOnClickListener(this);
//////        mResendButton.setOnClickListener(this);
//////
//////
//////        // Initialize Firebase Auth
//////        mAuth = FirebaseAuth.getInstance();
//////
//////        // Initializing phone auth callbacks  (For verification, Not entering code yet, To get text send to device)
//////        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//////
//////            @Override
//////            public void onVerificationCompleted(PhoneAuthCredential credential) {
//////                // It will be invoked in two situations, i.e., instant verification and auto-retrieval:
//////                // 1 - In few of the cases, the phone number can be instantly verified without needing to  enter or send a verification code.
//////                // 2 - On some devices, Google Play services can automatically detect the incoming verification SMS and perform verification without
//////                //     user action.
//////                Log.d(TAG, "onVerificationCompleted:" + credential);
//////                mVerificationInProgress = false;
//////
//////                //Calling signInWithPhoneAuthCredential.
//////                signInWithPhoneAuthCredential(credential);
//////
//////            }
//////
//////            //Creating onVerificationFailed() method.
//////            @Override
//////            public void onVerificationFailed(FirebaseException e) {
//////                // It is invoked when an invalid request is made for verification.                 //For instance, if the phone number format is not valid.
//////                Log.w(TAG, "onVerificationFailed", e);
//////                mVerificationInProgress = false;
//////
//////                if (e instanceof FirebaseAuthInvalidCredentialsException) {
//////                    // Invalid request
//////                    // Setting error to text field
//////                    mPhoneNumberField.setError("Invalid phone number.");
//////                } else if (e instanceof FirebaseTooManyRequestsException) {
//////                    // The SMS quota has been exceeded for the project                     Toast.makeText(getApplicationContext(), "Quota exceeded", Toast.LENGTH_SHORT).show();
//////                }
//////            }
//////            // Creating onCodeSent() method called after the verification code has been sent by SMS to the provided phone number.
//////            @Override
//////            public void onCodeSent(String verificationId,
//////                                   PhoneAuthProvider.ForceResendingToken token) {
//////                // The SMS verification code will be sent to the provided phone number
//////                // Now need to ask the user for entering the code and then construct a credential
//////                // through integrating the code with a verification ID.
//////                Log.d(TAG, "onCodeSent:" + verificationId);
//////
//////                // Save the verification ID and resend token to use them later
//////                mVerificationId = verificationId;
//////                mResendToken = token;
//////            }
//////        };
//////    }
//////    // Creating onStart method.
//////    @Override
//////    public void onStart() {
//////        super.onStart();
//////
//////        // Checking if the user is signed in or not. If signed in, then update UI accordingly.
//////        FirebaseUser currentUser = mAuth.getCurrentUser();
//////
//////        if (currentUser != null) {
//////            Log.d(TAG, "Currently Signed in: " + currentUser.getEmail());
//////            Toast.makeText(FireActivity.this, "Currently Logged in: " + currentUser.getEmail(), Toast.LENGTH_LONG).show();
//////            mPhoneNumberViews.setVisibility(View.GONE);
//////            mSignedInViews.setVisibility(View.VISIBLE);
//////        }
//////        else {
//////            mPhoneNumberViews.setVisibility(View.VISIBLE);
//////            mSignedInViews.setVisibility(View.GONE);
//////        }
//////
//////        //check if a verification is in progress. If it is then we have to re verify.
//////        if (mVerificationInProgress && validatePhoneNumber()) {
//////            startPhoneNumberVerification(mPhoneNumberField.getText().toString());
//////        }
//////    }
//////    //Implementing SaveInstanceState to save the flag.
//////    @Override
//////    protected void onSaveInstanceState(Bundle outState) {
//////        super.onSaveInstanceState(outState);
//////        outState.putBoolean(KEY_VERIFY_IN_PROGRESS, mVerificationInProgress);
//////    }
//////
//////    //Implementing RestoreInstanceState to restore the flag.
//////    @Override
//////    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//////        super.onRestoreInstanceState(savedInstanceState);
//////        mVerificationInProgress = savedInstanceState.getBoolean(KEY_VERIFY_IN_PROGRESS);
//////    }
//////
//////    // Creating startPhoneNumberVerification() method
//////    //Getting text code sent. So we can use it to sign-in.
//////    private void startPhoneNumberVerification(String phoneNumber) {
//////        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//////                phoneNumber,        // Phone number to verify
//////                60,                 // Timeout duration
//////                TimeUnit.SECONDS,   // Unit of timeout
//////                this,               // Activity (for callback binding)
//////                mCallbacks);        // OnVerificationStateChangedCallbacks
//////
//////        //Setting flag to say that the verification is in process.
//////        mVerificationInProgress = true;
//////    }
//////
//////    //Creating a helper method for verification of phone number with code.
//////    // Entering code and manually signing in with that code
//////    private void verifyPhoneNumberWithCode(String verificationId, String code) {
//////        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
//////        signInWithPhoneAuthCredential(credential);
//////    }
//////
//////    // Creating helper method signInWithPhoneAuthCredential().
//////    //Use text to sign-in.
//////    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//////
//////        //Adding onCompleteListener to signInWithCredential.
//////        mAuth.signInWithCredential(credential)
//////                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//////                    @Override
//////                    public void onComplete(@NonNull Task<AuthResult> task) {
//////                        if (task.isSuccessful()) {
//////                            //Sign-In is successful, update the UI with the signed-in user's information
//////                            Log.d(TAG, "signInWithCredential:success");
//////                            FirebaseUser user = task.getResult().getUser();
//////                            mPhoneNumberViews.setVisibility(View.GONE);
//////                            mSignedInViews.setVisibility(View.VISIBLE);
//////                        } else {
//////                            // If the Sign-In fails, it will display a message and also update the UI
//////                            Log.w(TAG, "signInWithCredential:failure", task.getException());
//////                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//////                                // The verification code entered was invalid
//////                                mVerificationField.setError("Invalid code.");
//////                            }
//////                        }
//////                    }
//////                });
//////    }
//////    // Creating helper method for validating phone number.
//////    private boolean validatePhoneNumber() {
//////        String phoneNumber = mPhoneNumberField.getText().toString();
//////        if (TextUtils.isEmpty(phoneNumber)) {
//////            mPhoneNumberField.setError("Invalid phone number.");
//////            return false;
//////        }
//////
//////        return true;
//////    }
//////
//////    //Creating helper method for resending verification code.
//////    private void resendVerificationCode(String phoneNumber,
//////                                        PhoneAuthProvider.ForceResendingToken token) {
//////        PhoneAuthProvider.getInstance().verifyPhoneNumber(
//////                phoneNumber,        // Phone number to verify
//////                60,                 // Timeout duration
//////                TimeUnit.SECONDS,   // Unit of timeout
//////                this,               // Activity (for callback binding)
//////                mCallbacks,         // OnVerificationStateChangedCallbacks
//////                token);             // ForceResendingToken from callbacks
//////    }
//////    //Adding onClick method which handles the button clicks.
//////    @Override
//////    public void onClick(View view) {
//////        switch (view.getId()) {
//////            case R.id.BtnGetOtp:
//////                if (!validatePhoneNumber()) {
//////                    Intent intent = new Intent(FireActivity.this, MainActivity.class);
//////                    startActivity(intent);
//////                }
//////                //Calling startPhoneNumberVerification helper method for verifying phone number.
//////                startPhoneNumberVerification(mPhoneNumberField.getText().toString());
//////                break;
//////            case R.id.BtnVerify:
//////                String code = mVerificationField.getText().toString();
//////                if (TextUtils.isEmpty(code)) {
//////                    mVerificationField.setError("Cannot be empty.");
//////                    Intent intent = new Intent(FireActivity.this, MainActivity.class);
//////                    startActivity(intent);
//////                }
//////                //Call the verifyPhoneNumberWithCode () method.
//////                verifyPhoneNumberWithCode(mVerificationId, code);
//////                break;
//////            case R.id.buttonResend:
//////                //Call the resendVerificationCode () method.
//////                resendVerificationCode(mPhoneNumberField.getText().toString(), mResendToken);
//////                break;
//////
//////        }
//////    }
//////    private void signOut() {
//////        mAuth.signOut();
//////        mPhoneNumberViews.setVisibility(View.VISIBLE);
//////        mSignedInViews.setVisibility(View.GONE);
//////    }

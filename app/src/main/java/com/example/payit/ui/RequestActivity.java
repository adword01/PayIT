package com.example.payit.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.payit.R;

public class RequestActivity extends AppCompatActivity {

    EditText PhoneNum,msg;
    Button SendBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        PhoneNum=findViewById(R.id.phoneNum);
        msg=findViewById(R.id.textmsg);
        SendBtn=findViewById(R.id.sendBtn);

        VideoView videoView = (VideoView) findViewById(R.id.req_vid);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.money_tra);
        videoView.start();


        SendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ContextCompat.checkSelfPermission(RequestActivity.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                    sendSms();
                }else{
                    ActivityCompat.requestPermissions(RequestActivity.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });

    }


    private void sendSms() {
        String phone=PhoneNum.getText().toString();
        String Message=msg.getText().toString();

        if(!phone.isEmpty()&&!Message.isEmpty()){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,Message +" With ❤ From PayIT. \n You can pay your friend using https://rzp.io/l/857ZEnVQy0 this link.",null,null);
            Toast.makeText(this, "Payment Remainder SMS sent successfully", Toast.LENGTH_SHORT).show();
        }else
        {
            Toast.makeText(this, "Please enter phone number and message.", Toast.LENGTH_SHORT).show();
        }
    }
}
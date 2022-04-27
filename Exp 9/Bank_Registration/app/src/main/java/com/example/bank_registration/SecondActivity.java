package com.example.bank_registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    String otp;
    final private int REQUEST_SEND_SMS = 123;
    Intent intent;
    Button submit;
    EditText OTP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        OTP = (EditText)findViewById(R.id.OTP);
        submit = findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkOTP();
            }
        });
        Random rnd = new Random();
        int temp = rnd.nextInt(1001);
        otp = String.format("%04d", temp);
        intent = getIntent();

        if(ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, REQUEST_SEND_SMS);
        }
        else{
            sendSMS();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == REQUEST_SEND_SMS){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                sendSMS();
                Toast.makeText(getApplicationContext(), "Permisssion granted", Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(), "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    void sendSMS(){
        String phoneNumber = intent.getStringExtra("phoneNumber");
        String message = "The otp for bank registration is "+otp;
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, null, null);
    }

    void checkOTP(){
        String otpTemp = OTP.getText().toString();
        SharedPreferences prefs = getSharedPreferences("userDetails", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        if(otp.equals(otpTemp)){
            editor.putBoolean("MATCHED",true);
            Intent i=new Intent(this,FinalActivity.class);
            startActivity(i);

        }
        else{
            editor.putBoolean("MATCHED", false);
        }
        editor.commit();
        finish();

    }
}
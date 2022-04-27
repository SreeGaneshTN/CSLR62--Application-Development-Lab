package com.example.bank_registration;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FinalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT);

        Log.d("FinalActivity","successfully registered");
    }
}

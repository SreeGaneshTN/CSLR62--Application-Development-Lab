package com.example.bank_registration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText phoneNumber;
    Button register;
    String usernameData;
    String phoneNumberData;
    String passwordData;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.usernameInput);
        password = (EditText) findViewById(R.id.passwordInput);
        phoneNumber = (EditText) findViewById(R.id.phoneNumberInput);
        register = findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDetails();
            }
        });
    }

    void getDetails(){
        usernameData = username.getText().toString();
        passwordData = password.getText().toString();
        phoneNumberData = phoneNumber.getText().toString();

        userDetails user = new userDetails(MainActivity.this, "users.db", null, 1);

        SQLiteDatabase db = user.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT username FROM userDetails WHERE username = "+"'"+usernameData+"'", null);

        if(cursor.moveToFirst()){
            Toast.makeText(this, "Already registered", Toast.LENGTH_SHORT).show();
        }
        else {
            prefs = getSharedPreferences("userDetails", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putString("username", usernameData);
            editor.putString("password", passwordData);
            editor.putString("phoneNumber", phoneNumberData);
            editor.commit();

            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("phoneNumber", phoneNumberData);
            startActivity(intent);
            
        }
        db.close();
    }



    public void addUserDetails(String usernameData, String passwordData, String phoneNumberData){

        userDetails user = new userDetails(MainActivity.this, "users.db", null, 1);

        SQLiteDatabase db = user.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", usernameData);
        contentValues.put("password", passwordData);
        contentValues.put("phoneNumber", phoneNumberData);

        db.insert("userDetails", null, contentValues);
        db.close();
        Log.d("MainActivity", "Added a user");

    }

    @Override
    protected void onResume() {
        super.onResume();
        prefs = getSharedPreferences("userDetails", MODE_PRIVATE);

        Boolean result = prefs.getBoolean("MATCHED", false);
        if(!result){
            Toast.makeText(getApplicationContext(), "You have entered the wrong OTP", Toast.LENGTH_SHORT).show();
            return ;
        }

        if(prefs.contains("username")){
            usernameData = prefs.getString("username", "");
        }
        else{
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
            return;
        }

        if(prefs.contains("password")){
            passwordData = prefs.getString("password", "");
        }
        else{
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
            return;
        }

        if(prefs.contains("password")){
            phoneNumberData = prefs.getString("phoneNumber", "");
        }
        else{
            Toast.makeText(this, "Something wrong", Toast.LENGTH_SHORT).show();
            return;
        }

        addUserDetails(usernameData, passwordData, phoneNumberData);

        Toast.makeText(getApplicationContext(), "You have successfully registered", Toast.LENGTH_SHORT).show();

    }
}
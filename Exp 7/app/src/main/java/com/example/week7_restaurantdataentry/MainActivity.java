package com.example.week7_restaurantdataentry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    private EditText edittext1, edittext2;
    private Button submitButton;
    public static String userName;
    public static String password;
    int count =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnChange();
        addListenerOnButton();
    }
    public void addListenerOnChange(){
        edittext1 = (EditText) findViewById(R.id.editTextUsername);
        edittext2 = (EditText) findViewById(R.id.editTextPassword);

        userName =  edittext1.getText().toString();
        password =  edittext2.getText().toString();
    }
    public void addListenerOnButton() {
        submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNewActivity();

            }
        });
    }


     public String reverseString(String str){
            StringBuilder sb=new StringBuilder(str);
            sb.reverse();
            return sb.toString();
        }

    protected void onResume() {
        super.onResume();
        if(count ==0) {
            Toast.makeText(getApplicationContext(), "Your password will be the exact reverse of your username", Toast.LENGTH_LONG).show();
            count =1;
        }
        Log.d("lifecycle MainActivity","onResume invoked");
    }

    public void openNewActivity(){

            addListenerOnChange();
            if(userName.equals("") || password.equals("")){
                Toast.makeText(getApplicationContext(), "Username and password can't be empty strings", Toast.LENGTH_LONG).show();
            }else {
                if (reverseString(userName).equals(password)) {
                    Intent intent = new Intent(this, NewActivity.class);
                    addNotification("Session Started", "Validation successful, welcome to a new session!");
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Password", Toast.LENGTH_LONG).show();
                }
            }
        }

    public void addNotification(String title, String msg) {
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "M_CH_ID");

        notificationBuilder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.ic_launcher_foreground)
                .setTicker("Hearty365")
                .setPriority(Notification.PRIORITY_MAX) // this is deprecated in API 26 but you can still use for below 26. check below update for 26 API
                .setContentTitle(title)
                .setContentText(msg)
                .setContentInfo("Info");

        NotificationManager notificationManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(1, notificationBuilder.build());
    }
}


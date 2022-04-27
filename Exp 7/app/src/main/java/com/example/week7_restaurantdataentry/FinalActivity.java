package com.example.week7_restaurantdataentry;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class FinalActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.finalactivity);
        addListenerOnButton();

    }
    public void addListenerOnButton() {
        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                openNewActivity();
            }
        });
    }
    public void openNewActivity(){
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //fetch and update textviews according to finalChoice[]
        TextView txtMenu = (TextView) findViewById(R.id.menu);
        TextView txtDrinks = (TextView) findViewById(R.id.drinks);
        TextView txtStarters = (TextView) findViewById(R.id.starters);
        TextView txtMainDish = (TextView) findViewById(R.id.mainDish);
        TextView txtDesserts = (TextView) findViewById(R.id.desserts);

        txtMenu.setText(NewActivity.finalChoices[0]);
        txtDrinks.setText(NewActivity.finalChoices[1]);
        txtStarters.setText(NewActivity.finalChoices[2]);
        txtMainDish.setText(NewActivity.finalChoices[3]);
        txtDesserts.setText(NewActivity.finalChoices[4]);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked for finalacitvity");
        addNotification("Session Ended", "Thank you for ordering at Sangeethas!");
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

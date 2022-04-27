package com.example.lab10_gpsspeech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements  LocationListener{
    private static final int REQUEST_LOCATION = 1;
    Button Get_location,textspeech;
    TextView showlatitude, showlongitude,showaddres;
    LocationManager locationManager;
    String Latitude, Longitude;
    TextToSpeech texttospeech;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        showlatitude = (TextView) findViewById(R.id.latitude);
        showlongitude = (TextView) findViewById(R.id.longitude);
        Get_location = findViewById(R.id.getLocation);
        textspeech=findViewById(R.id.text2speech);
        showaddres=findViewById(R.id.address);
        texttospeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR)
                {
                    texttospeech.setLanguage(Locale.US);
                }
            }
        });
        textspeech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Text="Your Location is Latitude:"+Latitude+" Degree North  Longitude"+Longitude +" Degree East";
                texttospeech.speak(Text,TextToSpeech.QUEUE_FLUSH,null);
                //texttospeech.speak("Longitude"+Longitude,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
        Get_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

                if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    OnGPS();
                } else {
                    getLocation();
                }
            }
        });


    }

    private void OnGPS() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Enable GPS").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void getLocation() {
        if (ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);
        }
        else {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0, (LocationListener) this);

        }
    }
    @Override
    public void onLocationChanged(Location location)
    {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(this, Locale.getDefault());
        double lat = location.getLatitude();
        double longi = location.getLongitude();
        try {
            addresses = geocoder.getFromLocation(lat, longi, 1);
            if (addresses != null && addresses.size() > 0) {
                String address = addresses.get(0).getAddressLine(0);
                String city = addresses.get(0).getLocality();
                String state = addresses.get(0).getAdminArea();
                String country = addresses.get(0).getCountryName();
                String postalCode = addresses.get(0).getPostalCode();
                String knownName = addresses.get(0).getFeatureName();
                showaddres.setText(address + " " + city + " " + country);
            } }catch (IOException e) {
            e.printStackTrace();
        }
        Latitude = String.valueOf(lat);
        Longitude = String.valueOf(longi);
        showlatitude.setText("Your Location: " + "\n" + "Latitude: " + Latitude+"deg N");
        showlongitude.setText("Longitude :" + Longitude + "deg E");
    }
}
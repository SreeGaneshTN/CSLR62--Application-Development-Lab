package com.example.week7_restaurantdataentry;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class NewActivity extends AppCompatActivity  {
    String[] menu = { "Veg", "NonVeg", "Keto"};
    String[] drinks = { "Coke", "Tea", "Frooti"};
    String[] starters = { "Lollipop", "Soup", "Gobi65"};
    String[] mainDish = { "Dosa", "Paratha", "Biriyani"};
    String[] desserts = { "Pastry", "Milkshake", "Icecream"};
    public static String[] finalChoices = {"","","","","",""};

    int c=0;
    int visited = 0;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getdata);
        submitButton = (Button) findViewById(R.id.submitButton);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = (Spinner) findViewById(R.id.spinnerMenu);
        Spinner spin1 = (Spinner) findViewById(R.id.spinnerDrinks);
        Spinner spin2 = (Spinner) findViewById(R.id.spinnerStarters);
        Spinner spin3 = (Spinner) findViewById(R.id.spinnerMainDish);
        Spinner spin4 = (Spinner) findViewById(R.id.spinnerDesserts);
        addListenerOnButton();

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if(c>0) {
                    Toast.makeText(getApplicationContext(), menu[position], Toast.LENGTH_LONG).show();
                }
                finalChoices[0] = menu[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if(c>0) {
                    Toast.makeText(getApplicationContext(),drinks[position] , Toast.LENGTH_LONG).show();
                }

                finalChoices[1] = drinks[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if(c>0) {
                    Toast.makeText(getApplicationContext(),starters[position] , Toast.LENGTH_LONG).show();
                }

                finalChoices[2] = starters[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if(c>0) {
                    Toast.makeText(getApplicationContext(),mainDish[position] , Toast.LENGTH_LONG).show();
                }

                finalChoices[3] = mainDish[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });
        spin4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener () {

            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1,
                                       int position, long id) {
                if(c>0) {
                    Toast.makeText(getApplicationContext(),desserts[position] , Toast.LENGTH_LONG).show();
                }else{
                    c++;
                }

                finalChoices[4] = desserts[position];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub

            }
        });

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item, menu);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        ArrayAdapter aa1 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, drinks);
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin1.setAdapter(aa1);

        ArrayAdapter aa2 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, starters);
        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin2.setAdapter(aa2);

        ArrayAdapter aa3 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mainDish);
        aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin3.setAdapter(aa3);

        ArrayAdapter aa4 = new ArrayAdapter(this,android.R.layout.simple_spinner_item, desserts);
        aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin4.setAdapter(aa4);


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
    public void openNewActivity(){
        visited =2;
        Intent intent = new Intent(this, FinalActivity.class);
        startActivity(intent);
    }

    protected void onStart() {
        super.onStart();
        if(visited==0) {
            Toast.makeText(getApplicationContext(), "Welcome "+ MainActivity.userName.toString() + "!", Toast.LENGTH_LONG).show();
            visited =1;
         }
        Log.d("lifecycle","onStart invoked");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("lifecycle","onResume invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        AlertDialog.Builder builder
                = new AlertDialog
                .Builder(this);

        // Set the message show for the Alert time
        builder.setMessage("What happened? You were inactive for awhile, do you want to restart?");

        // Set Alert Title
        builder.setTitle("Alert! We missed you!");

        // Set Cancelable false
        // for when the user clicks on the outside
        // the Dialog Box then it will remain show
        builder.setCancelable(false);

        // Set the positive button with yes name
        // OnClickListener method is use of
        // DialogInterface interface.

        builder
                .setPositiveButton(
                        "Yes",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // When the user click yes button
                                // then app will close
//                                visited = 0; // not need tho since it get destroyed whenver a backspace is performed
                                finish();

                            }
                        });

        // Set the Negative button with No name
        // OnClickListener method is use
        // of DialogInterface interface.
        builder
                .setNegativeButton(
                        "No",
                        new DialogInterface
                                .OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog,
                                                int which)
                            {

                                // If user click no
                                // then dialog box is canceled.
                                dialog.cancel();
                            }
                        });

        // Create the Alert dialog
        AlertDialog alertDialog = builder.create();

        // Show the Alert Dialog box
        if(visited != 2)
        alertDialog.show();

        Log.d("lifecycle","onStop invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("lifecycle","onPause invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Welcome back,"+ MainActivity.userName.toString() + "!", Toast.LENGTH_LONG).show();
        Log.d("lifecycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("lifecycle","onDestroy invoked");
    }

}
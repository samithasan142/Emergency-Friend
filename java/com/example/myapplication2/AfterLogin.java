package com.example.myapplication2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

public class AfterLogin extends AppCompatActivity {
    ImageButton police,fireService,trippleNine,hospital,blood,fuel,pharmacy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

        police = findViewById(R.id.police);
        fireService = findViewById(R.id.AtmBooth);
        hospital = findViewById(R.id.Hospital);
        trippleNine = findViewById(R.id.trippleNine);
        blood = findViewById(R.id.blood);
        fuel = findViewById(R.id.fuelStation);
        pharmacy = findViewById(R.id.Pharmacy);

        pharmacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forPharmacy();
            }
        });

        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forFuel();
            }
        });

        blood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forBlood();
            }
        });

        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forPolice();
            }
        });

        fireService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forFireStation();
            }
        });

        hospital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forHospital();
            }
        });

        trippleNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forTrippleNine();
            }
        });
    }

    private void forPharmacy() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=pharmacy");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forFuel() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=filling+station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
          //  Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
       // }
    }

    private void forPolice() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=police+station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
       // if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
       // }else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
       // }
    }

    private void forBlood() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(AfterLogin.this);
        View mView = getLayoutInflater().inflate(R.layout.dialog_spinner,null);
        mBuilder.setTitle("Choose Blood Group :");
        Spinner  mSpinner = mView.findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(AfterLogin.this,
                android.R.layout.simple_spinner_item,
                getResources().getStringArray(R.array.bloodtypes));

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(adapter);

        mBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                    Intent i = new Intent(AfterLogin.this,BloodSearchResult.class);
                    i.putExtra("type",mSpinner.getSelectedItem().toString());
                    startActivity(i);
                    dialog.dismiss();
            }
        });
        mBuilder.setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        mBuilder.setView(mView);
        AlertDialog dialog = mBuilder.create();
        dialog.show();
    }

    private void forHospital() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=hospitals+&+clinics");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
          //  Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forTrippleNine() {
        Intent dialIntent = new Intent();
        dialIntent.setAction(Intent.ACTION_DIAL);
        dialIntent.setData(Uri.parse("tel:999"));
        startActivity(dialIntent);
    }

    private void forFireStation() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=atm+booth");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
       // if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
          //  Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }
}
package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class EmergencyLogin extends AppCompatActivity {
    
    ImageButton police,fireService,trippleNine,hospital,fuel,atm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.emergency);
        
        police = findViewById(R.id.police);
        fireService = findViewById(R.id.AtmBooth);
        hospital = findViewById(R.id.Hospital);
        trippleNine = findViewById(R.id.trippleNine);
        fuel = findViewById(R.id.fuelStation);
        atm = findViewById(R.id.atmBooth);

        atm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                foratm();
            }
        });

        fuel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forfuel();
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

    private void foratm() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=nearest+atm+booth");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forfuel() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=nearest+filling+station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forTrippleNine() {
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:999"));

        if (ActivityCompat.checkSelfPermission(EmergencyLogin.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(callIntent);
    }

    private void forHospital() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=nearest+hospital");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forFireStation() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=nearest+pharmacy");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
        //}
    }

    private void forPolice() {
        Uri gmmIntentUri = Uri.parse("google.navigation:q=nearest+police+station");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");

        //if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        //}else{
            //Toast.makeText(getApplicationContext(),"Google Map is not installed or disabled", Toast.LENGTH_SHORT).show();
       // }
    }
}
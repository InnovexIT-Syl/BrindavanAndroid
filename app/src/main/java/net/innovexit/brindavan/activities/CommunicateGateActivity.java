package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.NavigationIconClickListener;
import net.innovexit.brindavan.R;


public class CommunicateGateActivity extends AppCompatActivity {
    ImageButton parcel,guest,police,driver,taxiCab;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_communicate_gate);

        setUpToolbar();

        parcel = findViewById(R.id.parcel);
        guest = findViewById(R.id.guest);
        police = findViewById(R.id.police);
        driver = findViewById(R.id.driver);
        taxiCab = findViewById(R.id.taxiCab);

        parcel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("Parcel");
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("Guest");
            }
        });
        police.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("Police Officer");
            }
        });
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("Driver");
            }
        });
        taxiCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity("TaxiCab");
            }
        });

    }

    private void goToActivity(String value) {
        Intent intent = new Intent(this,HireNewHelpsActivity.class);
        intent.putExtra("value",value);
        startActivity(intent);
    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.communicate_app_bar);
        this.setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.backspace);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

    }


}

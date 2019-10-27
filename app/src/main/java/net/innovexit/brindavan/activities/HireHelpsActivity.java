package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.R;


public class HireHelpsActivity extends AppCompatActivity {

    ImageButton maid, guest, police_officer, driver, taxiCab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_helps);

        setUpToolbar();

        maid = findViewById(R.id.maid);
        guest = findViewById(R.id.guest);
        police_officer = findViewById(R.id.police_officer);
        driver = findViewById(R.id.driver);
        taxiCab = findViewById(R.id.taxiCab);

        maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });
        guest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });
        police_officer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });
        driver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });
        taxiCab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.hireContainer).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        } else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);
        }


    }

    public void goToActivity() {
        startActivity(new Intent(this, HireNewHelpsActivity.class));
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.hire_app_bar);
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

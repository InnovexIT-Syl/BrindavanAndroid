package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.NavigationIconClickListener;
import net.innovexit.brindavan.R;


public class UnannouncedActivity extends AppCompatActivity {

    MaterialButton homeBtn, noticeBtn, vehicleBtn, familyBtn, residentBtn, communicateBtn, dailyBtn, helpGuestBtn, hireBtn, serviceBtn, sosBtn, unannouncedBtn;

    Intent intentNotice, intentVehicle, intentFamily, intentResident, intentHome, intentDaily, intentGuestHelp, intentHire, intentService, intentSoS, intentCommunicate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unannounced);

        setUpToolbar();

    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.unannounced_app_bar);
        this.setSupportActionBar(toolbar);

        //        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
//                this,
//                findViewById(R.id.communicateContainer),findViewById(R.id.commuMenu),
//                new AccelerateDecelerateInterpolator(),
//                this.getResources().getDrawable(R.drawable.menu), // Menu open icon
//                this.getResources().getDrawable(R.drawable.shr_close_menu))); // Menu close icon

        toolbar.setNavigationIcon(R.drawable.backspace);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

    }


}

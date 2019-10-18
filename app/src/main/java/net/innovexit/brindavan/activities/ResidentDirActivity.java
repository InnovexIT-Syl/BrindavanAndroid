package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.NavigationIconClickListener;
import net.innovexit.brindavan.R;


public class ResidentDirActivity extends AppCompatActivity {

    MaterialButton homeBtn, noticeBtn, vehicleBtn, familyBtn, residentBtn, communicateBtn
            , dailyBtn, helpGuestBtn, hireBtn, serviceBtn, sosBtn, unannouncedBtn;

    Intent intentNotice, intentVehicle, intentFamily, intentCommunicate, intentHome
            , intentDaily, intentGuestHelp, intentHire, intentService, intentSoS, intentUnannounced;

    String[] blocks = {"Block A","Block B", "Block C", "Block D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resident_dir);

        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.block_list_item, blocks);

        ListView listView = findViewById(R.id.residentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "You clicked "+ ((TextView)view).getText(), Toast.LENGTH_SHORT).show();

            }
        });


        setUpToolbar();

        VehicleLogsActivity navigate = new VehicleLogsActivity();

        homeBtn = findViewById(R.id.home);
        noticeBtn = findViewById(R.id.notice);
        vehicleBtn = findViewById(R.id.vehicle);
        familyBtn = findViewById(R.id.family);
        residentBtn = findViewById(R.id.resident);
        communicateBtn = findViewById(R.id.communicate);
        dailyBtn = findViewById(R.id.helps);
        helpGuestBtn = findViewById(R.id.help_guest);
        hireBtn = findViewById(R.id.hire);
        serviceBtn = findViewById(R.id.service);
        sosBtn = findViewById(R.id.sos);
        unannouncedBtn = findViewById(R.id.unannounced);

        intentNotice = new Intent(this, NoticeBoardActivity.class);
        intentVehicle = new Intent(this, VehicleLogsActivity.class);
        intentFamily = new Intent(this, FamilyMembersActivity.class);
        intentCommunicate = new Intent(this, CommunicateGateActivity.class);
        intentHome = new Intent(this, HomeActivity.class);
        intentDaily = new Intent(this, DailyHelpsActivity.class);
        intentGuestHelp = new Intent(this, HelpGuestActivity.class);
        intentHire = new Intent(this, HireHelpsActivity.class);
        intentService = new Intent(this, ServiceActivity.class);
        intentSoS = new Intent(this, SoSActivity.class);
        intentUnannounced = new Intent(this, UnannouncedActivity.class);

        navigate.navigateTo(this, residentBtn, getIntent(), true);
        navigate.navigateTo(this,noticeBtn, intentNotice, false);
        navigate.navigateTo(this, vehicleBtn, intentVehicle, false);
        navigate.navigateTo(this, familyBtn, intentFamily, false);
        navigate.navigateTo(this, communicateBtn, intentCommunicate, false);
        navigate.navigateTo(this,homeBtn, intentHome, false);
        navigate.navigateTo(this, dailyBtn, intentDaily, false);
        navigate.navigateTo(this,helpGuestBtn, intentGuestHelp, false);
        navigate.navigateTo(this, hireBtn, intentHire, false);
        navigate.navigateTo(this, serviceBtn, intentService, false);
        navigate.navigateTo(this, sosBtn, intentSoS, false);
        navigate.navigateTo(this,unannouncedBtn, intentUnannounced, false);




        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.residentContainer).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }
        else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);

        }



    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.resident_app_bar);
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

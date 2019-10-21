package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.NavigationIconClickListener;
import net.innovexit.brindavan.R;


public class DailyHelpsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_helps);

        setUpToolbar();



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.allHelps).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }
        else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);
        }



    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.helps_app_bar);
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

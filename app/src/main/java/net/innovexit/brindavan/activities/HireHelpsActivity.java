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


public class HireHelpsActivity extends AppCompatActivity {

    ImageButton maid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_helps);

        setUpToolbar();

        maid = findViewById(R.id.maid);
        maid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),HireNewHelpActivity.class));
            }
        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.hireContainer).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        } else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);
        }


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

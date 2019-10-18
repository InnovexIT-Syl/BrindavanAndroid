package net.innovexit.brindavan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.innovexit.brindavan.R;

public class ServiceProviderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider);
        setUpToolbar();

    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.admin_app_bar);
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

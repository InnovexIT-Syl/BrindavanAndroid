package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.R;
import net.innovexit.brindavan.adapters.MyRequestsAdapter;
import net.innovexit.brindavan.models.MyRequestModel;

import java.util.ArrayList;
import java.util.List;


public class ServiceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRequestsAdapter requestItemAdapter;
    private List<MyRequestModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        setUpToolbar();

        getItemList();

        recyclerView = findViewById(R.id.requestList);

        requestItemAdapter = new MyRequestsAdapter(this,items);

        recyclerView.setLayoutManager(new LinearLayoutManager(ServiceActivity.this));

        recyclerView.setAdapter(requestItemAdapter);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.serviceContainer).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }
        else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);
        }



    }

    private void getItemList() {

        items = new ArrayList<>();


        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        items.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        items.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        items.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));


    }


    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.service_app_bar);
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

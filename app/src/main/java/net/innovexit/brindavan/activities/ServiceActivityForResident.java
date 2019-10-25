package net.innovexit.brindavan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.R;
import net.innovexit.brindavan.adapters.MyRequestsAdapter;
import net.innovexit.brindavan.models.MyRequestModel;

import java.util.ArrayList;
import java.util.List;

public class ServiceActivityForResident extends AppCompatActivity {

    RecyclerView requestListView;
    TextView addNew;

    MyRequestsAdapter myRequestsAdapter;


    List<MyRequestModel> requestList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_for_resident);

        getRequestList();

        myRequestsAdapter = new MyRequestsAdapter(this, requestList);

        requestListView = findViewById(R.id.requestListByResident);
        addNew = findViewById(R.id.addNewRequst);

        requestListView.setLayoutManager(new LinearLayoutManager(ServiceActivityForResident.this));
        requestListView.setAdapter(myRequestsAdapter);

        addNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), HireHelpsActivity.class));
            }
        });

        setUpToolbar();





        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            findViewById(R.id.serviceContainer).setBackgroundResource(R.drawable.shr_product_grid_background_shape);
        }
        else {
            ApiDialog apiDialog = new ApiDialog();
            apiDialog.showDialog(this);
        }

    }

    private void getRequestList() {
        requestList = new ArrayList<>();

        requestList.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        requestList.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        requestList.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));
        requestList.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        requestList.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        requestList.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));
        requestList.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd"));
        requestList.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis"));
        requestList.add(new MyRequestModel("M Rahat","Engineer","+4565764","Self Employed"));


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

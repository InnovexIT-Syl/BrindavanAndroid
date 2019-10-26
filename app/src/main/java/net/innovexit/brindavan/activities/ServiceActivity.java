package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

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
    private EditText inputSearch;

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

        inputSearch = findViewById(R.id.serviceSearch);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                requestItemAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });



    }

    private void getItemList() {

        items = new ArrayList<>();


        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-B" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","24-09-2018","Unit-C" ));
        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","10-12-2019","Unit-A" ));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","01-10-2019","Unit-D" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","02-08-2017","Unit-E" ));
        items.add(new MyRequestModel("M Rahat","Cook","+4565764","Self Employed","21-09-2019","Unit-F" ));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-H" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","12-09-2019","Unit-B" ));
        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","12-09-2019","Unit-G" ));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-B" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","24-09-2018","Unit-C" ));
        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","10-12-2019","Unit-A" ));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","01-10-2019","Unit-D" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","02-08-2017","Unit-E" ));
        items.add(new MyRequestModel("M Rahat","Cook","+4565764","Self Employed","21-09-2019","Unit-F" ));
        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-H" ));
        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","12-09-2019","Unit-B" ));
        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","12-09-2019","Unit-G" ));


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

package net.innovexit.brindavan.activities;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import net.innovexit.brindavan.ApiDialog;
import net.innovexit.brindavan.R;
import net.innovexit.brindavan.adapters.MyRequestsAdapter;
import net.innovexit.brindavan.models.MyRequestModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class ServiceActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyRequestsAdapter requestItemAdapter;
    private List<MyRequestModel> items = new ArrayList<>();
    private EditText inputSearch;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference reference = db.collection("Complex").document("Resident").collection("ServiceRequest");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        setUpToolbar();

        getItemList();

        recyclerView = findViewById(R.id.requestList);

        requestItemAdapter = new MyRequestsAdapter(getApplicationContext(),items);

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


          reference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
              @Override
              public void onComplete(@NonNull Task<QuerySnapshot> task) {
                  for(DocumentSnapshot snapshot : Objects.requireNonNull(task.getResult())){
                      MyRequestModel model = new MyRequestModel(snapshot.getString("name"), snapshot.getString("serviceType"),
                              snapshot.getString("others"),snapshot.getString("phoneNumber"), snapshot.getString("currentDate"),snapshot.getString("accessType"));

                      items.add(model);

                  }

              }
          }).addOnFailureListener(new OnFailureListener() {
              @Override
              public void onFailure(@NonNull Exception e) {
                  Toast.makeText(ServiceActivity.this, "Problem on retrieving data!", Toast.LENGTH_SHORT).show();
              }
          });


//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-B" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","24-09-2018","Unit-C" ));
//        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","10-12-2019","Unit-A" ));
//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","01-10-2019","Unit-D" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","02-08-2017","Unit-E" ));
//        items.add(new MyRequestModel("M Rahat","Cook","+4565764","Self Employed","21-09-2019","Unit-F" ));
//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-H" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","12-09-2019","Unit-B" ));
//        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","12-09-2019","Unit-G" ));
//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-B" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","24-09-2018","Unit-C" ));
//        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","10-12-2019","Unit-A" ));
//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","01-10-2019","Unit-D" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","02-08-2017","Unit-E" ));
//        items.add(new MyRequestModel("M Rahat","Cook","+4565764","Self Employed","21-09-2019","Unit-F" ));
//        items.add(new MyRequestModel("Adil Varma","Doctor","+9028474","HealthLtd","12-09-2019","Unit-H" ));
//        items.add(new MyRequestModel("Aminul Islam","Electrician","+345654","Sigma Electronis","12-09-2019","Unit-B" ));
//        items.add(new MyRequestModel("M Rahat","Maid","+4565764","Self Employed","12-09-2019","Unit-G" ));


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

package net.innovexit.brindavan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class ServiceActivityForResident extends AppCompatActivity {

    RecyclerView requestListView;
    TextView addNew;

    MyRequestsAdapter myRequestsAdapter;


    private EditText inputSearch;
    private List<MyRequestModel> items = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference reference = db.collection("Complex").document("Resident").collection("ServiceRequest");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_for_resident);

        getRequestList();

        requestListView = findViewById(R.id.requestListByResident);

        myRequestsAdapter = new MyRequestsAdapter(getApplicationContext(),items);

        requestListView.setLayoutManager(new LinearLayoutManager(ServiceActivityForResident.this));

        requestListView.setAdapter(myRequestsAdapter);

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

        inputSearch = findViewById(R.id.searchBox);

        inputSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {

                myRequestsAdapter.getFilter().filter(charSequence);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }

    private void getRequestList() {
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
                Toast.makeText(getApplicationContext(), "Problem on retrieving data!", Toast.LENGTH_SHORT).show();
            }
        });

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

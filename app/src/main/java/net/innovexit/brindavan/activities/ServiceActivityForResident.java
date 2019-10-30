package net.innovexit.brindavan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
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
import com.google.firebase.firestore.DocumentReference;
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

    private ProgressDialog progressDialog;


    private EditText inputSearch;
    private List<MyRequestModel> items = new ArrayList<>();
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    CollectionReference databaseColectionReference = db.collection("Complex");
    DocumentReference reference = databaseColectionReference.document("kwtfIEYu1k0AHJ9VXQ81");
    CollectionReference serviceRequestCollectionReference = reference.collection("complex_servicerequests");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_for_resident);

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Fetching data...");
        progressDialog.show();

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
                startActivity(new Intent(getApplicationContext(), CommunicateGateActivity.class));
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
        serviceRequestCollectionReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                for(DocumentSnapshot snapshot : Objects.requireNonNull(task.getResult())){
                    MyRequestModel model = new MyRequestModel(snapshot.getString(
                            "correspondingname"), snapshot.getString("servicerequesttype"),
                            snapshot.getString("phone"),snapshot.getString("requirenotificationonentry"),
                            snapshot.getString("unitnum"),snapshot.getString("requesteddate"),
                            snapshot.getReference(),snapshot.getString("suspend"));

                    items.add(model);
                    progressDialog.hide();

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

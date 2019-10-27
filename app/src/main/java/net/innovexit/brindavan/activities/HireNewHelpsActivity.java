package net.innovexit.brindavan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.innovexit.brindavan.R;
import net.innovexit.brindavan.models.ServiceRequestModels;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HireNewHelpsActivity extends AppCompatActivity {
    EditText name, phoneNumber, others, serviceType;
    Button addRequest;
    private FirebaseFirestore database;
    private RadioGroup radioGroup;
    private RadioButton accessButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_new_helps);

        setUpToolbar();

        // init database
        database = FirebaseFirestore.getInstance();

        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        serviceType = findViewById(R.id.serviceType);
        others = findViewById(R.id.others);
        others.setText("");

        addRequest = findViewById(R.id.addRequest);

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
        serviceType.setText(value);

        radioGroup = findViewById(R.id.radioGroupId);


        // save data
        addRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformation();
            }
        });

    }
    private boolean hasValidationErrors(String _name, String _phoneNumber, String _serviceType) {
        if (_name.isEmpty()) {
            name.setError("Name required");
            name.requestFocus();
            return true;
        }

        if (_phoneNumber.isEmpty()) {
            phoneNumber.setError("Phone number required");
            phoneNumber.requestFocus();
            return true;
        }
        if (_serviceType.isEmpty()) {
            serviceType.setError("Service type is always is required");
            serviceType.requestFocus();
            return true;
        }

        return false;
    }

    private void saveInformation() {
        String _name = name.getText().toString().trim();
        String _phoneNumber = phoneNumber.getText().toString().trim();
        String _others = others.getText().toString().trim();
        String _serviceType = serviceType.getText().toString().trim();

        int selectedId = radioGroup.getCheckedRadioButtonId();
        accessButton = findViewById(selectedId);
        String _accessType = accessButton.getText().toString().trim();

        Date date = Calendar.getInstance().getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
       SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
        String currentDate = dateFormat.format(date);


        if (!hasValidationErrors(_name, _phoneNumber, _serviceType)) {

            CollectionReference serviceRequestReference = database.collection("Complex");
            DocumentReference reference = serviceRequestReference.document("Resident");
            CollectionReference serviceRequestCollectionReference = reference.collection("ServiceRequest");

            ServiceRequestModels serviceRequestModels = new ServiceRequestModels(_name, _phoneNumber, _serviceType, _accessType, _others,currentDate);

            serviceRequestCollectionReference.add(serviceRequestModels).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    name.setText("");
                    phoneNumber.setText("");
                    serviceType.setText("");
                    others.setText("");

                    Toast.makeText(HireNewHelpsActivity.this, "Service Request Data Added", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(HireNewHelpsActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
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

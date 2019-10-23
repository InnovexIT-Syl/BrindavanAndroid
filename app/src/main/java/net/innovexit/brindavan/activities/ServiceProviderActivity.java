package net.innovexit.brindavan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.innovexit.brindavan.models.ServiceProvider;
import net.innovexit.brindavan.R;

public class ServiceProviderActivity extends AppCompatActivity {

    private EditText name, phoneNumber, address, workingExperience;
    Button saveButton;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_provider);
        setUpToolbar();

        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        address = findViewById(R.id.address);
        workingExperience = findViewById(R.id.workingExperience);

        saveButton = findViewById(R.id.addInformation);

        // init database
        database = FirebaseFirestore.getInstance();

        // save data
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformation();
            }
        });

    }

    private void saveInformation() {
        String _name = name.getText().toString().trim();
        String _phoneNumber = phoneNumber.getText().toString().trim();
        String _address = address.getText().toString().trim();
        String _workingExperience = workingExperience.getText().toString().trim();


        if (!hasValidationErrors(_name, _phoneNumber, _address, _workingExperience)) {

            CollectionReference serviceProviderCollectionReference = database.collection("ServiceProvider");

            ServiceProvider serviceProvider = new ServiceProvider(_name, _phoneNumber, _address, _workingExperience);

            serviceProviderCollectionReference.add(serviceProvider)
                    .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                        @Override
                        public void onSuccess(DocumentReference documentReference) {
                            Toast.makeText(ServiceProviderActivity.this, "ServiceProvider data is saved", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(ServiceProviderActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }


    private boolean hasValidationErrors(String _name, String _phoneNumber, String _address, String _experience) {
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

        if (_address.isEmpty()) {
            address.setError("Address required");
            address.requestFocus();
            return true;
        }

        if (_experience.isEmpty()) {
            workingExperience.setError("Working Experience required");
            workingExperience.requestFocus();
            return true;
        }
        return false;
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.admin_app_bar);
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

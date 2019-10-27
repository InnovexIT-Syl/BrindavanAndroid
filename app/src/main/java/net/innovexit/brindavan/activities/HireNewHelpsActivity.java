package net.innovexit.brindavan.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import net.innovexit.brindavan.R;
import net.innovexit.brindavan.models.ServiceRequestModels;

public class HireNewHelpsActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{
    TextView serviceType;
    EditText name, phoneNumber, serviceProviderName, residentName, address, workingExperience;
    Button addRequest;
    private FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hire_new_helps);

        serviceType = findViewById(R.id.serviceTypeText);

        // init database
        database = FirebaseFirestore.getInstance();

        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phoneNumber);
        serviceProviderName = findViewById(R.id.serviceProviderName);
        residentName = findViewById(R.id.residentName);
        address = findViewById(R.id.address);
        workingExperience = findViewById(R.id.workingExperience);

        addRequest = findViewById(R.id.addRequest);

        // save data
        addRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInformation();
            }
        });

    }

    private boolean hasValidationErrors(String _name, String _phoneNumber, String _address, String _serviceProviderName, String _residentName, String _serviceType, String _experience) {
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
        if (_serviceProviderName.isEmpty()) {
            address.setError("Address required");
            address.requestFocus();
            return true;
        }
        if (_residentName.isEmpty()) {
            address.setError("Address required");
            address.requestFocus();
            return true;
        }
        if (_serviceType.isEmpty()) {
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

    private void saveInformation() {
        String _name = name.getText().toString().trim();
        String _phoneNumber = phoneNumber.getText().toString().trim();
        String _serviceProviderName = serviceProviderName.getText().toString().trim();
        String _residentName = residentName.getText().toString().trim();
        String _address = address.getText().toString().trim();
        String _workingExperience = workingExperience.getText().toString().trim();
        String _serviceType = serviceType.getText().toString().trim();

        if (!hasValidationErrors(_name, _phoneNumber, _address, _serviceProviderName, _residentName, _serviceType, _workingExperience)) {

            DocumentReference ServiceRequestReference = database.collection("Complex").document("Complex_service")
                    .collection("Complex_service_requests").document("Complex_service_requests_data");

            ServiceRequestModels serviceRequestModels = new ServiceRequestModels(_name, _phoneNumber, _address, _serviceProviderName, _residentName, _serviceType, _workingExperience);


            ServiceRequestReference.set(serviceRequestModels)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(HireNewHelpsActivity.this, "ServiceRequests data is saved", Toast.LENGTH_SHORT).show();
                            name.setText("");
                            phoneNumber.setText("");
                            serviceProviderName.setText("");
                            residentName.setText("");
                            address.setText("");
                            serviceType.setText("");
                            workingExperience.setText("");

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(HireNewHelpsActivity.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void showPopUp(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.request_type_option_menu);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.one:
                serviceType.setText("Maid");
                return true;
            case R.id.two:
                serviceType.setText("Guest");
                return true;
            case R.id.three:
                serviceType.setText("Police Officer");
                return true;
            case R.id.four:
                serviceType.setText("Driver");
                return true;
            case R.id.five:
                serviceType.setText("Taxi Cab");
                return true;
            default:
                return false;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

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
    EditText name, phoneNumber, unitNo, serviceType;
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
        unitNo = findViewById(R.id.unitNumber);
        unitNo.setText("");

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

    private boolean hasValidationErrors(String _name, String _phoneNumber, String _serviceType, String _unitNo) {
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

        if (_unitNo.isEmpty()) {
            unitNo.setError("Unit No is always is required");
            unitNo.requestFocus();
            return true;
        }

        return false;
    }

    private void saveInformation() {

        int selectedId = radioGroup.getCheckedRadioButtonId();
        accessButton = findViewById(selectedId);

        Date date = Calendar.getInstance().getTime();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss a");
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");


        String correspondingname = name.getText().toString().trim();
        String phone = phoneNumber.getText().toString().trim();
        String requesteddate = dateFormat.format(date);
        String requirenotificationonentry = accessButton.getText().toString().trim();
        String servicerequesttype = serviceType.getText().toString().trim();
        String unitnum = unitNo.getText().toString().trim();
        String deliverytype = "undefined";
        String delverynote = "undefined";
        String adhocvisitorphoto = "undefined";
        int complexid = 123;
        String enddate = "undefined";
        String notes_instructions = "undefined";
        int requesterid = 234;
        String requestertype = "undefined";
        int serviceprovider_requestnumber = 456;
        int serviceproviderid = 678;
        int servicerequestormemberuserid = 955;
        String startdate = "undefined";
        boolean suspend = false;
        boolean terminate = false;


        if (!hasValidationErrors(correspondingname, phone, servicerequesttype, unitnum)) {

            CollectionReference databseCollectionReference = database.collection("Complex");
            DocumentReference reference = databseCollectionReference.document("kwtfIEYu1k0AHJ9VXQ81");
            CollectionReference serviceRequestCollectionReference = reference.collection("complex_servicerequests");

            ServiceRequestModels serviceRequestModels = new ServiceRequestModels(correspondingname, phone,
                    requesteddate, requirenotificationonentry,servicerequesttype, unitnum,
                            deliverytype,delverynote,adhocvisitorphoto,complexid,enddate,
                            notes_instructions,requesterid,requestertype,
                            serviceprovider_requestnumber,serviceproviderid,
                            servicerequestormemberuserid,startdate,suspend,terminate);

            serviceRequestCollectionReference.add(serviceRequestModels).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                @Override
                public void onSuccess(DocumentReference documentReference) {
                    name.setText("");
                    phoneNumber.setText("");
                    serviceType.setText("");
                    unitNo.setText("");

                    Toast.makeText(HireNewHelpsActivity.this, "Service Request Data Added", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), ServiceActivityForResident.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(HireNewHelpsActivity.this, "Failed to upload data!" + e.getMessage(), Toast.LENGTH_SHORT).show();
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

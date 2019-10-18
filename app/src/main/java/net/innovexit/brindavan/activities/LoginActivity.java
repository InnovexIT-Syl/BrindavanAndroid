package net.innovexit.brindavan.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import net.innovexit.brindavan.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void goMainPage(View view) {
        startActivity(new Intent(this, HomeActivity.class));
    }
    public void goSignUpPage(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }
}

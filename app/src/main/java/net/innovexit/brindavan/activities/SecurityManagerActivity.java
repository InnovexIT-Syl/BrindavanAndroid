package net.innovexit.brindavan.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import net.innovexit.brindavan.R;

public class SecurityManagerActivity extends AppCompatActivity {
    private Context mContext;
    //private Activity myActivity;

    private RelativeLayout mRelativeLayout;
    private Button mButton1, mButton2;

    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_manager);

        mContext = getApplicationContext();
        setUpToolbar();
        mRelativeLayout = findViewById(R.id.rl);
        mButton1 = findViewById(R.id.btn1);
        mButton2 = findViewById(R.id.btn2);

        mButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.custom_pop_up_guard, null);
                mPopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }

                Button closeButton = customView.findViewById(R.id.button_close);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER, 0, 0);
            }
        });


        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Initialize a new instance of LayoutInflater service
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.custom_pop_up_member, null);
                mPopupWindow = new PopupWindow(
                        customView,
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

                if (Build.VERSION.SDK_INT >= 21) {
                    mPopupWindow.setElevation(5.0f);
                }

                Button closeButton = customView.findViewById(R.id.button_close);
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER, 0, 0);
            }
        });
    }

    private void setUpToolbar() {
        Toolbar toolbar = findViewById(R.id.admin_app_bar);
        this.setSupportActionBar(toolbar);

//        toolbar.setNavigationOnClickListener(new NavigationIconClickListener(
//                this,
//                findViewById(R.id.communicateContainer),findViewById(R.id.commuMenu),
//                new AccelerateDecelerateInterpolator(),
//                this.getResources().getDrawable(R.drawable.menu), // Menu open icon
//                this.getResources().getDrawable(R.drawable.shr_close_menu))); // Menu close icon

        toolbar.setNavigationIcon(R.drawable.backspace);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), HomeActivity.class));
            }
        });

    }
}




package net.innovexit.brindavan;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ApiDialog {
    public void showDialog(final Context context) {

        //Just Checking the clone push

        final Dialog dialog = new Dialog(context);

        dialog.setTitle("Ops!");
        dialog.setContentView(R.layout.api_dialog);

        TextView textView = dialog.findViewById(R.id.dialogtext);

        textView.setText("Need API Level 23 Or Higher");

        ImageView imageView = dialog.findViewById(R.id.dialogImg);

        imageView.setImageResource(R.drawable.home);

        Button button = dialog.findViewById(R.id.dialogBtn);

        dialog.show();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
    }
}

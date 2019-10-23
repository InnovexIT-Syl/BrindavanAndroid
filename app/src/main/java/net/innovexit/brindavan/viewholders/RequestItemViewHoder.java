package net.innovexit.brindavan.viewholders;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import net.innovexit.brindavan.R;


public class RequestItemViewHoder extends GroupViewHolder {

    private TextView requestType, requestDate, requestUnit;

    public RequestItemViewHoder(View itemView) {
        super(itemView);
        requestType = itemView.findViewById(R.id.serviceReqType);
        requestDate = itemView.findViewById(R.id.serviceDate);
        requestUnit = itemView.findViewById(R.id.serviceReqUnit);
    }

    public void setRequestType(String type) {
        requestType.setText(type);
    }

    public void setRequestDate(String date) {
        requestDate.setText(date);
    }

    public void setRequestUnit(String unit) {
        requestUnit.setText(unit);
    }
}

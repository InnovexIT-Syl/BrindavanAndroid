package net.innovexit.brindavan.viewholders;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import net.innovexit.brindavan.R;

public class RequestDetailsViewHolder extends ChildViewHolder {

    private TextView servicePersonName, personJob, phoneNumber, serviceCompany;


    public RequestDetailsViewHolder(View itemView) {
        super(itemView);
        servicePersonName = itemView.findViewById(R.id.serviceProviderName);
        personJob = itemView.findViewById(R.id.serviceProviderJob);
        phoneNumber = itemView.findViewById(R.id.serviceProviderNumber);
        serviceCompany = itemView.findViewById(R.id.serviceProviderLtd);

    }
    public void setServicePersonName(String name) {
        servicePersonName.setText(name);
    }

    public void setPersonJob(String job) {
        personJob.setText(job);
    }

    public void setPhoneNumber(String number) {
        phoneNumber.setText(number);
    }

    public void setServiceCompany(String company) {
        serviceCompany.setText(company);
    }


}

package net.innovexit.brindavan.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.innovexit.brindavan.R;
import net.innovexit.brindavan.models.MyRequestModel;

import java.util.List;

public class MyRequestsAdapter extends RecyclerView.Adapter<MyRequestsAdapter.MyRequestDetailsViewHolder> {

    private Context context;

    private List<MyRequestModel> requestList;
    private static int currentPosition;


    public MyRequestsAdapter(Context context, List<MyRequestModel> requestList) {
        this.context = context;
        this.requestList = requestList;
    }

    @NonNull
    @Override
    public MyRequestDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_details_item, parent, false);

        return new MyRequestDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyRequestDetailsViewHolder holder, final int position) {

        MyRequestModel requestDetailsModel = requestList.get(position);

        holder.setServicePersonName(requestDetailsModel.getServicePersonName());
        holder.setPersonJob(requestDetailsModel.getPersonJob());
        holder.setPhoneNumber(requestDetailsModel.getPhoneNumber());
        holder.setServiceCompany(requestDetailsModel.getServiceCompany());
        holder.expandLayout.setVisibility(View.GONE);

        //if the position is equals to the item position which is to be expanded


        holder.headerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                //getting the position of the item to expand it
                currentPosition = position;
                                //reloding the list
                notifyDataSetChanged();
            }
        });
        if (currentPosition == position) {
            //creating an animation
            @SuppressLint("ResourceType") Animation slideDown = AnimationUtils.loadAnimation(context, R.animator.slide_down);

            //toggling visibility
            holder.expandLayout.setVisibility(View.VISIBLE);

            //adding sliding effect
            holder.expandLayout.startAnimation(slideDown);
        }
    }


    @Override
    public int getItemCount() {
        try {
            return requestList.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    class MyRequestDetailsViewHolder extends RecyclerView.ViewHolder{

        private TextView servicePersonName, personJob, phoneNumber, serviceCompany;
        LinearLayout headerLayout, expandLayout;


        MyRequestDetailsViewHolder(View itemView) {
            super(itemView);
            servicePersonName = itemView.findViewById(R.id.serviceProviderName);
            personJob = itemView.findViewById(R.id.serviceProviderJob);
            phoneNumber = itemView.findViewById(R.id.serviceProviderNumber);
            serviceCompany = itemView.findViewById(R.id.serviceProviderLtd);
            headerLayout = itemView.findViewById(R.id.headerLayout);
            expandLayout = itemView.findViewById(R.id.expandLayout);

        }
       private void setServicePersonName(String name) {
            servicePersonName.setText(name);
        }

        private void setPersonJob(String job) {
            personJob.setText(job);
        }

        private void setPhoneNumber(String number) {
            phoneNumber.setText(number);
        }

        private void setServiceCompany(String company) {
            serviceCompany.setText(company);
        }
    }
}

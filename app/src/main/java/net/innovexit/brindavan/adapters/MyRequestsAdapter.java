package net.innovexit.brindavan.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import net.innovexit.brindavan.R;
import net.innovexit.brindavan.models.MyRequestModel;

import java.util.ArrayList;
import java.util.List;

public class MyRequestsAdapter extends RecyclerView.Adapter<MyRequestsAdapter.MyRequestDetailsViewHolder> implements Filterable {

    private Context context;

    private List<MyRequestModel> requestList;
    private List<MyRequestModel> requestListFilter;
    private static int currentPosition;
    private boolean clicked = false;




    public MyRequestsAdapter(Context context, List<MyRequestModel> requestList) {
        this.context = context;
        this.requestList = requestList;
        this.requestListFilter = requestList;
    }

    @NonNull
    @Override
    public MyRequestDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.request_details_item, parent, false);

        return new MyRequestDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyRequestDetailsViewHolder holder, final int position) {

        final MyRequestModel requestDetailsModel = requestListFilter.get(position);

        holder.setServicePersonName(requestDetailsModel.getServicePersonName());
        holder.setPhoneNumber(requestDetailsModel.getPhoneNumber());
        holder.setServiceCompany(requestDetailsModel.getAccessType());
        holder.setServiceCategory(requestDetailsModel.getPersonJob());
        holder.setServiceDate(requestDetailsModel.getServiceDate());
        holder.setServiceUnit(requestDetailsModel.getServiceUnit());
        holder.allow.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });
        holder.reject.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

            }
        });

        if (requestDetailsModel.getAccessType().contains("Direct Pass")){
            holder.callResident.setVisibility(View.GONE);
            holder.directPass.setVisibility(View.VISIBLE);
        }
        if (requestDetailsModel.getAccessType().contains("Call Resident")){
            holder.callResident.setVisibility(View.VISIBLE);
            holder.directPass.setVisibility(View.GONE);
        }

        //creating an animation


        //if the position is equals to the item position which is to be expanded


        holder.headerLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (requestDetailsModel.getAccessType().contains("Direct Pass")){
                    holder.callResident.setVisibility(View.GONE);
                    holder.directPass.setVisibility(View.VISIBLE);
                }
                if (requestDetailsModel.getAccessType().contains("Call Resident")){
                    holder.callResident.setVisibility(View.VISIBLE);
                    holder.directPass.setVisibility(View.GONE);
                }
                clicked = !clicked;

                //getting the position of the item to expand it
                currentPosition = position;
                //reloding the list
                notifyDataSetChanged();
            }
        });


        if (currentPosition == position && clicked) {
            //creating an animation
            @SuppressLint("ResourceType") Animation slideDown = AnimationUtils.loadAnimation(context, R.animator.slide_down);

            //toggling visibility
            holder.expandLayout.setVisibility(View.VISIBLE);
            //adding sliding effect
            holder.expandLayout.startAnimation(slideDown);
        } else {
            holder.expandLayout.setVisibility(View.GONE);
        }
    }


    @Override
    public int getItemCount() {
        try {
            return requestListFilter.size();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {

                String key = charSequence.toString().toLowerCase();
                if (key.isEmpty()) {
                    requestListFilter = requestList;
                } else {
                    List<MyRequestModel> newList = new ArrayList<>();
                    for (MyRequestModel row : requestList){
                        if(row.getPersonJob().toLowerCase().contains(key) ||row.getServicePersonName().toLowerCase().contains(key)
                                ||row.getServiceDate().toLowerCase().contains(key) ||row.getPhoneNumber().toLowerCase().contains(key)){
                            newList.add(row);
                        }
                    }
                    requestListFilter = newList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = requestListFilter;
                return filterResults;

            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults results) {

                requestListFilter = (List<MyRequestModel>) results.values;
                notifyDataSetChanged();

            }
        };
    }

    class MyRequestDetailsViewHolder extends RecyclerView.ViewHolder{

        private TextView servicePersonName, phoneNumber, serviceCompany, serviceCategory, serviceDate, serviceUnit;
        RelativeLayout expandLayout;
        RelativeLayout headerLayout;
        ImageView callResident, directPass;
        Button allow, reject;



        MyRequestDetailsViewHolder(View itemView) {
            super(itemView);
            servicePersonName = itemView.findViewById(R.id.serviceProviderName);
            phoneNumber = itemView.findViewById(R.id.serviceProviderNumber);
            serviceCompany = itemView.findViewById(R.id.serviceProviderLtd);
            headerLayout = itemView.findViewById(R.id.headerLayout);
            expandLayout = itemView.findViewById(R.id.expandLayout);
            serviceCategory = itemView.findViewById(R.id.requestCategory);
            serviceDate = itemView.findViewById(R.id.requestDate);
            serviceUnit = itemView.findViewById(R.id.unitNo);
            callResident = itemView.findViewById(R.id.call);
            directPass = itemView.findViewById(R.id.goDirect);
            allow = itemView.findViewById(R.id.allowBtn);
            reject = itemView.findViewById(R.id.rejectBtn);

        }
       private void setServicePersonName(String name) {
            servicePersonName.setText(name);
        }

        private void setPhoneNumber(String number) {
            phoneNumber.setText(number);
        }

        private void setServiceCompany(String company) {
            serviceCompany.setText(company);
        }
        private void setServiceCategory(String serviceCategory) {
            this.serviceCategory.setText(serviceCategory);
        }

        private void setServiceDate(String serviceDate) {
            this.serviceDate.setText(serviceDate);
        }

        private void setServiceUnit(String serviceUnit) {
            this.serviceUnit.setText(serviceUnit);
        }
    }
}

package net.innovexit.brindavan.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import net.innovexit.brindavan.R;
import net.innovexit.brindavan.models.RequestDetailsModel;
import net.innovexit.brindavan.models.RequestListModel;
import net.innovexit.brindavan.viewholders.RequestDetailsViewHolder;
import net.innovexit.brindavan.viewholders.RequestItemViewHoder;

import java.util.List;

public class RequestItemAdapter extends ExpandableRecyclerViewAdapter<RequestItemViewHoder, RequestDetailsViewHolder> {



    public RequestItemAdapter(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public RequestItemViewHoder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_list_item, parent,false);
        return new RequestItemViewHoder(view);
    }

    @Override
    public RequestDetailsViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.request_details_item, parent,false);
        return new RequestDetailsViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(RequestDetailsViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        RequestDetailsModel requestDetailsModel = (RequestDetailsModel) group.getItems().get(childIndex);

        holder.setServicePersonName(requestDetailsModel.getServicePersonName());
        holder.setPersonJob(requestDetailsModel.getPersonJob());
        holder.setPhoneNumber(requestDetailsModel.getPhoneNumber());
        holder.setServiceCompany(requestDetailsModel.getServiceCompany());

    }

    @Override
    public void onBindGroupViewHolder(RequestItemViewHoder holder, int flatPosition, ExpandableGroup group) {
        holder.setRequestType(group.getTitle());

    }
}

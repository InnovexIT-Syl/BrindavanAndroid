package net.innovexit.brindavan.models;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;


public class RequestListModel extends ExpandableGroup {

    private String type, date, unitFor;

    public String getType() {
        return type;
    }

    public void setName(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnitFor() {
        return unitFor;
    }

    public void setUnitFor(String unitFor) {
        this.unitFor = unitFor;
    }

    public RequestListModel(String type,List items) {

        super(type,items);

    }
}

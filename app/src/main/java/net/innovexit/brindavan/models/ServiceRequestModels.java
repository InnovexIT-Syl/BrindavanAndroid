package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceRequestModels implements Serializable {

    private String correspondingname;
    private String phone;
    private String requesteddate;
    private String requirenotificationonentry;
    private String servicerequesttype;
    private String unitnum;
    private String deliverytype;
    private String delverynote;
    private String adhocvisitorphoto;
    private int complexid;
    private String enddate;
    private String notes_instructions;
    private int requesterid;
    private String requestertype;
    private int serviceprovider_requestnumber;
    private int serviceproviderid;
    private int servicerequestormemberuserid;
    private String startdate;
    private boolean suspend;
    private boolean terminate;


    public ServiceRequestModels(String correspondingname, String phone, String requesteddate,
                                String requirenotificationonentry, String servicerequesttype,
                                String unitnum, String deliverytype, String delverynote,
                                String adhocvisitorphoto, int complexid, String enddate,
                                String notes_instructions, int requesterid, String requestertype,
                                int serviceprovider_requestnumber,
                                int serviceproviderid, int servicerequestormemberuserid,
                                String startdate, boolean suspend, boolean terminate) {
        this.correspondingname = correspondingname;
        this.phone = phone;
        this.requesteddate = requesteddate;
        this.requirenotificationonentry = requirenotificationonentry;
        this.servicerequesttype = servicerequesttype;
        this.unitnum = unitnum;
        this.deliverytype = deliverytype;
        this.delverynote = delverynote;
        this.adhocvisitorphoto = adhocvisitorphoto;
        this.complexid = complexid;
        this.enddate = enddate;
        this.notes_instructions = notes_instructions;
        this.requesterid = requesterid;
        this.requestertype = requestertype;
        this.serviceprovider_requestnumber = serviceprovider_requestnumber;
        this.serviceproviderid = serviceproviderid;
        this.servicerequestormemberuserid = servicerequestormemberuserid;
        this.startdate = startdate;
        this.suspend = suspend;
        this.terminate = terminate;
    }

    public String getCorrespondingname() {
        return correspondingname;
    }

    public String getPhone() {
        return phone;
    }

    public String getRequesteddate() {
        return requesteddate;
    }

    public String getRequirenotificationonentry() {
        return requirenotificationonentry;
    }

    public String getServicerequesttype() {
        return servicerequesttype;
    }

    public String getUnitnum() {
        return unitnum;
    }

    public String getDeliverytype() {
        return deliverytype;
    }

    public String getDelverynote() {
        return delverynote;
    }

    public String getAdhocvisitorphoto() {
        return adhocvisitorphoto;
    }

    public int getComplexid() {
        return complexid;
    }

    public String getEnddate() {
        return enddate;
    }

    public String getNotes_instructions() {
        return notes_instructions;
    }

    public int getRequesterid() {
        return requesterid;
    }

    public String getRequestertype() {
        return requestertype;
    }

    public int getServiceprovider_requestnumber() {
        return serviceprovider_requestnumber;
    }

    public int getServiceproviderid() {
        return serviceproviderid;
    }

    public int getServicerequestormemberuserid() {
        return servicerequestormemberuserid;
    }

    public String getStartdate() {
        return startdate;
    }

    public boolean getSuspend() {
        return suspend;
    }

    public boolean getTerminate() {
        return terminate;
    }

}
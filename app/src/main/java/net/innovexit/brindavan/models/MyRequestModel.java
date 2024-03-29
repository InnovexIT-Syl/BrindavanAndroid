package net.innovexit.brindavan.models;

import com.google.firebase.firestore.DocumentReference;

public class MyRequestModel {

    private String servicePersonName, personJob, phoneNumber, accessType, serviceDate,serviceUnit,startDate,
            endDate;
    private DocumentReference docRef;
    String isSuspend;

    public DocumentReference getDocRef() {
        return docRef;
    }

    public void setDocRef(DocumentReference docRef) {
        this.docRef = docRef;
    }

    public String isSuspend() {
        return isSuspend;
    }

    public void setSuspend(String suspend) {
        isSuspend = suspend;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }



    public MyRequestModel(String servicePersonName, String personJob, String phoneNumber,
                          String accessType, String serviceUnit, String serviceDate,
                          DocumentReference docRef, String isSuspend, String startDate,
                          String endDate) {
        this.servicePersonName = servicePersonName;
        this.personJob = personJob;
        this.phoneNumber = phoneNumber;
        this.accessType = accessType;
        this.serviceUnit = serviceUnit;
        this.serviceDate = serviceDate;
        this.docRef = docRef;
        this.isSuspend = isSuspend;
        this.startDate = startDate;
        this.endDate = endDate;
    }


    public String getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(String serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public String getServicePersonName() {
        return servicePersonName;
    }

    public void setServicePersonName(String servicePersonName) {
        this.servicePersonName = servicePersonName;
    }

    public String getPersonJob() {
        return personJob;
    }

    public void setPersonJob(String personJob) {
        this.personJob = personJob;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAccessType() {
        return accessType;
    }

    public void setAccessType(String accessType) {
        this.accessType = accessType;
    }
}

package net.innovexit.brindavan.models;

public class MyRequestModel {

    private String servicePersonName, personJob, phoneNumber, accessType, serviceDate, serviceUnit;

    public MyRequestModel(String servicePersonName, String personJob, String phoneNumber, String accessType, String serviceDate, String serviceUnit) {
        this.servicePersonName = servicePersonName;
        this.personJob = personJob;
        this.phoneNumber = phoneNumber;
        this.accessType = accessType;
        this.serviceDate = serviceDate;
        this.serviceUnit = serviceUnit;
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

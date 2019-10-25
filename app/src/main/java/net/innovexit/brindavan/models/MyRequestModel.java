package net.innovexit.brindavan.models;

public class MyRequestModel {

    private String servicePersonName, personJob, phoneNumber, serviceCompany;

    public MyRequestModel(String servicePersonName, String personJob, String phoneNumber, String serviceCompany) {
        this.servicePersonName = servicePersonName;
        this.personJob = personJob;
        this.phoneNumber = phoneNumber;
        this.serviceCompany = serviceCompany;
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

    public String getServiceCompany() {
        return serviceCompany;
    }

    public void setServiceCompany(String serviceCompany) {
        this.serviceCompany = serviceCompany;
    }
}

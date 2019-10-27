package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceRequestModels implements Serializable {

    private String name, phoneNumber, others, accessType, serviceType, currentDate;

    public ServiceRequestModels() {

    }

    public ServiceRequestModels(String name, String phoneNumber, String serviceType, String accessType, String others, String currentDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.accessType = accessType;
        this.others = others;
        this.currentDate = currentDate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getOthers() {
        return others;
    }

    public String getAccessType() {
        return accessType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getCurrentDate() {
        return currentDate;
    }
}

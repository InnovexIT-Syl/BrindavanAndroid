package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceRequestModels implements Serializable {

    private String name, phoneNumber,  accessType, serviceType, unitNo, currentDate;

    public ServiceRequestModels() {

    }

    public ServiceRequestModels(String name, String phoneNumber, String serviceType, String accessType, String unitNo, String currentDate) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.accessType = accessType;
        this.unitNo = unitNo;
        this.currentDate = currentDate;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUnitNo() {
        return unitNo;
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

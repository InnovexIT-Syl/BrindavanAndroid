package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceRequestModels implements Serializable {

    private String name, phoneNumber, address, serviceProviderName,residentName,serviceType,workingExperience;

    public ServiceRequestModels() {

    }

    public ServiceRequestModels(String name, String phoneNumber, String address, String serviceProviderName, String residentName, String serviceType, String workingExperience) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.serviceProviderName = serviceProviderName;
        this.residentName = residentName;
        this.serviceType = serviceType;
        this.workingExperience = workingExperience;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getServiceProviderName() {
        return serviceProviderName;
    }

    public String getResidentName() {
        return residentName;
    }

    public String getServiceType() {
        return serviceType;
    }

    public String getWorkingExperience() {
        return workingExperience;
    }
}

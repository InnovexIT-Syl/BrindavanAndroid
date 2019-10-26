package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceProviderModels implements Serializable {

    private String name, phoneNumber, address, workingExperience;

    public ServiceProviderModels() {

    }

    public ServiceProviderModels(String name, String phoneNumber, String address, String workingExperience) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
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

    public String getWorkingExperience() {
        return workingExperience;
    }
}

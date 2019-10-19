package net.innovexit.brindavan.Models;

import java.io.Serializable;

public class ServiceProvider implements Serializable {

    private String name, phoneNumber, address, workingExperience;

    public ServiceProvider() {

    }

    public ServiceProvider(String name, String phoneNumber, String address, String workingExperience) {
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

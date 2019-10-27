package net.innovexit.brindavan.models;

import java.io.Serializable;

public class ServiceRequestModels implements Serializable {

    private String name, phoneNumber, others, accessType,serviceType;

    public ServiceRequestModels() {

    }

    public ServiceRequestModels(String name, String phoneNumber, String serviceType,String accessType,String others) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.serviceType = serviceType;
        this.accessType = accessType;
        this.others = others;
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
}

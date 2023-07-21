package com.automation.training.util.drivers.enums;

public enum DeviceType {

    ANDROID("ANDROID"),
    IOS("IOS");

    DeviceType(String device) {
        this.deviceType = device;
    }

    private String deviceType;
    public String getDevice(){
        return deviceType;
    }




}

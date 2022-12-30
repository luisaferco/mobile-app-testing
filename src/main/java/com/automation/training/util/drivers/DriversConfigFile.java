package com.automation.training.util.drivers;


import com.automation.training.exceptions.NotFoundValueException;

import java.util.Arrays;

public enum DriversConfigFile {

    IOS_FILE("iOS","ios.properties"),
    ANDROID_FILE("Android","android.properties");

    private final String platform;
    private final String fileName;


    DriversConfigFile(String platform,String fileName){
        this.platform = platform;
        this.fileName = fileName;
    }

    public String getPlatform() {
        return platform;
    }

    public String getFileName() {
        return fileName;
    }

    public static String getFileNameCalled(String platform){
        return Arrays.stream(DriversConfigFile.values())
                .filter(driversConfigFile -> driversConfigFile.platform.equals(platform))
                .findFirst()
                .orElseThrow(() -> new NotFoundValueException("config file related to " + platform + "platform not found"))
                .getFileName();
    }

}

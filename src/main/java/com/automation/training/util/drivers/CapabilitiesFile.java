package com.automation.training.util.drivers;


import com.automation.training.exceptions.NotFoundValueException;

import java.util.Arrays;

public enum CapabilitiesFile {

    IOS_FILE("iOS","ios.properties"),
    ANDROID_FILE("Android","android.properties");

    private final String platform;
    private final String fileName;


    CapabilitiesFile(String platform, String fileName){
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
        return Arrays.stream(CapabilitiesFile.values())
                .filter(driversConfigFile -> driversConfigFile.platform.equals(platform))
                .findFirst()
                .orElseThrow(() -> new NotFoundValueException(String.format("config file related to %s platform not found", platform)))
                .getFileName();
    }

}

package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * MobileDriverFactory class to create a new mobile driver
 * whether config capabilities provides Android connection or
 * iOs connection
 * Android is selected by default
 */
public class MobileDriverFactory extends ConfigCapabilities {

    public MobileDriverFactory(){
        super();
    }

    /**
     * get a new driver instance
     * @param config : AppiumConfig
     * @return AppiumDriver
     */
    public AppiumDriver getDriver(AppiumConfig config){
        AppiumServerAddress address = new AppiumServerAddress(config.host(), config.port());
        address.setAddress();
        DesiredCapabilities capabilities = super.uploadCapabilities(config.platformName());
        return MobileType.valueOf(config.platformName().toUpperCase()).setDriver(address, capabilities);
    }
}


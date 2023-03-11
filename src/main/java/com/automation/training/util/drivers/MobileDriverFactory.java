package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Get driver whether environment variable has been configured.
 * Android is selected by default
 * @param: PlatformName
 */
public class MobileDriverFactory extends ConfigCapabilities {

    public MobileDriverFactory(){
        super();
    }

    public AppiumDriver<?> getDriver(AppiumConfig config){
        AppiumServerAddress address = new AppiumServerAddress(config.host(), config.port());
        address.setAddress();
        DesiredCapabilities capabilities = super.uploadCapabilities(config.platformName());
        return MobileType.valueOf(config.platformName().toUpperCase()).setDriver(address, capabilities);
    }
}


package com.automation.training.util.env;

import com.automation.training.util.drivers.AppiumServerAddress;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public interface Device {

    void setCapabilities(DesiredCapabilities capabilities);
    void setRemoteAddres(AppiumServerAddress address);
    AppiumDriver getDriver();
    void tearDownDriver();
}

package com.automation.training.util.drivers;

import com.automation.training.util.drivers.enums.DeviceType;
import com.automation.training.util.drivers.enums.MobileDriverType;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * MobileDriverFactory class to create a new mobile driver
 * whether config capabilities provides Android or
 * iOs driver
 */
public class MobileDriverFactory  {


    private final DeviceType deviceType;

    public MobileDriverFactory(DeviceType deviceType) {
        this.deviceType = deviceType;
    }
    /**
     * get a new driver instance
     * @param address : AppiumServer,
     * @param desiredCapabilities: DesiredCapabilities
     * @return AppiumDriver
     */
    public AppiumDriver configureDriver(AppiumServer address, DesiredCapabilities desiredCapabilities){
        return MobileDriverType.valueOf(deviceType.getDevice().toUpperCase())
                .setDriver(address, desiredCapabilities);
    }
}


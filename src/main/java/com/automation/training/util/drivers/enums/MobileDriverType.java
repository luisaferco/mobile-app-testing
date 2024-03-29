package com.automation.training.util.drivers.enums;

import com.automation.training.util.drivers.AppiumServer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum MobileDriverType {

    ANDROID {
        @Override
        public AndroidDriver setDriver(AppiumServer address, DesiredCapabilities desiredCapabilities) {
            return new AndroidDriver(address.getRemoteAddress(), desiredCapabilities);
            }
        },
    IOS {
        @Override
        public IOSDriver setDriver(AppiumServer address, DesiredCapabilities desiredCapabilities) {
            return new IOSDriver(address.getRemoteAddress(), desiredCapabilities);
        }
    };

    public abstract AppiumDriver setDriver(AppiumServer address, DesiredCapabilities desiredCapabilities);
}

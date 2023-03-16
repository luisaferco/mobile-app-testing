package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum MobileType {

    ANDROID {
        @Override
        public AndroidDriver setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities) {
            return new AndroidDriver(address.getRemoteAddress(), desiredCapabilities);
            }
        },
    IOS {
        @Override
        public IOSDriver setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities) {
            return new IOSDriver(address.getRemoteAddress(), desiredCapabilities);
        }
    };

    public abstract AppiumDriver setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities);
}

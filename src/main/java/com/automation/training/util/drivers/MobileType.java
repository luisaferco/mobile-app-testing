package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public enum MobileType {

    ANDROID {
        @Override
        public AndroidDriver<AndroidElement> setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities) {
            return new AndroidDriver<AndroidElement>(address.getRemoteAddress(), desiredCapabilities);
            }
        },
    IOS {
        @Override
        public IOSDriver<IOSElement> setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities) {
            return new IOSDriver<IOSElement>(address.getRemoteAddress(), desiredCapabilities);
        }
    };

    public abstract AppiumDriver<?> setDriver(AppiumServerAddress address, DesiredCapabilities desiredCapabilities);
}

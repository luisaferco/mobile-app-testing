package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobilePlatform;

/**
 * Get driver whether environment variable has been configured.
 * Android is selected by default
 * @param: PlatformName
 */
public class MobileDriverFactory extends ConfigCapabilities {

    private MobileDriverFactory(String platformName){
        super(platformName);
    }

    public static MobileDriverFactory getInstanceFactory(){
        return new MobileDriverFactory(MobilePlatform.ANDROID);
    }

    public AppiumDriver<?> getDriver(){
        AppiumServerAddress serverAddress = new AppiumServerAddress();
        serverAddress.setAddress();
        return new AndroidDriver<AndroidElement>(serverAddress.getRemoteAddress(), super.uploadCapabilities());
    }
}

/*enum MobileDriver {

    ANDROID("Android",(address) -> {
            return new AndroidDriver<AndroidElement>(address.getRemoteAddress());
    }),
    IOS ("iOS",(AppiumServerAddress address, DesiredCapabilities desiredCapabilities) ->
            new IOSDriver<IOSElement>(address.getRemoteAddress(),desiredCapabilities);
    );

enum MobileDriver {

    ANDROID {
        @Override
        public AndroidDriver<AndroidElement> setDriver(){
            return SetAndroidDriver.getInstance().createDriver();
        }
    },
    IOS {
        @Override
        public IOSDriver<IOSElement> setDriver(){
            return null;
        }
    };


 */

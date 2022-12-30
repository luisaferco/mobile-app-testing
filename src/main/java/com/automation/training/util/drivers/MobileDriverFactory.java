package com.automation.training.util.drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobilePlatform;

/**
 * Get driver whether environment variable has been configured.
 * Android is selected by default
 * @param: PlatformName
 */
public class MobileDriverFactory {

    private String platformName;
    private static MobileDriverFactory instance;
    public static AndroidDriver<AndroidElement> androidDriver;

    private MobileDriverFactory(){
        this.platformName = getPlaform();
    }

    public static MobileDriverFactory getInstance(){
        if (instance == null) {
            instance = new MobileDriverFactory();
        }
        return instance;
    }


    public AppiumDriver<?> getDriver(){
       MobileDriver.ANDROID.setDriver();
        return androidDriver;
    }

    private String getPlaform() {
        return System.getenv("platform.name").equals("Android")? MobilePlatform.ANDROID : MobilePlatform.IOS;
    }

    public void quit(){
        if(instance !=null){
            if(androidDriver != null) {
                androidDriver.quit();
            }
        }
    }
}

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


    public abstract AppiumDriver<?> setDriver();

}
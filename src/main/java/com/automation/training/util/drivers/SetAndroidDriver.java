package com.automation.training.util.drivers;

import com.automation.training.exceptions.FailedDriverCreationException;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

import static com.automation.training.exceptions.FailedDriverCreationException.FAILED_DRIVER_CREATION;


public class SetAndroidDriver extends ConfigCapabilities implements DriverBase<AndroidDriver>{

    private DesiredCapabilities capabilities;
    public AndroidDriver<AndroidElement> driver;
    SetAndroidDriver() {
        super(MobilePlatform.ANDROID);
    }

    public static SetAndroidDriver getInstance(){
        return new SetAndroidDriver();
    }

    @Override
    public AndroidDriver<AndroidElement> createDriver()  {
            if (capabilities == null) {
                loadCapabilities();
            try {
                URL url = new URL("http://127.0.0.1:4723/wd/hub");
                this.driver = new AndroidDriver<AndroidElement>(url, capabilities);
            } catch ( Exception e) {
               throw new FailedDriverCreationException(FAILED_DRIVER_CREATION + e.getMessage());
            }
        }
        return driver;
    }


    @Override
    public void loadCapabilities() {
        capabilities = super.uploadCapabilities();
    }

}

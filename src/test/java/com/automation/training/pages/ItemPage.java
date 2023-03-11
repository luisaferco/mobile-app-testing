package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.Set;

public class ItemPage extends BasePage<AppiumDriver<MobileElement>> {

    private static final String WEB_VIEW = "android.webkit.WebView";

    @AndroidFindBy(className="android.view.View")
    private MobileElement resultDetailsTitle;

    public ItemPage(AppiumDriver<?> driver) {
        super(driver);
    }

    public String getResultsTitleSelected(){
        return resultDetailsTitle.getText();
    }

    public void switchContext() {
        Set<String> contextHandles = getDriver().getContextHandles();
        getDriver().context(WEB_VIEW);
    }

}

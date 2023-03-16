package com.automation.training.pageobject.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;

public class ItemPage extends BasePage<AppiumDriver> {

    private static final String WEB_VIEW = "android.webkit.WebView";

    @AndroidFindBy(className="android.view.View")
    private WebElement resultDetailsTitle;

    public ItemPage(AppiumDriver driver) {
        super(driver);
    }

    public String getResultsTitleSelected(){
        wait.until(ExpectedConditions.visibilityOf(resultDetailsTitle));
        return resultDetailsTitle.getText();
    }

    public void switchContext() {
        Set<String> contextHandles = ((SupportsContextSwitching) driver).getContextHandles();

    }

}

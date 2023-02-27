package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ItemPage extends BasePage<AndroidDriver<AndroidElement>> {

    @AndroidFindBy(id="pcs-edit-section-title-description")
    private WebElement resultDetailsTitle;

    public ItemPage(AppiumDriver<?> driver) {
        super(driver);
    }

    public String getResultsTitleSelected(){
        return resultDetailsTitle.getText();
    }
}

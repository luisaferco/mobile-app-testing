package com.automation.training.screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import com.automation.training.pages.BasePage;


/**
 * Object of the first screen that appears when we open the application.
 *
 * @author Arley.Bolivar
 */

public class WikiHomePage<T> extends BasePage {


    public WikiHomePage(AppiumDriver<?> driver) {
        super(driver);
    }

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(uiAutomator = "")
    private AndroidElement userNameTxt;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(uiAutomator = "")
    private AndroidElement passwordTxt;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(uiAutomator = "")
    private AndroidElement signInButton;

    @iOSXCUITFindBy(accessibility = "")
    @AndroidFindBy(uiAutomator = "")
    private AndroidElement acceptPermissions;


    public void checkPermissions() {
        click(acceptPermissions);
    }


    public void loginIn(String userName, String password) {
        userNameTxt.sendKeys(userName);
        passwordTxt.sendKeys();
        click(signInButton);

    }
}

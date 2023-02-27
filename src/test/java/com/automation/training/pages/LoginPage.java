package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LoginPage extends BasePage<AndroidDriver<AndroidElement>> {


    public LoginPage(AppiumDriver<?> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.wikipedia:id/create_account_username")
    private AndroidElement userNameTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_password_input")
    private AndroidElement passwordTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_password_repeat")
    private AndroidElement passwordRepeatTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_email")
    private AndroidElement emailTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_submit_button")
    private AndroidElement submitButton;


    public WikiHomePage loginIn(String userName, String password, String email) {
        type(userNameTxt,userName);
        type(passwordTxt,password);
        type(passwordRepeatTxt,password);
        type(emailTxt,email);
        click(submitButton);
        return new WikiHomePage(getDriver());
    }
}

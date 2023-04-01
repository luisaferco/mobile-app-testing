package com.automation.training.pageobject.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage<AppiumDriver> {


    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "org.wikipedia:id/create_account_username")
    private WebElement userNameTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_password_input")
    private WebElement passwordTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_password_repeat")
    private WebElement passwordRepeatTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_email")
    private WebElement emailTxt;

    @AndroidFindBy(id = "org.wikipedia:id/create_account_submit_button")
    private WebElement submitButton;


    public WikiHomePage loginIn(String userName, String password, String email) {
        type(userNameTxt,userName);
        type(passwordTxt,password);
        type(passwordRepeatTxt,password);
        type(emailTxt,email);
        click(submitButton);
        return new WikiHomePage(getDriver());
    }
}

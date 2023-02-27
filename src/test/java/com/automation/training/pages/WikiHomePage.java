package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class WikiHomePage extends BasePage<AndroidDriver<AndroidElement>> {


    @AndroidFindBy(id = "org.wikipedia:id/menu_icon")
    private MobileElement menu;
    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement layoutSearch;

    @AndroidFindBy(id = "org.wikipedia:id/main_drawer_login_button")
    private MobileElement logInButton;

    public WikiHomePage(AppiumDriver<?> driver) {
        super(driver);
    }
    public SearchPage openSearch(){
        click(layoutSearch);
        return new SearchPage(getDriver());
    }

    public LoginPage goToLogIn(String option) {
        click(menu);
        click(logInButton);
        return new LoginPage(getDriver());
    }

}

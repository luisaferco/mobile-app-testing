package com.automation.training.pageobject.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class WikiHomePage extends BasePage<AppiumDriver> {


    @AndroidFindBy(id = "org.wikipedia:id/menu_icon")
    private WebElement menu;

    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement layoutSearch;

    @AndroidFindBy(id = "org.wikipedia:id/main_drawer_login_button")
    private WebElement logInButton;

    public WikiHomePage(AppiumDriver driver) {
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

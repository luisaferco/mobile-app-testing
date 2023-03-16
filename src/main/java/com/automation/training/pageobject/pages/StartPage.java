package com.automation.training.pageobject.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class StartPage extends BasePage<AppiumDriver> {

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_forward_button")
    private WebElement continueStartBtn;

    @AndroidFindBy(id = "org.wikipedia:id/acceptButton")
    private WebElement startBtn;

    public StartPage(AppiumDriver driver) {
        super(driver);
    }


    public WikiHomePage startWikiApp() {
        click(continueStartBtn);
        click(continueStartBtn);
        click(continueStartBtn);
        click(startBtn);
        return new WikiHomePage(getDriver());

    }



}

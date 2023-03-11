package com.automation.training.pages;

import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class StartPage extends BasePage<AppiumDriver<MobileElement>> {

    @AndroidFindBy(id = "org.wikipedia:id/fragment_onboarding_forward_button")
    private MobileElement continueStartBtn;

    @AndroidFindBy(id = "org.wikipedia:id/acceptButton")
    private MobileElement startBtn;

    public StartPage(AppiumDriver<?> driver) {
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

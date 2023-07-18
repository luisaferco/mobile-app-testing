package com.automation.training.tests;

import com.automation.training.pageobject.pages.StartPage;
import com.automation.training.pageobject.pages.WikiHomePage;
import com.automation.training.util.drivers.AppiumConfig;
import com.automation.training.util.drivers.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.testng.annotations.*;
import com.automation.training.pageobject.pages.LoginPage;

/**
 * Base Test suite
 * @author luisaferco
 */
public abstract class BaseMobileTest {

    private static LoginPage loginPage;
    private static WikiHomePage wikiHomePage;
    private static StartPage startPage;
    public static final Logger LOGGER = Logger.getLogger(BaseMobileTest.class);

    @BeforeSuite
    @Parameters({"conf"})
    public void setUpEnv(String config){

    }

    @BeforeMethod(alwaysRun = true)
    public void beforeMethod() {
       AppiumConfig config = ConfigFactory.create(AppiumConfig.class);
       MobileDriverFactory factory = new MobileDriverFactory();
       AppiumDriver driver = factory.getDriver(config);
       startPage = new StartPage(driver);
       loginPage = new LoginPage(driver);
       wikiHomePage = new WikiHomePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        wikiHomePage.dispose();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public StartPage getStartPage() {
        return startPage;
    }

    public WikiHomePage getWikiHomePage() {
        return wikiHomePage;
    }
}

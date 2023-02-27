package com.automation.training.tests;

import com.automation.training.pages.WikiHomePage;
import com.automation.training.util.drivers.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import com.automation.training.pages.LoginPage;
import org.testng.annotations.BeforeSuite;

/**
 * Base Test suite
 * @author luisaferco
 */
public abstract class BaseMobileTest {

    private LoginPage loginPage;
    private WikiHomePage wikiHomePage;
    public static final Logger LOGGER = Logger.getLogger(BaseMobileTest.class);


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
       MobileDriverFactory factory = MobileDriverFactory.getInstanceFactory();
       AppiumDriver<?> driver = factory.getDriver();
       loginPage = new LoginPage(driver);
       wikiHomePage = new WikiHomePage(driver);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        loginPage.dispose();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public WikiHomePage getWikiHomePage() {
        return wikiHomePage;
    }
}

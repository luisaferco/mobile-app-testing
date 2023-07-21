package com.automation.training.tests;

import com.automation.training.pageobject.pages.StartPage;
import com.automation.training.pageobject.pages.WikiHomePage;
import com.automation.training.util.drivers.MobileDriverFactory;
import com.automation.training.util.drivers.enums.DeviceType;
import com.automation.training.util.env.EnvironmentConfig;
import com.automation.training.util.env.ReadConfigFile;
import io.appium.java_client.AppiumDriver;
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
    private static EnvironmentConfig environment;
    public static final Logger LOGGER = Logger.getLogger(BaseMobileTest.class);

    @BeforeSuite
    @Parameters({"conf"})
    public void setUpEnv(String config){
        ReadConfigFile configFile = ReadConfigFile.getInstance(config);
        configFile.uploadProperties();
        environment = new EnvironmentConfig(configFile.getProperties());
        environment.setUp();

    }

    @BeforeMethod(alwaysRun = true)
    @Parameters({"platform"})
    public void beforeMethod(String platform) {
       MobileDriverFactory factory = new MobileDriverFactory(DeviceType.valueOf(platform));
       AppiumDriver driver = factory.configureDriver(environment.getAppiumServer(),environment.getDesiredCapabilities());
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

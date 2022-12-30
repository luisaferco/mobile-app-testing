package com.automation.training;

import com.automation.training.util.drivers.MobileDriverFactory;
import io.appium.java_client.AppiumDriver;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import com.automation.training.screens.WikiHomePage;
import org.testng.annotations.BeforeSuite;

/**
 * Base class for Test suite
 *
 * @author luisaferco
 */
public abstract class BaseMobileTest {

    protected WikiHomePage wikiHome;
    public Logger log = Logger.getLogger(BaseMobileTest.class);


    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
       MobileDriverFactory factory = MobileDriverFactory.getInstance();
        AppiumDriver<?> driver = factory.getDriver();
        wikiHome = new WikiHomePage(driver);
    }

    /**
     * Close app after running test
     *
     * @author luisaferco
     */
    @AfterTest(alwaysRun = true)
    public void endSuite() {
        wikiHome.quit();
    }

}

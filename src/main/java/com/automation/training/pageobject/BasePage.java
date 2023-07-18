package com.automation.training.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

/**
 * The BasePage abstract class contains overrides constructor and
 * provides the Appium Driver
 * @param <T> : MobileDriver
 * @author luisaferco
 */
public abstract class BasePage<T extends AppiumDriver> {

    private static final int TIMEOUT = 10;
    protected final AppiumDriver driver;
    protected WebDriverWait wait;


    public BasePage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(TIMEOUT));
        initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(1)), this);
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void dispose(){
        if(driver != null) {
            driver.quit();
        }
    }

    public void terminateApp(String packageName) {
        AndroidDriver driver1 = (AndroidDriver) getDriver();
        driver1.terminateApp(packageName);

    }

    /**
     *  custom click
     * @param element : WebElement
     */
    public void click(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    /**
     *  custom type
     * @param element : WebElement
     */
    public void type(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

}

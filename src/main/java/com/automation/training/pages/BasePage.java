package com.automation.training.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Base class for all pages
 *
 * @author luisaferco
 */

public abstract class BasePage<T extends AppiumDriver> {


    private static final int TIMEOUT = 10;
    protected final T driver;


    public BasePage(AppiumDriver<?> driver) {
        this.driver = (T) driver;
        initElements();
    }

    private void initElements() {
        PageFactory.initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    public T getDriver() {
        return (T) driver;
    }

    public void quit(){
        driver.quit();
    }

    /**
     *  custom click
     * @param element : AndroidElement
     * @author luisaferco
     */
    public void click(MobileElement element) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.click();
    }


}

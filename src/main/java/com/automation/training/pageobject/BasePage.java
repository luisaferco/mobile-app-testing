package com.automation.training.pageobject;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.openqa.selenium.support.PageFactory.initElements;


public abstract class BasePage<T extends AppiumDriver> {

    private static final int TIMEOUT = 10;
    protected final T driver;


    public BasePage(AppiumDriver<?> driver) {
        this.driver = (T) driver;
        initElements(new AppiumFieldDecorator(
                driver, Duration.ofSeconds(0)), this);
    }

    public T getDriver() {
        return (T) driver;
    }

    public void dispose(){
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

    public void type(MobileElement element, String text) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        wait.until(ExpectedConditions.visibilityOf(element));
        element.setValue(text);
    }

}

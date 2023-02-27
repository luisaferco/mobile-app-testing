package com.automation.training.pages;

import com.automation.training.exceptions.NotFoundValueException;
import com.automation.training.pageobject.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchPage extends BasePage<AndroidDriver<AndroidElement>> {

    @AndroidFindBy(id = "org.wikipedia:id/search_src_text")
    private AndroidElement searchField;

    @AndroidFindBy(id = "org.wikipedia:id/page_list_item_title")
    private List<MobileElement> searchResults;

    public SearchPage(AppiumDriver<?> driver) {
        super(driver);
    }

    public SearchPage search(final String text) {
        type(searchField, text);
        return this;
    }

    public List<String> getSearchResultsList() {
        return searchResults.stream().map(RemoteWebElement::getText)
                .collect(Collectors.toList());
    }

    public int getResultsSize() {
        return  searchResults.size();
    }

    public ItemPage getResultByIndex(final int index) {
        MobileElement itemResult = Optional.of(searchResults.get(index))
                .orElseThrow(() -> new NotFoundValueException(String.format("Expected return item [%s] but list is empty", index)));
        click(itemResult);
        return new ItemPage(getDriver());
    }
}

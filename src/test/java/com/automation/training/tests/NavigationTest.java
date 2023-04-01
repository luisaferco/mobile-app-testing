package com.automation.training.tests;

import com.automation.training.pageobject.pages.ItemPage;
import com.automation.training.pageobject.pages.SearchPage;
import com.automation.training.pageobject.pages.WikiHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.Arrays;

public class NavigationTest extends BaseMobileTest {


    @Test(description = "Search navigation test")
    @Parameters({"searchCriteria"})
    public void navigateToSearchPage(String searchCriteria) {
        WikiHomePage wikiHomePage = getWikiHomePage();
        SearchPage searchPage = wikiHomePage.openSearch().search(searchCriteria);
        Assert.assertTrue(searchPage.getResultsSize() > 0,
                "Expected that the search results contains some coincidences");
    }

    @Test(description = "Open search details from the result list")
    @Parameters({"searchCriteria"})
    public void navigateToSearchDetails(String searchCriteria) {
        WikiHomePage wikiHomePage = getWikiHomePage();
        SearchPage searchPage = wikiHomePage.openSearch().search(searchCriteria);
        ItemPage pageResult = searchPage.getResultByIndex(0);

        Arrays.stream(searchCriteria.split(" "))
            .forEach(word ->
                Assert.assertTrue(pageResult.getResultsTitleSelected().contains(word),
                       String.format("Expected that search result selected: %s contains search criteria: %s",
                               pageResult.getResultsTitleSelected(),
                               searchCriteria)
                        )
            );
    }


}

package com.automation.training.tests;

import com.automation.training.pages.ItemPage;
import com.automation.training.pages.SearchPage;
import com.automation.training.pages.WikiHomePage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
        Assert.assertTrue(pageResult.getResultsTitleSelected().contains(searchCriteria),
                "Expected that search result selected: " + pageResult.getResultsTitleSelected() + " contains search criteria: " + searchCriteria);
    }


}

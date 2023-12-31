package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SearchByParameterTest extends BaseTest {
    @Test
    public void searchByParameter() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        HeaderComponents headerComponents = new HeaderComponents();
        headerComponents.clickOnMagnifyingIcon();
        headerComponents.searchByParameter("AI");

        String currentURL = driver.getCurrentUrl();
        String expectedURL = "https://www.epam.com/search?q=AI";

        boolean areResultsPresent = driver.findElements(By.linkText("AI")).size() > 0;
        Assert.assertTrue(areResultsPresent, "Results are not present on the page");
        Assert.assertEquals(currentURL, expectedURL, "The URL does not match the expected URL");
    }
}



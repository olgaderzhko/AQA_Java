package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Derzhko.O
 */
public class SearchByParameterTest extends BaseTest {

    @Test
    public void searchByParameter() {
        MainPage mainPage = openApp();
        HeaderComponents headerComponents = new HeaderComponents();
        headerComponents.clickOnMagnifyingIcon();
        headerComponents.searchByParameter("AI");

        boolean areResultsPresent = driver.findElements(By.linkText("AI")).size() > 0;
        Assert.assertTrue(areResultsPresent, "Results are not present on the page");

    }
}

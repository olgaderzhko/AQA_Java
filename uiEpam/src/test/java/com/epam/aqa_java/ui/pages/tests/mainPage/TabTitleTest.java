package com.epam.aqa_java.ui.pages.tests.mainPage;

import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;



public class TabTitleTest extends BaseTest {
    @Test
    public void tabTitleCheck() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        MainPage mainPage = new MainPage();
        String actualTitle = mainPage.getTabTitle();
        String expectedTitle = "EPAM | Software Engineering & Product Development Services";
        Assert.assertEquals(actualTitle, expectedTitle, "The title of the page does not match the expected one.");
    }
}
package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends BaseTest {
    @Test
    public void changeLanguage() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        HeaderComponents headerComponents = new HeaderComponents();
        headerComponents.clickLanguageButton().selectUkrainianLanguage();

        MainPage mainPage = new MainPage();
        String expectedLanguageTitle = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        String actualLanguage = mainPage.getTabTitle();
        Assert.assertEquals(actualLanguage, expectedLanguageTitle, "The language has not been changed to Ukrainian");
    }
}

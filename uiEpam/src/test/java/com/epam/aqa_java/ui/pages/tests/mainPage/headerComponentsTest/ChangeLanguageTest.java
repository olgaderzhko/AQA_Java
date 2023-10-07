package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeLanguageTest extends BaseTest {

    @Test
    public void changeLanguage () throws InterruptedException {

        MainPage mainPage= openApp();
        HeaderComponents headerComponents = new HeaderComponents();
        headerComponents.clickLanguageButton().selectUkrainianLanguage();

        Thread.sleep(10000);
        String actualLanguage = mainPage.getTabTitle();
        System.out.println(actualLanguage);
        String expectedLanguage = "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії";
        Assert.assertEquals(actualLanguage, expectedLanguage, "The language has not been changed to Ukrainian");

    }
}

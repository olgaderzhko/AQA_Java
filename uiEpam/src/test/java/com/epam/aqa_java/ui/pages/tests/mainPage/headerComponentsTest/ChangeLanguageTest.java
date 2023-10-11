package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ChangeLanguageTest extends BaseTest {
    @Test
    public void changeLanguage() throws InterruptedException {
        MainPage mainPage = openApp();
        HeaderComponents headerComponents = new HeaderComponents();
        headerComponents.clickLanguageButton().selectUkrainianLanguage();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії"));

        String actualLanguage = mainPage.getTabTitle();
        Assert.assertEquals(actualLanguage, "EPAM Ukraine - найбільша ІТ-компанія в Україні | Вакансії", "The language has not been changed to Ukrainian");
    }
}

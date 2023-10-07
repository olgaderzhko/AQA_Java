package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToggleSwitchTest extends BaseTest {
    @Test
    public void toggleSwitch() throws InterruptedException {
        MainPage mainPage = openApp();
        HeaderComponents headerComponents = new HeaderComponents();

        headerComponents.themeSwitcher();

        String initialTheme = headerComponents.checkDisplayedTheme();
        Assert.assertEquals("Light mode is displayed", initialTheme);
    }
}
package com.epam.aqa_java.ui.pages.tests.mainPage.headerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.HeaderComponents;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ToggleSwitchTest extends BaseTest {
    @Test
    public void toggleSwitch(){
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        HeaderComponents headerComponents = new HeaderComponents();

        String initialTheme1 = headerComponents.checkDisplayedTheme();
        assertEquals("Dark mode is displayed", initialTheme1);


        headerComponents.themeSwitcherClick();
        String initialTheme2 = headerComponents.checkDisplayedTheme();
        assertEquals("Light mode is displayed", initialTheme2);


        headerComponents.themeSwitcherClick();
        String initialTheme3 = headerComponents.checkDisplayedTheme();
        assertEquals("Dark mode is displayed", initialTheme3);
    }
}

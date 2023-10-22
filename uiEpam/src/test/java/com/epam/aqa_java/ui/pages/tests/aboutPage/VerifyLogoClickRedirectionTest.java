package com.epam.aqa_java.ui.pages.tests.aboutPage;

import com.epam.aqa_java.ui.pages.aboutPage.AboutPage;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VerifyLogoClickRedirectionTest extends BaseTest {
    @Test
    public void verifyLogoClickRedirection() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openAboutPage();
        AboutPage aboutPage = new AboutPage();

        aboutPage.verifyLogoClickRedirection();

        String actualLink = driver.getCurrentUrl();
        String expectedLink = "https://www.epam.com/";

        if (!actualLink.equals(expectedLink)) {
            Assert.fail("Current page is not the expected homepage.");
        }
    }
}


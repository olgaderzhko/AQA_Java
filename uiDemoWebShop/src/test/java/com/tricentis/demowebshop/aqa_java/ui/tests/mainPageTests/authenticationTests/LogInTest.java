package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.authenticationTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logIn() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();
        pageHandler.openLoginPage();

        LoginPage loginPage = new LoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        Assert.assertTrue(loginPage.isUserLoggedIn(), "Login was unsuccessful. User is not logged in.");
    }
}

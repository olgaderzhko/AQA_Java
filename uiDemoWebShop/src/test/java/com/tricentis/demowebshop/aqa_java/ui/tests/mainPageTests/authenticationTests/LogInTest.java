package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.authenticationTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogInTest extends BaseTest {
    @Test
    public void logIn() throws InterruptedException {

        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        Assert.assertTrue(loginPage.isUserLoggedIn(), "The button in the form of the user's email is not displayed");
    }
}

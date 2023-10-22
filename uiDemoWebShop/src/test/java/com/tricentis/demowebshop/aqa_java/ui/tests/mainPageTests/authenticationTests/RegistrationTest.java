package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.authenticationTests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.RegistrationPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.UserEntity;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseTest {
    @Test
    private void registrationNewUser() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();
        pageHandler.openRegistrationPage();

        RegistrationPage registrationPage = new RegistrationPage();

        Faker faker = new Faker();
        UserEntity user = new UserEntity(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                "123456",
                "123456"
        );

        registrationPage.registerNewUser(user);
        Assert.assertTrue(registrationPage.isRegistrationCompletedMessageDisplayed(), "Registration completion message is not displayed.");
    }
}

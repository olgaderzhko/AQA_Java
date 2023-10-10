package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.authenticationTests;

import com.github.javafaker.Faker;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.MainPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.RegistrationPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.UserEntity;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Derzhko.O
 */
public class RegistrationTest extends BaseTest {
    @Test
    private void registrationNewUser() {
        RegistrationPage registrationPage = openApp().openRegistrationPage();
        registrationPage.clickOnRegistrationButton();

        Assert.assertTrue(registrationPage.isRegistrationPageLoaded(), "Registration page did not load as expected.");

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

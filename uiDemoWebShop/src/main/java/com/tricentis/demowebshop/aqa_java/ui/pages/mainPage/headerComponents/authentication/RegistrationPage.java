package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id, 'gender-male')]")
    private WebElement maleRadioButton;

    @FindBy(xpath = "//input[contains(@id, 'FirstName')]")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[contains(@id, 'LastName')]")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[contains(@id, 'Email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@id, 'Password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@id, 'ConfirmPassword')]")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//input[contains(@id, 'register-button')]")
    private WebElement confirmRegistrationButton;

    @FindBy(xpath = "//div[@class='result' and contains(text(), 'Your registration completed')]")
    private WebElement messageAboutSuccessRegistration;

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }


    public void registerNewUser(UserEntity info) {
        maleRadioButton.click();
        setFieldValue(firstNameInput, info.firstName);
        setFieldValue(lastNameInput, info.lastname);
        setFieldValue(emailInput, info.email);
        setFieldValue(passwordInput, info.password);
        setFieldValue(confirmPasswordInput, info.confirmPassword);

        confirmRegistrationButton.click();
        new RegistrationPage();
    }

    public boolean isRegistrationCompletedMessageDisplayed() {
        return messageAboutSuccessRegistration.isDisplayed();
    }
}
package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends BasePage {

    @FindBy(xpath = "//a[contains (@href, '/register')]")
    private WebElement registerButton;

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

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage clickOnRegistrationButton() {
        registerButton.click();
        return new RegistrationPage();
    }


    public boolean isRegistrationPageLoaded() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By loadingRegisterPage = By.xpath("//div[contains(@class, 'page registration-page')]");

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(loadingRegisterPage));
            if (!maleRadioButton.isDisplayed()) {
                return false;
            }
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public RegistrationPage registerNewUser(UserEntity info) {
        if (!isRegistrationPageLoaded()) {
            throw new RuntimeException("Registration page did not load as expected.");
        }
        maleRadioButton.click();
        setFieldValue(firstNameInput, info.firstName);
        setFieldValue(lastNameInput, info.lastname);
        setFieldValue(emailInput, info.email);
        setFieldValue(passwordInput, info.password);
        setFieldValue(confirmPasswordInput, info.confirmPassword);

        confirmRegistrationButton.click();

        return new RegistrationPage();
    }

    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
    public boolean isRegistrationCompletedMessageDisplayed() {
        By registrationCompletedMessageLocator = By.xpath("//div[@class='result' and contains(text(), 'Your registration completed')]");
        return isElementPresent(registrationCompletedMessageLocator);
    }

}

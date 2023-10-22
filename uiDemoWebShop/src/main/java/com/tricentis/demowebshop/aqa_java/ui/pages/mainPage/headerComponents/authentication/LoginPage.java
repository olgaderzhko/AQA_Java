package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class LoginPage extends BasePage {
    @FindBy(xpath = "//a[contains (@href, '/login')]")
    private WebElement loginButtonOnMainPage;

    @FindBy(xpath = "//input[contains(@id, 'Email')]")
    private WebElement emailInput;

    @FindBy(xpath = "//input[contains(@id, 'Password')]")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[contains(@class, 'button-1 login-button')]")
    private WebElement logInButtonOnWelcomeSigInPage;

    @FindBy(linkText = "Log out")
    private WebElement logOutButton;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public void userLogIn(String email, String password) {
        setFieldValue(emailInput, email);
        setFieldValue(passwordInput, password);

        logInButtonOnWelcomeSigInPage.click();
    }


    public boolean isUserLoggedIn() {
        return logOutButton.isDisplayed();
    }
}

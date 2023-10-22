package com.tricentis.demowebshop.aqa_java.ui.helpers;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;

public class LoginHelper extends BasePage {

    private final PageHandler pageHandler;

    public LoginHelper(PageHandler pageHandler) {
        this.pageHandler = pageHandler;
    }

    public void logInUser(String email, String password) {
        pageHandler.openMainPage();
        pageHandler.openLoginPage();
        new LoginPage().userLogIn(email, password);
    }
}

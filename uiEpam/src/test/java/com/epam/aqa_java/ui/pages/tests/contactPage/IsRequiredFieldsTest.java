package com.epam.aqa_java.ui.pages.tests.contactPage;

import com.epam.aqa_java.ui.pages.contactPage.ContactPage;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.annotations.Test;

public class IsRequiredFieldsTest extends BaseTest {

    @Test
    public void requiredFields(){
        MainPage mainPage = openApp();
        ContactPage contactPage = new MainPage().openContactPage().clickSubmitButton();

        assert contactPage.isFieldRequired(contactPage.firstName);
        assert contactPage.isFieldRequired(contactPage.lastName);
        assert contactPage.isFieldRequired(contactPage.email);
        assert contactPage.isFieldRequired(contactPage.phone);
        assert contactPage.isFieldRequired(contactPage.consentAgreement);
        assert contactPage.isFieldRequired(contactPage.epamHear);
    }
}
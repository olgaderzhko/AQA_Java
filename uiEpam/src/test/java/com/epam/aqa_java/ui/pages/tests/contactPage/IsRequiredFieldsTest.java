package com.epam.aqa_java.ui.pages.tests.contactPage;


import com.epam.aqa_java.ui.pages.contactPage.ContactPage;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.annotations.Test;

public class IsRequiredFieldsTest extends BaseTest {

    @Test
    public void requiredFields() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openContactPage();

        ContactPage contactPage = new ContactPage().clickSubmitButton();
        assert contactPage.isFieldRequired(contactPage.requiredDropDown) : "'Select the Reason'- drop-down should be required.";
        assert contactPage.isFieldRequired(contactPage.requiredMessageForFirstName) : "First Name field should be required.";
        assert contactPage.isFieldRequired(contactPage.requiredMessageForLastName) : "Last Name field should be required.";
        assert contactPage.isFieldRequired(contactPage.requiredMessageForEmail) : "Email field should be required.";
        assert contactPage.isFieldRequired(contactPage.requiredMessageForPhone) : "Phone field should be required.";
        assert contactPage.isFieldRequired(contactPage.consentCheckBox) : "Consent Agreement field should be required.";
        assert contactPage.isFieldRequired(contactPage.epamHear) : "EPAM Hear field should be required.";
    }
}
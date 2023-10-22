package com.epam.aqa_java.ui.pages.contactPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContactPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'button-ui')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class='dropdown-list-ui'][@data-required='true']")
    public WebElement requiredDropDown;

    @FindBy(xpath = "//div[@data-constraint-msg='First name should be less than 50 characters']")
    public WebElement requiredMessageForFirstName;

    @FindBy(xpath = "//div[@data-constraint-msg='Last name should be less than 50 characters']")
    public WebElement requiredMessageForLastName;

    @FindBy(xpath = "//div[@data-constraint-msg='Incorrect email format']")
    public WebElement requiredMessageForEmail;

    @FindBy(xpath = "//div[@data-constraint-msg='Only digits, space, plus, and semicolon are allowed. Maximum number of characters is 50.']")
    public WebElement requiredMessageForPhone;

    @FindBy(xpath = "(//div[@class='dropdown-list'])[3]//div[@data-required-msg='This is a required field']")
    public WebElement epamHear;

    @FindBy(name = "gdprConsent")
    public WebElement consentCheckBox;

    public ContactPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isFieldRequired(WebElement fieldElement) {
        String dataRequired = fieldElement.getAttribute("data-required");
        String ariaRequired = fieldElement.getAttribute("aria-required");
        return "true".equals(dataRequired) || "true".equals(ariaRequired);
    }


        public ContactPage clickSubmitButton() {
            ((JavascriptExecutor) driver).executeScript("window.scrollTo({\n" +
                    "    top: arguments[0].getBoundingClientRect().top -\n" +
                    "        document.body.getBoundingClientRect().top -\n" +
                    "        100\n" +
                    "})", buttonSubmit);

            buttonSubmit.click();
            return this;
        }

}
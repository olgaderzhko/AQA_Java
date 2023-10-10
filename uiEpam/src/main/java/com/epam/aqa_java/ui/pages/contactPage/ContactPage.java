package com.epam.aqa_java.ui.pages.contactPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Arrays;

/**
 * @author Derzhko.O
 */
public class ContactPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'button-ui')]")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//div[@class = 'colctrl__holder']//div[@class = 'text-field-ui validation-field']")
    public WebElement firstName;

    @FindBy(xpath = "//div[@class = 'colctrl__holder']//div[@data-constraint-msg = 'Last name should be less than 50 characters'] ")
    public WebElement lastName;

    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/section/div[3]/div[6]/div/form/div[2]/div/div/div/div/div[3]/div/div[1]/div/div/div")
    public WebElement email;

    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/section/div[3]/div[6]/div/form/div[2]/div/div/div/div/div[3]/div/div[2]/div/div/div")
    public WebElement phone;

    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/section/div[3]/div[6]/div/form/div[2]/div/div/div/div/div[8]/div[1]")
    public WebElement epamHear;

    @FindBy(xpath = "/html/body/div[2]/main/div[1]/div[2]/section/div[3]/div[6]/div/form/div[2]/div/div/div/div/div[9]/div/div[2]")
    public WebElement consentAgreement;

    public ContactPage () {
        PageFactory.initElements(driver, this);
    }

    public boolean isFieldRequired(WebElement fieldElement) {
        return Arrays.stream(fieldElement.getAttribute("class").split(" ")).anyMatch((s) -> s.equals("validation-field"));
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

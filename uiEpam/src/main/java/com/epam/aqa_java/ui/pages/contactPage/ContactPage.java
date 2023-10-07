package com.epam.aqa_java.ui.pages.contactPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * @author Derzhko.O
 */
public class ContactPage extends BasePage {

    @FindBy(xpath = "//button[contains(@class, 'button-ui')]")
    private WebElement buttonSubmit;

    public ContactPage () {
        PageFactory.initElements(driver, this);
    }

    public boolean isFieldRequired(WebElement fieldElement) {
        WebElement labelElement = driver.findElement(By.cssSelector("label[for='" + fieldElement.getAttribute("id") + "']"));
        return labelElement.getText().contains("*");
    }


    public ContactPage clickSubmitButton() {
        buttonSubmit.click();
        return this;
    }
}

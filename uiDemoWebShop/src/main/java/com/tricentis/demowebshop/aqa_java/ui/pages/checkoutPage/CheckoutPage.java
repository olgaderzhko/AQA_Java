package com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage;

import com.tricentis.demowebshop.aqa_java.ui.helpers.ScrollPageHelper;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

import static com.tricentis.demowebshop.aqa_java.ui.helpers.WaitHelper.waitForVisibilityOfElement;


public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'step-title')]/h2[text()='Billing address']")
    private WebElement billingAddressTitle;

    @FindBy(xpath = "//div[@id='billing-buttons-container']/input[contains(@title,'Continue')]")
    private WebElement continueButtonBillingAddressSection;

    @FindBy(xpath = "//input[@class='button-1 payment-method-next-step-button' and @value='Continue']")
    private WebElement continueButtonPaymentMethodSection;

    @FindBy(xpath = "//input[@class='button-1 payment-info-next-step-button' and @value='Continue']")
    private WebElement continueButtonPaymentInformationSection;

    @FindBy(xpath = "//input[@class='button-1 confirm-order-next-step-button' and @value='Confirm']")
    private WebElement confirmButton;

    @FindBy(xpath = "//div[@class='section payment-method']//ul[@class='method-list']")
    private WebElement paymentList;

    @FindBy(xpath = ".//input[@type='radio']")
    private List <WebElement>  radioButtonOnPaymentList;

    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }


    public void clickContinueForBillingAddress() {
            continueButtonBillingAddressSection.click();
    }

    public CheckoutPage choosePaymentMethod(String paymentMethodText) {
        waitForVisibilityOfElement(driver, paymentList);
        List<WebElement> radioButtons = radioButtonOnPaymentList;

        for (WebElement radioButton : radioButtons) {
            WebElement label = radioButton.findElement(By.xpath(".//following-sibling::label"));
            String labelText = label.getText();

            if (labelText.contains(paymentMethodText)) {
                radioButton.click();
                break;
            }
        }
        return this;
    }

    public void clickContinueForPaymentMethodSection() {
        continueButtonPaymentMethodSection.click();
    }
    public CheckoutPage clickContinueForPaymentInformationSection() {
        WebElement continueButton = continueButtonPaymentInformationSection;
        waitForVisibilityOfElement(driver, continueButton);

        if (continueButton.isDisplayed()) {
            continueButton.click();
        }

        return this;
    }


    public void clickContinueForConfirmOrderSection() {
        ScrollPageHelper scrollPageHelper = new ScrollPageHelper(driver);
        scrollPageHelper.scrollIntoView(confirmButton);

        waitForVisibilityOfElement(driver, confirmButton);

        confirmButton.click();
    }
}







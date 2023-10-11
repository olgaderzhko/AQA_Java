package com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


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

    @FindBy(xpath = "//div[@class='section order-completed']//strong[text()='Your order has been successfully processed!']")
    private WebElement successfullyOrderMessage;


    public CheckoutPage() {
        PageFactory.initElements(driver, this);
    }

    public CheckoutPage clickContinueFotBillingAddress() {
        if (billingAddressTitle.isDisplayed()) {
            continueButtonBillingAddressSection.click();
        } else {
            System.out.println("The 'Billing Address' section is not displayed or the 'Continue' button is not displayed.");
        }
        return this;
    }

    public CheckoutPage choosePaymentMethod(String paymentMethodText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement paymentMethodContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='section payment-method']//ul[@class='method-list']")));
        List<WebElement> radioButtons = paymentMethodContainer.findElements(By.xpath(".//input[@type='radio']"));

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


    public CheckoutPage clickContinueFotPaymentMethod() {
        continueButtonPaymentMethodSection.click();
        return this;
    }
    public CheckoutPage clickContinueForPaymentInformation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement continueButton = wait.until(ExpectedConditions.visibilityOf(continueButtonPaymentInformationSection));

        if (continueButton.isDisplayed()) {
            continueButton.click();
        } else {
            System.out.println("The 'Continue' button is not displayed.");
        }
        return this;
    }


    public CheckoutPage clickContinueForConfirmOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", confirmButton);

        WebElement continueButton = wait.until(ExpectedConditions.visibilityOf(confirmButton));

        if (continueButton.isDisplayed()) {
            continueButton.click();
        } else {
            System.out.println("The 'Continue' button is not displayed.");
        }
        return this;
    }
}






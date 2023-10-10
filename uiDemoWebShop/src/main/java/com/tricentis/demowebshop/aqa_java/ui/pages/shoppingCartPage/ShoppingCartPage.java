package com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage;

import com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage.CheckoutPage;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-links']//span[@class='cart-label' and text()='Shopping cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath= "//tr[@class='cart-item-row']//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//input[contains (@name, 'updatecart')]")
    private WebElement updateShoppingCartButton;

    @FindBy(xpath = "//div[contains(@class, 'order-summary-content') and contains(text(), 'Your Shopping Cart is empty!')]")
    private WebElement shoppingCartEmptyText;

    @FindBy(xpath = "//*[@id='termsofservice']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//div[contains (@class, 'checkout-buttons')]")
    private WebElement checkoutButton;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage clickOnShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartPage();
    }

    public boolean isCartEmpty() {
        if (shoppingCartEmptyText.isDisplayed()) {
            System.out.println("The basket is now empty! The product has been removed successfully!");
            return true;
        } else {
            return false;
        }
    }

    public ShoppingCartPage removeProductFromShoppingCart() {
            List<WebElement> productElements = driver.findElements(By.xpath("//td[@class='product'][1]"));
            if (productElements.size() > 0) {
                WebElement fistCheckbox = productElements.get(0);
                checkbox.click();
                updateShoppingCartButton.click();
            } else {
                System.out.println("No product were found to remove. The basket is empty");
            }
        return new ShoppingCartPage();
    }

    public ShoppingCartPage clickAgreeCheckout() {
        if (agreeCheckbox != null){
            agreeCheckbox.click();
        } else {
            System.out.println("Checkbox 'I agree with the terms' - doesn't found");
        }
        return this;
    }

    public CheckoutPage clickCheckoutButton() {
        if (checkoutButton != null){
            checkoutButton.click();
        } else {
            System.out.println("Checkout button not found");
        }
        return new CheckoutPage();
    }
}

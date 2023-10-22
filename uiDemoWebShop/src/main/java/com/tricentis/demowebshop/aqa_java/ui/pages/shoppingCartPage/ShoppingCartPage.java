package com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage;

import com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage.CheckoutPage;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage extends BasePage {

    @FindBy(xpath = "//div[@class='header-links']//span[@class='cart-label' and text()='Shopping cart']")
    private WebElement shoppingCartButton;

    @FindBy(xpath = "//tr[@class='cart-item-row']//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(xpath = "//input[contains (@name, 'updatecart')]")
    private WebElement updateShoppingCartButton;

    @FindBy(xpath = "//div[contains(@class, 'order-summary-content') and contains(text(), 'Your Shopping Cart is empty!')]")
    private WebElement shoppingCartEmptyText;

    @FindBy(xpath = "//*[@id='termsofservice']")
    private WebElement agreeCheckbox;

    @FindBy(xpath = "//div[contains (@class, 'checkout-buttons')]")
    private WebElement checkoutButton;

    @FindBy(xpath = "//td[@class='product'][1]")
    private List<WebElement> firstProductFromProductList;

    public ShoppingCartPage() {
        PageFactory.initElements(driver, this);
    }

    public ShoppingCartPage clickOnShoppingCartButton() {
        shoppingCartButton.click();
        return new ShoppingCartPage();
    }

    public boolean isCartEmpty() {
        return shoppingCartEmptyText.isDisplayed();
    }

    public void removeProductFromShoppingCart() {
        List<WebElement> productElements = firstProductFromProductList;
        if (productElements.size() > 0) {
            checkbox.click();
            updateShoppingCartButton.click();
        }
        new ShoppingCartPage();
    }


    public ShoppingCartPage clickAgreeCheckout() {
        if (agreeCheckbox != null) {
            agreeCheckbox.click();
        }
        return this;
    }

    public void clickCheckoutButton() {
        if (checkoutButton != null) {
            checkoutButton.click();
        }
        new CheckoutPage();
    }
}

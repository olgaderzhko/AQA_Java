package com.tricentis.demowebshop.aqa_java.ui.tests.checkoutPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage.CheckoutPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.MainPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage.ShoppingCartPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * @author Derzhko.O
 */
public class TestCheckoutProcess extends BaseTest {
    @Test
    private void testCheckoutProcess() throws InterruptedException {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        ProductCardPage productCardPage = openApp().openProductPage();
        productCardPage.clickDigitalDownloadsSideCategoryMenu().clickProductTitle().AddToCard();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnShoppingCartButton().clickAgreeCheckout().clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.clickContinueFotBillingAddress();

        checkoutPage.choosePaymentMethod("Check / Money Order (5.00)").clickContinueFotPaymentMethod();
        checkoutPage.clickContinueForPaymentInformation().clickContinueForConfirmOrder();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String successMessage = "Your order has been successfully processed!";
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), successMessage));

        Assert.assertTrue(driver.getPageSource().contains(successMessage), "The success message is not displayed.");

    }
}

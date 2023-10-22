package com.tricentis.demowebshop.aqa_java.ui.tests.checkoutPageTests;

import com.tricentis.demowebshop.aqa_java.ui.helpers.WaitHelper;
import com.tricentis.demowebshop.aqa_java.ui.pages.checkoutPage.CheckoutPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage.ShoppingCartPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class TestCheckoutProcess extends BaseTest {
    @Test

    //Оскільки  стараюсь, щоб тести не залежили одне від одного,тут йду і спочатку додаю продукт в кошик
    private void testCheckoutProcess(){
        PageHandler pageHandler = new PageHandler();
        pageHandler.openProductPage();

        ProductCardPage productCardPage = new ProductCardPage();
        productCardPage.clickDigitalDownloadsSideCategoryMenu().clickProductTitle().AddToCard();

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnShoppingCartButton().clickAgreeCheckout().clickCheckoutButton();

        CheckoutPage checkoutPage = new CheckoutPage();
        checkoutPage.clickContinueForBillingAddress();

        checkoutPage.choosePaymentMethod("Check / Money Order (5.00)").clickContinueForPaymentMethodSection();
        checkoutPage.clickContinueForPaymentInformationSection().clickContinueForConfirmOrderSection();

        String successMessage = "Your order has been successfully processed!";
        WaitHelper.waitForTextToBePresentInBody(driver, successMessage);

        Assert.assertTrue(driver.getPageSource().contains(successMessage), "The success message is not displayed.");
    }
}

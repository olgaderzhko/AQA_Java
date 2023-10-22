package com.tricentis.demowebshop.aqa_java.ui.tests.shoppingCartPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage.ShoppingCartPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductFromShoppingCartTest extends BaseTest {
    @Test
    public void removeProduct() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openProductPage();

        ProductCardPage productCardPage = new ProductCardPage();
        productCardPage.AddToCard();

        String successBannerText = productCardPage.getSuccessBannerText();
        Assert.assertEquals(successBannerText, "The product has been added to your shopping cart");

        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        shoppingCartPage.clickOnShoppingCartButton();

        shoppingCartPage.removeProductFromShoppingCart();
        Assert.assertTrue(shoppingCartPage.isCartEmpty(), "The product was not removed from the cart. The cart is not empty.");
    }
}

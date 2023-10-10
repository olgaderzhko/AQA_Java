package com.tricentis.demowebshop.aqa_java.ui.tests.shoppingCartPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage.ShoppingCartPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveProductFromShoppingCartTest extends BaseTest {
        @Test
        public void removeProduct() throws InterruptedException {
            LoginPage loginPage = openApp().openLoginPage();
            loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

            ProductCardPage productCardPage = openApp().openProductPage();
            productCardPage.AddToCard();
            productCardPage.SuccessBannerDisplayed(By.xpath("//*[@id='bar-notification']/p"), "The product has been added to your shopping cart");

            ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
            shoppingCartPage.clickOnShoppingCartButton();

            shoppingCartPage.removeProductFromShoppingCart();
            Assert.assertTrue(shoppingCartPage.isCartEmpty(), "The product was not removed from the cart.");
        }
}


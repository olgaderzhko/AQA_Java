package com.tricentis.demowebshop.aqa_java.ui.tests.productCardPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class AddProductToWishlistTest extends BaseTest {
    @Test
    public void addProductToWishList (){
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        ProductCardPage productCardPage = openApp().openProductPage();

        productCardPage.clickDigitalDownloadsSideCategoryMenu().clickProductTitle().AddToWishlist();
        productCardPage.SuccessBannerDisplayed(By.xpath("//*[@id='bar-notification']/p"), "The product has been added to your wishlist");

    }
}

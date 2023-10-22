package com.tricentis.demowebshop.aqa_java.ui.tests.productCardPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductToWishlistTest extends BaseTest {
    @Test
    public void addProductToWishList() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openProductPage();

        ProductCardPage productCardPage = new ProductCardPage();
        productCardPage.clickDigitalDownloadsSideCategoryMenu().clickProductTitle().AddToWishlist();

        String successBannerText = productCardPage.getSuccessBannerText();
        Assert.assertEquals(successBannerText, "The product has been added to your wishlist");
    }
}

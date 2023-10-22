package com.tricentis.demowebshop.aqa_java.ui.tests.productCardPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;

import org.testng.Assert;
import org.testng.annotations.Test;


public class AddProductToCardTest extends BaseTest {

    @Test
    public void addProductToCard() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openProductPage();

        ProductCardPage productCardPage = new ProductCardPage();
        productCardPage.clickDigitalDownloadsSideCategoryMenu().clickProductTitle().AddToCard();

        String successBannerText = productCardPage.getSuccessBannerText();
        Assert.assertEquals(successBannerText, "The product has been added to your shopping cart");

    }
}

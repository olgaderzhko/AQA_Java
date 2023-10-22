package com.tricentis.demowebshop.aqa_java.ui.tests.categoryProductListPageTests;

import com.tricentis.demowebshop.aqa_java.ui.helpers.LoginHelper;
import com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage.CategoryProductListPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingItemsTests extends BaseTest {

    @Test
    public void sortingAZItems() {
        PageHandler pageHandler = new PageHandler();
        new LoginHelper(pageHandler).logInUser("olha.derzhko@test.gmail.com", "123456");

        pageHandler.openCategoryProductListPage();
        CategoryProductListPage categoryProductListPage = new CategoryProductListPage();

        int newProductCount = 12;
        categoryProductListPage.changeProductsPerPage(newProductCount);

        categoryProductListPage.selectSortOrder("Name: A to Z");
        List<String> products = categoryProductListPage.getProductNames();

        List<String> productsToSort = new ArrayList<>(products);
        Collections.sort(productsToSort);

        Assert.assertTrue(products.size() > 0);
        Assert.assertEquals(products, productsToSort);
    }

    @Test
    public void sortingZAItems() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openCategoryProductListPage();

        CategoryProductListPage categoryProductListPage = new CategoryProductListPage();

        int newProductCount = 12;
        categoryProductListPage.changeProductsPerPage(newProductCount);


        categoryProductListPage.selectSortOrder("Name: Z to A");
        List<String> products = categoryProductListPage.getProductNames();

        List<String> productsToSort = new ArrayList<>(products);
        Collections.sort(productsToSort, Collections.reverseOrder());

        Assert.assertTrue(products.size() > 0);
        Assert.assertEquals(products, productsToSort);
    }

    @Test
    public void sortingPriceHighToLowItems() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openCategoryProductListPage();

        CategoryProductListPage categoryProductListPage = new CategoryProductListPage();

        int newProductCount = 12;
        categoryProductListPage.changeProductsPerPage(newProductCount);

        categoryProductListPage.selectSortOrder("Price: High to Low");
        List<Double> prices = categoryProductListPage.getProductPrices();

        List<Double> pricesToSort = new ArrayList<>(prices);
        Collections.sort(pricesToSort, Collections.reverseOrder());

        Assert.assertTrue(prices.size() > 0);
        Assert.assertEquals(prices, pricesToSort);
    }

    @Test
    public void sortingPriceLowToHighItems() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openCategoryProductListPage();

        CategoryProductListPage categoryProductListPage = new CategoryProductListPage();

        int newProductCount = 12;
        categoryProductListPage.changeProductsPerPage(newProductCount);

        categoryProductListPage.selectSortOrder("Price: Low to High");
        List<Double> prices = categoryProductListPage.getProductPrices();

        List<Double> pricesToSort = new ArrayList<>(prices);
        Collections.sort(pricesToSort);

        Assert.assertTrue(prices.size() > 0);
        Assert.assertEquals(prices, pricesToSort);
    }
}


package com.tricentis.demowebshop.aqa_java.ui.tests.categoryProductListPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage.CategoryProductListPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SortingItemsTests extends BaseTest {

        @Test
        public void sortingAZItems()  {
            LoginPage loginPage = openApp().openLoginPage();
            loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

            CategoryProductListPage categoryProductListPage = openApp().openCategoryProductListPage();

            categoryProductListPage.selectSortOrder("Name: A to Z");
            List<String> products = categoryProductListPage.getProductNames();
            System.out.println(products);

            List<String> productsToSort = new ArrayList<>(products);
            Collections.sort(productsToSort);

            Assert.assertTrue(products.size() > 0);
            Assert.assertEquals(products, productsToSort);
        }

    @Test
    public void sortingZAItems()  {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        CategoryProductListPage categoryProductListPage = openApp().openCategoryProductListPage();

        categoryProductListPage.selectSortOrder("Name: Z to A");
        List<String> products = categoryProductListPage.getProductNames();
        System.out.println(products);

        List<String> productsToSort = new ArrayList<>(products);
        Collections.sort(productsToSort, Collections.reverseOrder());

        Assert.assertTrue(products.size() > 0);
        Assert.assertEquals(products, productsToSort);
    }

    @Test
    public void sortingPriceHighToLowItems()  {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        CategoryProductListPage categoryProductListPage = openApp().openCategoryProductListPage();

        categoryProductListPage.selectSortOrder("Price: High to Low");
        List<Double> prices = categoryProductListPage.getProductPrices();
        System.out.println(prices);

        List<Double> pricesToSort = new ArrayList<>(prices);
        Collections.sort(pricesToSort, Collections.reverseOrder());

        Assert.assertTrue(prices.size() > 0);
        Assert.assertEquals(prices, pricesToSort);
    }

    @Test
    public void sortingPriceLowToHighItems()  {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        CategoryProductListPage categoryProductListPage = openApp().openCategoryProductListPage();

        categoryProductListPage.selectSortOrder("Price: Low to High");
        List<Double> prices = categoryProductListPage.getProductPrices();
        System.out.println(prices);

        List<Double> pricesToSort = new ArrayList<>(prices);
        Collections.sort(pricesToSort);

        Assert.assertTrue(prices.size() > 0);
        Assert.assertEquals(prices, pricesToSort);
    }
}


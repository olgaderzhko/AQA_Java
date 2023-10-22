package com.tricentis.demowebshop.aqa_java.ui.tests.categoryProductListPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage.CategoryProductListPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ChangeProductsPerPageTest extends BaseTest {

    //Оскільки в секціях дуже мало продуктів - сортування із відображенням тільки 4 продуктів
    @Test
    public void changeProductPerPageTo4() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openCategoryProductListPage();

        CategoryProductListPage categoryProductListPage = new CategoryProductListPage();

        int newProductCount = 4;
        categoryProductListPage.changeProductsPerPage(newProductCount);

        int updatedProductCount = categoryProductListPage.getCurrentProductCount();
        Assert.assertEquals(updatedProductCount, newProductCount, "The number of products does not correspond to the expected number");
    }
}

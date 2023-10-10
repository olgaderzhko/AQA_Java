package com.tricentis.demowebshop.aqa_java.ui.tests.categoryProductListPageTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage.CategoryProductListPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * @author Derzhko.O
 */
public class ChangeProductsPerPageTest extends BaseTest {
    @Test
    public void changeProductPerPage() throws InterruptedException {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        CategoryProductListPage categoryProductListPage = openApp().openCategoryProductListPage();
        int initialProductCount = categoryProductListPage.getCurrentProductCount();

        int newProductCount = 4;
        categoryProductListPage.changeProductsPerPage(newProductCount);

        int updatedProductCount = categoryProductListPage.getCurrentProductCount();
        Assert.assertEquals(updatedProductCount, newProductCount, "The number of products does not correspond to the expected number");

    }
}

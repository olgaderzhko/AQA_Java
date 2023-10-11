package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage;

import com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage.CategoryProductListPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.RegistrationPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage.ProductCardPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.shoppingCartPage.ShoppingCartPage;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;

/**
 * @author Derzhko.O
 */
public class MainPage extends BasePage {

    public LoginPage openLoginPage() {
        driver.findElement(By.xpath("//a[contains (@href, '/login')]")).click();
        return new LoginPage();
    }
    public RegistrationPage openRegistrationPage() {
        driver.findElement(By.xpath("//a[contains (@href, '/register')]")).click();
        return new RegistrationPage();
    }
    public CategoryProductListPage openCategoryProductListPage(){
        driver.findElement(By.xpath("//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Books')]")).click();
        return new CategoryProductListPage();
    }

    public ProductCardPage openProductPage(){
        driver.findElement(By.xpath("//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Digital downloads')]")).click();
        driver.findElement(By.linkText("3rd Album")).click();
        return new ProductCardPage();
    }

    public ShoppingCartPage openShoppingCartPage(){
        driver.findElement(By.xpath("//div[@class='header-links']//span[@class='cart-label' and text()='Shopping cart']")).click();
        return new ShoppingCartPage();
    }
}

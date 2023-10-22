package com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHandler extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Computers')]")
    private WebElement categoryComputers;

    @FindBy(xpath = "//a[contains (@href, '/login')]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains (@href, '/register')]")
    private WebElement registrationButton;

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Books')]")
    private WebElement sideMenuCategoryBooks;

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Digital downloads')]")
    private WebElement sideMenuCategoryDigitalDownloads;

    @FindBy(linkText = "3rd Album")
    private WebElement productOnProductList;

    @FindBy(xpath = "//div[@class='header-links']//span[@class='cart-label' and text()='Shopping cart']")
    private WebElement shoppingCartButton;

    public PageHandler () {
        PageFactory.initElements(driver, this);
    }

    public void openLoginPage() {
        loginButton.click();
    }

    public void openRegistrationPage() {
        registrationButton.click();
    }

    public void openCategoryProductListPage(){
        sideMenuCategoryBooks.click();
    }

    public void openProductPage(){
        sideMenuCategoryDigitalDownloads.click();
        productOnProductList.click();
    }

    public void openCategoryPage(){
        categoryComputers.click();
    }

}

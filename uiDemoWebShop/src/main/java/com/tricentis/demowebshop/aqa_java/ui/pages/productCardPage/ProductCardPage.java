package com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage;

import com.tricentis.demowebshop.aqa_java.ui.helpers.WaitHelper;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ProductCardPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Digital downloads')]")
    private WebElement categoryDigitalDownloads;

    @FindBy(xpath = "//*[@id='add-to-wishlist-button-53']")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//*[@id='add-to-cart-button-53']")
    private WebElement addToCardButton;

    @FindBy(xpath = "//*[@id='bar-notification']/p")
    private WebElement successBannerNotification;

    @FindBy(linkText = "3rd Album")
    private WebElement productFromProductList;

    public ProductCardPage() {
        PageFactory.initElements(driver, this);
    }

    public ProductCardPage clickDigitalDownloadsSideCategoryMenu() {
        categoryDigitalDownloads.click();
        return this;
    }

    public ProductCardPage clickProductTitle() {
        WaitHelper.waitForVisibilityOfElement(driver, productFromProductList);
        productFromProductList.click();
        return new ProductCardPage();
    }

    public void AddToWishlist() {
        if (addToWishlistButton != null){
        addToWishlistButton.click();
        }
    }

    public String getSuccessBannerText() {
        WaitHelper.waitForVisibilityOfElement(driver, successBannerNotification);
        return successBannerNotification.getText();
    }

    public void AddToCard() {
        if (addToCardButton != null){
        addToCardButton.click();
        }
    }
}

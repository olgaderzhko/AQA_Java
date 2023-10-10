package com.tricentis.demowebshop.aqa_java.ui.pages.productCardPage;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * @author Derzhko.O
 */
public class ProductCardPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Digital downloads')]")
    private WebElement categoryDigitalDownloads;

    @FindBy(xpath = "//*[@id='add-to-wishlist-button-53']")
    private WebElement addToWishlistButton;

    @FindBy(xpath = "//*[@id='add-to-cart-button-53']")
    private WebElement addToCardButton;

    public ProductCardPage() {
        PageFactory.initElements(driver, this);
    }

    public ProductCardPage clickDigitalDownloadsSideCategoryMenu() {
        categoryDigitalDownloads.click();
        return this;
    }

    public ProductCardPage clickProductTitle() {
        WebElement productTitle = driver.findElement(By.linkText("3rd Album"));
        if (productTitle != null) {
            productTitle.click();
        } else {
            System.out.println("The product was not found.");
        }
        return new ProductCardPage();
    }

    public ProductCardPage AddToWishlist() {
        if (addToWishlistButton != null){
        addToWishlistButton.click();
        } else {
            System.out.println("Add to wishlist button not found.");
        }
        return this;
    }
    public void SuccessBannerDisplayed(By bannerLocator, String expectedText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement successBanner = wait.until(ExpectedConditions.visibilityOfElementLocated(bannerLocator));
        String bannerText = successBanner.getText();
        System.out.println("Success Banner Text: " + bannerText);

    }



    public ProductCardPage AddToCard() {
        if (addToCardButton != null){
        addToCardButton.click();
        } else {
            System.out.println("Add to Card button not found. ");
        }
        return this;
    }
}

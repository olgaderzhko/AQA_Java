package com.tricentis.demowebshop.aqa_java.ui.pages.categoryProductListPage;

import com.tricentis.demowebshop.aqa_java.ui.helpers.WaitHelper;
import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import java.util.ArrayList;
import java.util.List;

public class CategoryProductListPage extends BasePage {

    @FindBy(xpath = "//div[@class='item-box']")
    private List<WebElement> productList;

    @FindBy(xpath = "//*[@id='products-pagesize']")
    private WebElement productsPerPageDropdown;

    @FindBy(xpath = "//*[@id='products-orderby']")
    private WebElement sortProductsDropdown;

    @FindBy(xpath = "//div[@class = 'ajax-loading-block-window']")
    private WebElement ajaxLoadingBlock;

    @FindBy(xpath = "//h2[@class='product-title']")
    private List <WebElement> productTitle;

    @FindBy(className = "actual-price")
    private List <WebElement> actualPrice;

    public CategoryProductListPage() {
        PageFactory.initElements(driver, this);
    }

    public int getCurrentProductCount() {
        return productList.size();
    }

    public void changeProductsPerPage(int itemCount) {
        Actions actions = new Actions(driver);
        actions.click(productsPerPageDropdown).build().perform();

        Select dropdown = new Select(productsPerPageDropdown);
        dropdown.selectByVisibleText(String.valueOf(itemCount));
    }

    public void selectSortOrder(String itemCount) {
        Actions actions = new Actions(driver);
        actions.click(sortProductsDropdown).build().perform();

        Select dropdown = new Select(sortProductsDropdown);
        dropdown.selectByVisibleText(String.valueOf(itemCount));

        WaitHelper.waitForInvisibilityOfElement(driver,ajaxLoadingBlock);

    }

    public List<String> getProductNames() {
        List<WebElement> productNames = productTitle;
        List<String> sortedProductNames = new ArrayList<>();

        for (WebElement productName : productNames) {
            sortedProductNames.add(productName.getText());
        }
        return sortedProductNames;
    }

    public List<Double> getProductPrices() {
        List<WebElement> productPrices = actualPrice;
        List<Double> sortedProductNames = new ArrayList<>();

        for (WebElement productName : productPrices) {
            sortedProductNames.add(Double.parseDouble(productName.getText()));
        }
        return sortedProductNames;
    }
}

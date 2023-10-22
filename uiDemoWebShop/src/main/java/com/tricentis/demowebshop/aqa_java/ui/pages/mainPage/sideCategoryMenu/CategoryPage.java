package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.sideCategoryMenu;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CategoryPage extends BasePage {

    @FindBy(css= ".sub-category-item h2")
    private WebElement titlesCategoryComputers;

    @FindBy(xpath = "//div[@class='sub-category-item']")
    List<WebElement> subGroups;

    public CategoryPage() {
        PageFactory.initElements(driver, this);
    }


    public String getComputersSubGroupsName(int subGroupsNumber) {
        Actions actions = new Actions(driver);
        actions.moveToElement(subGroups.get(subGroupsNumber)).perform();
        return titlesCategoryComputers.getText();
    }

    public int getSubGroupCount() {
        return this.subGroups.size();
    }
}


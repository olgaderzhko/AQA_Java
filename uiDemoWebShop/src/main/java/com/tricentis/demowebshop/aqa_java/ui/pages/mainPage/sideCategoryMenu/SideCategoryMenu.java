package com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.sideCategoryMenu;

import com.tricentis.demowebshop.aqa_java.ui.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * @author Derzhko.O
 */
public class SideCategoryMenu extends BasePage {

    @FindBy(xpath = "//div[contains(@class, 'block-category-navigation')]//a[contains(text(), 'Computers')]")
    private WebElement categoryComputers;

    @FindBy(xpath = "//div[@class='sub-category-item']")
    List<WebElement> subGroups;

    public SideCategoryMenu() {
        PageFactory.initElements(driver, this);
    }

    public SideCategoryMenu clickComputersSideCategoryMenu() {
        categoryComputers.click();
        return this;
    }

    public String getComputersSubGroupsName(int subGroupsNumber) {
        WebElement subGroup = subGroups.get(subGroupsNumber);
        Actions actions = new Actions(driver);
        actions.moveToElement(subGroup).perform();

        WebElement subGroupMame = subGroup.findElement(By.cssSelector(".sub-category-item h2"));
        return subGroupMame.getText();
    }

    public int getSubGroupCount() {
        return this.subGroups.size();
    }
}


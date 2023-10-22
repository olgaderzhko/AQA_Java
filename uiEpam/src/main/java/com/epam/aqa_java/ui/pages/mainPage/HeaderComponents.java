package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.helpers.WaitHelper;
import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderComponents extends BasePage {

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div[1]/header/div/div/section/div")
    private WebElement themeSwitcher;

    @FindBy(xpath = "//a[1]/img[3]")
    private WebElement lightLogo;

    @FindBy(xpath = "//button[@class='location-selector__button']")
    private WebElement languageButton;

    @FindBy(xpath = "//button[contains(@class, 'header-search__button')]")
    private WebElement magnifyingIcon;

    @FindBy(xpath = "//input[@id='new_form_search']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/strong")
    private WebElement locationSelectorPanel;

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/ul/li[6]/a")
    private WebElement ukraineLanguage;

    @FindBy(xpath = "//div[contains(@class, 'header-search__panel opened')]")
    private WebElement searchDropDown;

    public HeaderComponents() {
        PageFactory.initElements(driver, this);
    }

    public void themeSwitcherClick() {
        WaitHelper.waitForElementToClick(driver, themeSwitcher);
    }

    public String checkDisplayedTheme() {
        String darkThemeBackgroundColor = "#060606";
        WebElement headerElement = lightLogo;

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String actualBackgroundColor = (String) js.executeScript("return getComputedStyle(arguments[0]).getPropertyValue('--header-background-color');", headerElement);

        WaitHelper.waitForDuration(5);
        if (actualBackgroundColor.equals(darkThemeBackgroundColor)) {
            return "Dark mode is displayed";
        } else if (lightLogo.isDisplayed()) {
            return "Light mode is displayed";
        } else {
            return "Theme not detected";
        }
    }


    public HeaderComponents clickLanguageButton() {
        languageButton.click();
        WaitHelper.waitForElementToBeClickable(driver, locationSelectorPanel);
        return this;
    }

    public void selectUkrainianLanguage() {
        WaitHelper.waitForElementToBeClickable(driver, ukraineLanguage);
        ukraineLanguage.click();
    }


    public void clickOnMagnifyingIcon() {
        magnifyingIcon.click();
        new MainPage();
    }

    public void searchByParameter (String searchWord){
        WaitHelper.waitForVisibilityOfElement(driver, searchDropDown);

        searchInput.click();
        searchInput.sendKeys(searchWord);
        searchInput.sendKeys(Keys.ENTER);

        new MainPage();
    }
}


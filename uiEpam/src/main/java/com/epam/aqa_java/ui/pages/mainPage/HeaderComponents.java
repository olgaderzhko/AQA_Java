package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderComponents extends BasePage {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/section/div")
    private WebElement themeSwitcher;

    @FindBy(xpath = "//a[1]/img[2]")
    private WebElement darkLogo;

    @FindBy(xpath = "//a[1]/img[3]")
    private WebElement lightLogo;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div[1]/header/div/div/ul/li[2]/div/div/button")
    private WebElement languageButton;

    @FindBy(xpath = "//button[contains(@class, 'header-search__button')]")
    private WebElement magnifyingIcon;

    @FindBy(xpath = "//input[@id='new_form_search']")
    private WebElement searchInput;
    public HeaderComponents() {
        PageFactory.initElements(driver, this);
    }

    public void themeSwitcher() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(themeSwitcher)).click();
    }

    public String checkDisplayedTheme() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        if (darkLogo.isDisplayed()) {
            return "Light mode is displayed";
        } else if (lightLogo.isDisplayed()) {
            return "Dark mode is displayed";
        } else {
            return "Theme not detected";
        }
    }

    public HeaderComponents clickLanguageButton() throws InterruptedException {
        languageButton.click();
        new WebDriverWait(this.driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id=\"wrapper\"]/div[2]/div[1]/header/div/div/ul/li[2]/div/nav/strong"))));
        return this;
    }

    public HeaderComponents selectUkrainianLanguage() {
        String ukraineLanguage = "//ul/li[2]/div/nav/ul/li[6]/a";
        new WebDriverWait(this.driver, Duration.ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(By.xpath(ukraineLanguage)));
        driver.findElement(By.xpath(ukraineLanguage)).click();
        return this;
    }

    public MainPage clickOnMagnifyingIcon (){
        magnifyingIcon.click();
        return new MainPage();
    }

    public MainPage searchByParameter (String searchWord){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By searchDropDown = By.xpath("//div[contains(@class, 'header-search__panel opened')]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchDropDown));

        searchInput.click();
        searchInput.sendKeys("AI");
        searchInput.sendKeys(Keys.ENTER);

        return new MainPage();
    }
}


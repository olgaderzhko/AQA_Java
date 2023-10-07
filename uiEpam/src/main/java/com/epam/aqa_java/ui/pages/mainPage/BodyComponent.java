package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BodyComponent extends BasePage {

    @FindBy(xpath = "//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div")
    private WebElement locationList;

    @FindBy(xpath = "//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div/div/div[1]/a")
    private WebElement locationAmericas;

    @FindBy(linkText = "EMEA")
    private WebElement locationEmea;

    @FindBy(linkText = "APAC")
    private WebElement locationApac;

    @FindBy(xpath = "//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[2]/div/div")
    private WebElement sectionXPath;

    public BodyComponent() {
        PageFactory.initElements(driver, this);
    }

    public void scrollDownOurLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ourLocationSection = driver.findElement(By.linkText("AMERICAS"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ourLocationSection);
    }

    public List<String> getAllLocationTexts() {
        List<WebElement> locationElements = driver.findElements(By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]/div[1]/div"));
        List<String> locationTexts = new ArrayList<>();

        for (WebElement locationElement : locationElements) {
            locationTexts.add(locationElement.getText());
        }
        return locationTexts;
    }


    public List<String> getAllTitlesFromAllLocations() throws InterruptedException {
        List<String> allAmericasTitles = new ArrayList<>();
        locationAmericas.click();

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        By americasSectionLocator = By.xpath("//*[@id=\"id-890298b8-f4a7-3f75-8a76-be36dc4490fd\"]");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(americasSectionLocator));
        Thread.sleep(5000);
        List<WebElement> titleElements = driver.findElements(By.xpath("//*[@id='id-890298b8-f4a7-3f75-8a76-be36dc4490fd']/div[2]/div/div"));
        for (WebElement titleElement : titleElements) {
            allAmericasTitles.add(titleElement.getText());
        }
        return allAmericasTitles;
    }
}


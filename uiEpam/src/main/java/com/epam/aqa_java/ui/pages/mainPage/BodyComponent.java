package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BodyComponent extends BasePage {

    @FindBy(xpath = "//*[@id='id-890298b8-f4a7-3f75-8a76-be36dc4490fd']/div[1]/div")
    private WebElement locationList;

    @FindBy(linkText = "AMERICAS")
    public WebElement locationAmericas;

    @FindBy(linkText = "EMEA")
    public WebElement locationEmea;

    @FindBy(linkText = "APAC")
    public WebElement locationApac;

    @FindBy(xpath = "//*[@id='id-890298b8-f4a7-3f75-8a76-be36dc4490fd']/div[2]/div/div")
    private WebElement sectionXPath;

    public BodyComponent() {
        PageFactory.initElements(driver, this);
    }

    public BodyComponent scrollDownOurLocation() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement ourLocationSection = driver.findElement(By.linkText("AMERICAS"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo({\n" +
                "    top: arguments[0].getBoundingClientRect().top -\n" +
                "        document.body.getBoundingClientRect().top -\n" +
                "        100\n" +
                "})", ourLocationSection);

        return this;
    }

    public List<String> getAllLocationTexts() {
        List<WebElement> locationElements = driver.findElements(By.xpath("//*[@id='id-890298b8-f4a7-3f75-8a76-be36dc4490fd']/div[1]/div"));
        List<String> locationTexts = new ArrayList<>();

        for (WebElement locationElement : locationElements) {
            locationTexts.add(locationElement.getText());
        }
        return locationTexts;
    }

    public List<String> getActiveLocationsList() {
        List<String> allActiveLocationsList = new ArrayList<>();
        List<WebElement> titleElements = driver.findElements(By.xpath("//div[contains(@class, 'active')]//div[@class='locations-viewer']//div[contains(@class, ' list')]"));
        for (WebElement titleElement : titleElements) {
            String text = titleElement.getText();
            if (text.equals("")) {
                continue;
            }
            allActiveLocationsList.add(titleElement.getText());
        }
        return allActiveLocationsList;
    }

    public BodyComponent clickAmericanArea() {
        this.locationAmericas.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationEmea));
        return this;
    }

    public BodyComponent clickEmeaArea() {
        this.locationEmea.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationApac));
        return this;
    }

    public BodyComponent clickApacArea()  {
        this.locationApac.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(locationEmea));
        return this;
    }
}


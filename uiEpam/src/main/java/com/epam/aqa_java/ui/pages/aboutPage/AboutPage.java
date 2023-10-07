package com.epam.aqa_java.ui.pages.aboutPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

/**
 * @author Derzhko.O
 */
public class AboutPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'header__logo-container desktop-logo')]/img[3]")
    private WebElement logoIcon;

    @FindBy(linkText = "DOWNLOAD")
    private WebElement downloadButton;

    public AboutPage() {
        PageFactory.initElements(driver, this);
    }

    public AboutPage verifyLogoClickRedirection() {
        logoIcon.click();
        return new AboutPage();
    }

    public AboutPage downloadFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement downloadButtonSection = driver.findElement(By.linkText("DOWNLOAD"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", downloadButtonSection);
        downloadButton.click();
        return this;
    }

    public AboutPage waitUntilDownloadFile() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        String folderPath = "target/downloads/";
        String fileName = "EPAM_Corporate_Overview_2023.pdf";

        wait.until((WebDriver driver) -> {
            File folder = new File(folderPath);
            File[] listOfFiles = folder.listFiles();
            if (listOfFiles != null) {
                for (File file1 : listOfFiles) {
                    if (file1.isFile() && file1.getName().equals(fileName)) {
                        return true;
                    }
                }
            }
            return false;
        });

        return this;
    }
}

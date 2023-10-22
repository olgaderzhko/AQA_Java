package com.epam.aqa_java.ui.pages.aboutPage;

import com.epam.aqa_java.ui.pages.helpers.ScrollPageHelper;
import com.epam.aqa_java.ui.pages.helpers.WaitHelper;
import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AboutPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class, 'header__logo-container desktop-logo')]/img[3]")
    private WebElement logoIcon;

    @FindBy(linkText = "DOWNLOAD")
    private WebElement downloadButton;

    public AboutPage() {
        PageFactory.initElements(driver, this);
    }

    public void verifyLogoClickRedirection() {
        logoIcon.click();
        new AboutPage();
    }

    public void downloadFile() {
        WebElement downloadButtonSection = driver.findElement(By.linkText("DOWNLOAD"));

        ScrollPageHelper.scrollToElement(driver, downloadButtonSection);
        WaitHelper.waitForElementToBeClickable(driver, downloadButton);

        downloadButton.click();
        WaitHelper.waitForDuration(10);
    }
}


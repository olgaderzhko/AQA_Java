package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.aboutPage.AboutPage;
import com.epam.aqa_java.ui.pages.contactPage.ContactPage;
import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.By;

public class MainPage extends BasePage {

    public String getTabTitle() {
        return driver.getTitle();
    }

    public ContactPage openContactPage() {
        driver.findElement(By.linkText("CONTACT US")).click();
        return new ContactPage();
    }

    public AboutPage openAboutPage() {
        driver.findElement(By.linkText("About")).click();
        return new AboutPage();
    }

}
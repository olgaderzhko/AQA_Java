package com.epam.aqa_java.ui.pages.pageObjects;

import com.epam.aqa_java.ui.pages.utils.BasePage;

public class PageHandler extends BasePage {
    public void openMainPage() {
        driver.get("https://www.epam.com/");
    }
    public void openAboutPage() {
        driver.get("https://www.epam.com/about");
    }
    public void openContactPage() {
        driver.get("https://www.epam.com/about/who-we-are/contact");
    }
}
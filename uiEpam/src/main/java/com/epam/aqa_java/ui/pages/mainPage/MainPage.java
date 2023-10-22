package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.utils.BasePage;


public class MainPage extends BasePage {

    public String getTabTitle() {
        return driver.getTitle();
    }
}
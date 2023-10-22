package com.tricentis.demowebshop.aqa_java.ui.helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScrollPageHelper {

    private WebDriver driver;

    public ScrollPageHelper(WebDriver driver) {
        this.driver = driver;
    }
    public void scrollIntoView(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({block: 'end', behavior: 'smooth'});", element);
    }
}

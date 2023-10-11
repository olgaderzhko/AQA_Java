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

public class FooterComponents extends BasePage {

    @FindBy(xpath = "//*[@id='wrapper']/div[3]/div[1]/footer/div/div/div[1]/div[2]/div")
    private WebElement policiesSection;


    public FooterComponents() {
        PageFactory.initElements(driver, this);
    }

    public void scrollDownToFooter() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='wrapper']/div[2]/div[1]/header/div")));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public List<String> getListPolicies() {
        List<String> listPolicies = new ArrayList<>();
        listPolicies.add(policiesSection.getText());
        return listPolicies;
    }
}

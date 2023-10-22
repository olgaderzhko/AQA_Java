package com.epam.aqa_java.ui.pages.mainPage;

import com.epam.aqa_java.ui.pages.helpers.ScrollPageHelper;
import com.epam.aqa_java.ui.pages.helpers.WaitHelper;
import com.epam.aqa_java.ui.pages.utils.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.stream.Collectors;

public class FooterComponents extends BasePage {

    @FindBy(xpath = "//*[@class='policies-links-wrapper']//li")
    private List<WebElement> policiesSection;

    @FindBy(xpath = "//*[@id='wrapper']/div[2]/div[1]/header/div")
    private WebElement headerLocator;


    public FooterComponents() {
        PageFactory.initElements(driver, this);
    }

    public void scrollDownToFooter() {
        ScrollPageHelper.scrollToBottom(driver);
        WaitHelper.waitForElementToBeClickable(driver, headerLocator);
    }

    public List<String> getListPolicies() {
        return policiesSection.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}

package com.tricentis.demowebshop.aqa_java.ui.tests.baseTest;

import com.tricentis.demowebshop.aqa_java.ui.helpers.LoginHelper;


import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.listeners.CustomExtentReportListener;
import com.tricentis.demowebshop.aqa_java.ui.utils.DriverHolder;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@Listeners({CustomExtentReportListener.class})
public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("download.default_directory", new File("target/downloads").getAbsolutePath());
        options.setExperimentalOption("prefs", prefs);

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        DriverHolder.setDriver(driver);

        PageHandler pageHandler = new PageHandler();
        new LoginHelper(pageHandler).logInUser("olha.derzhko@test.gmail.com", "123456");
    }


    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }


}

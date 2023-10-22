package com.epam.aqa_java.ui.pages.tests.baseTest;

import com.epam.aqa_java.ui.pages.tests.listeners.CustomExtentReportListener;
import com.epam.aqa_java.ui.pages.utils.DriverHolder;
import com.epam.aqa_java.ui.pages.utils.Settings;
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

    protected Settings settings = Settings.Instance;

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

    }

    @AfterClass(alwaysRun = true)
    public void cleanUp() {
        driver.quit();
    }

}

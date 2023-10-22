package com.epam.aqa_java.ui.pages.tests.aboutPage;

import com.epam.aqa_java.ui.pages.aboutPage.AboutPage;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;

public class DownloadFileTest extends BaseTest {
    private final String fileName = "EPAM_Corporate_Overview_2023.pdf";
    private final String filePath = this.settings.getValue("FilePathForDownloadFile") + this.fileName; // ToDO: add proper path joining

    @BeforeClass
    void beforeTest() {
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    public void downloadFile()  {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openAboutPage();
        AboutPage aboutPage = new AboutPage();

        File file = new File(this.filePath);
        aboutPage.downloadFile();

        if (!file.exists()) {
            Assert.fail("The file was not uploaded.");
        }
        Assert.assertEquals(file.getName(), this.fileName, "The downloaded file has an incorrect name");
    }
}

package com.epam.aqa_java.ui.pages.tests.aboutPage;

import com.epam.aqa_java.ui.pages.aboutPage.AboutPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.File;


public class DownloadFileTest extends BaseTest {

    @Test
    public void downloadFile() {
        AboutPage aboutPage = openApp().openAboutPage();
        String filePath = "target/downloads/EPAM_Corporate_Overview_2023.pdf";
        File file = new File(filePath);
        file.delete();

        aboutPage.downloadFile().waitUntilDownloadFile();

        if (!file.exists()) {
            Assert.fail("The file was not uploaded..");
            return;
        }

        String expectedFileName = "EPAM_Corporate_Overview_2023.pdf";
        Assert.assertEquals(file.getName(), expectedFileName, "The downloaded file has an incorrect name");
    }
}

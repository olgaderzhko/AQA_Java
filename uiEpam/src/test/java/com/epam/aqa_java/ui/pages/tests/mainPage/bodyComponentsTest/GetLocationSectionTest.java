package com.epam.aqa_java.ui.pages.tests.mainPage.bodyComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.BodyComponent;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.RegExUtils.replaceAll;

/**
 * @author Derzhko.O
 */
public class GetLocationSectionTest extends BaseTest {

    @Test
    public void getLocationSection()  {
        MainPage mainPage = openApp();

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.scrollDownOurLocation();

        List<String> actualLocations = bodyComponent.getAllLocationTexts();
        System.out.println(actualLocations);
        List<String> expectedLocations = new ArrayList<>();

        expectedLocations.add("AMERICAS");
        expectedLocations.add("EMEA");
        expectedLocations.add("APAC");
        System.out.println(expectedLocations);

        String expectedText = String.join("\n", expectedLocations);
        Assert.assertTrue(actualLocations.contains(expectedText));
    }
    @Test
    public void clickOnAllLocations () throws InterruptedException {
        MainPage mainPage = openApp();

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.scrollDownOurLocation();

        List<String> actualAmericasLocations = bodyComponent.getAllTitlesFromAllLocations();
        System.out.println(actualAmericasLocations);
    }
}

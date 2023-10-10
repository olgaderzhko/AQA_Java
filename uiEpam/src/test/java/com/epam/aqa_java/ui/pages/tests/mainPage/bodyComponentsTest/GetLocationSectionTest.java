package com.epam.aqa_java.ui.pages.tests.mainPage.bodyComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.BodyComponent;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void locationsPresent()  {
        MainPage mainPage = openApp();

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.scrollDownOurLocation();

        Assert.assertNotNull(bodyComponent.locationAmericas);
        Assert.assertNotNull(bodyComponent.locationApac);
        Assert.assertNotNull(bodyComponent.locationEmea);
    }

    @Test
    public void getAmericasLocations() throws InterruptedException {
        MainPage mainPage = openApp();
        String expectedLocations = "Canada, Colombia, Dominican Republic, Mexico".toUpperCase();
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickAmericanArea().getActiveLocationsList();
        System.out.println(list);

        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }

    @Test
    public void getEmeaLocations() throws InterruptedException {
        MainPage mainPage = openApp();
        String expectedLocations = "ARMENIA, AUSTRIA, BELARUS, BELGIUM";
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickEmeaArea().getActiveLocationsList();
        System.out.println(list);

        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }

    @Test
    public void getApacLocations() throws InterruptedException {
        MainPage mainPage = openApp();
        String expectedLocations = "AUSTRALIA, CHINA, HONG KONG SAR, INDIA";
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickApacArea().getActiveLocationsList();
        System.out.println(list);

        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }
}

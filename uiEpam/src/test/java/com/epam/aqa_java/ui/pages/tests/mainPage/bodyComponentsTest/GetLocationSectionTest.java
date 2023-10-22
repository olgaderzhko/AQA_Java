package com.epam.aqa_java.ui.pages.tests.mainPage.bodyComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.BodyComponent;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class GetLocationSectionTest extends BaseTest {

    @Test
    public void getLocationSection()  {

        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.scrollDownOurLocation();

        List<String> actualLocations = bodyComponent.getAllLocationTexts();
        String expectedText = "AMERICAS\nEMEA\nAPAC";

        Assert.assertTrue(actualLocations.contains(expectedText));
    }


    @Test
    public void locationsPresent()  {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        BodyComponent bodyComponent = new BodyComponent();
        bodyComponent.scrollDownOurLocation();

        Assert.assertNotNull(bodyComponent.locationAmericas);
        Assert.assertNotNull(bodyComponent.locationApac);
        Assert.assertNotNull(bodyComponent.locationEmea);
    }

    @Test
    public void getAmericasLocations() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        String expectedLocations = "Canada, Colombia, Dominican Republic, Mexico".toUpperCase();
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickAmericanArea().getActiveLocationsList();
        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }

    @Test
    public void getEmeaLocations() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        String expectedLocations = "ARMENIA, AUSTRIA, BELARUS, BELGIUM";
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickEmeaArea().getActiveLocationsList();
        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }

    @Test
    public void getApacLocations() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        String expectedLocations = "AUSTRALIA, CHINA, HONG KONG SAR, INDIA";
        String[] expectedLocationsArray = expectedLocations.split(", ");

        List<String> list = new BodyComponent().scrollDownOurLocation().clickApacArea().getActiveLocationsList();
        Assert.assertEquals(expectedLocationsArray, list.toArray());
    }
}

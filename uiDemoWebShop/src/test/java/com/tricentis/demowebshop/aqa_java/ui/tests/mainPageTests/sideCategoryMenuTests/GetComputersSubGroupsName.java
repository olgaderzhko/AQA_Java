package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.sideCategoryMenuTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.MainPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.headerComponents.authentication.LoginPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.sideCategoryMenu.SideCategoryMenu;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Derzhko.O
 */
public class GetComputersSubGroupsName extends BaseTest {

    @Test
    public void getSubGroupsName() {
        LoginPage loginPage = openApp().openLoginPage();
        loginPage.userLogIn("olha.derzhko@test.gmail.com", "123456");

        SideCategoryMenu sideCategoryMenu = new SideCategoryMenu();
        sideCategoryMenu.clickComputersSideCategoryMenu();

        int subGroupsNumber = sideCategoryMenu.getSubGroupCount();
        Assert.assertEquals(subGroupsNumber, 3, "Should be 3 sub-groups on the page");

        List<String> expectedSubGroupNames = Arrays.asList("Desktops", "Notebooks", "Accessories");

        for (int i = 0; i < subGroupsNumber; i++) {
            String subGroupName = sideCategoryMenu.getComputersSubGroupsName(i);
            System.out.println(subGroupName);

            Assert.assertTrue(expectedSubGroupNames.contains(subGroupName), "Unexpected sub-group name: " + subGroupName);
        }
    }
}

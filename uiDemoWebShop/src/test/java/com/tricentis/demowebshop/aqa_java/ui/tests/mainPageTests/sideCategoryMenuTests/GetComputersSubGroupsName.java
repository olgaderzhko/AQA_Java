package com.tricentis.demowebshop.aqa_java.ui.tests.mainPageTests.sideCategoryMenuTests;

import com.tricentis.demowebshop.aqa_java.ui.pages.mainPage.sideCategoryMenu.CategoryPage;
import com.tricentis.demowebshop.aqa_java.ui.pages.pageObjects.PageHandler;
import com.tricentis.demowebshop.aqa_java.ui.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class GetComputersSubGroupsName extends BaseTest {

    @Test
    public void getSubGroupsName() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openCategoryPage();

        CategoryPage sideCategoryMenu = new CategoryPage();
        int subGroupsNumber = sideCategoryMenu.getSubGroupCount();
        Assert.assertEquals(subGroupsNumber, 3, "Should be 3 sub-groups on the page");

        List<String> expectedSubGroupNames = Arrays.asList("Desktops", "Notebooks", "Accessories");

        for (int i = 0; i < subGroupsNumber; i++) {
            String subGroupName = sideCategoryMenu.getComputersSubGroupsName(i);

            Assert.assertTrue(expectedSubGroupNames.contains(subGroupName), "Unexpected sub-group name: " + subGroupName);
        }
    }
}
package com.epam.aqa_java.ui.pages.tests.mainPage.footerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.FooterComponents;
import com.epam.aqa_java.ui.pages.mainPage.MainPage;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PoliciesListTest extends BaseTest {

    @Test
    public void policiesList() throws InterruptedException {

        MainPage mainPage = openApp();
        FooterComponents footerComponents = new FooterComponents();
        footerComponents.scrollDownToFooter();

        List<String> actualPolicies = footerComponents.getListPolicies();

        List<String> expectedPolicies = new ArrayList<>();
        expectedPolicies.add("INVESTORS");
        expectedPolicies.add("OPEN SOURCE");
        expectedPolicies.add("PRIVACY POLICY");
        expectedPolicies.add("COOKIE POLICY");
        expectedPolicies.add("APPLICANT PRIVACY NOTICE");
        expectedPolicies.add("WEB ACCESSIBILITY");


        String expectedText = String.join("\n", expectedPolicies).replaceAll(",", "");
        Assert.assertTrue(actualPolicies.contains(expectedText));
    }
}

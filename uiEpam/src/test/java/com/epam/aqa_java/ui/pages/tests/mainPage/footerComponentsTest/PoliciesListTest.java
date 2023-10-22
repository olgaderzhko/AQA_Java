package com.epam.aqa_java.ui.pages.tests.mainPage.footerComponentsTest;

import com.epam.aqa_java.ui.pages.mainPage.FooterComponents;
import com.epam.aqa_java.ui.pages.pageObjects.PageHandler;
import com.epam.aqa_java.ui.pages.tests.baseTest.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.Arrays;
import java.util.List;

public class PoliciesListTest extends BaseTest {

    @Test
    public void policiesList() {
        PageHandler pageHandler = new PageHandler();
        pageHandler.openMainPage();

        FooterComponents footerComponents = new FooterComponents();
        footerComponents.scrollDownToFooter();

        List<String> actualPolicies = footerComponents.getListPolicies();

        String expectedText = "INVESTORS, OPEN SOURCE, PRIVACY POLICY, COOKIE POLICY, APPLICANT PRIVACY NOTICE, WEB ACCESSIBILITY";
        List<String> expectedPolicyList = Arrays.asList(expectedText.split(", "));

        Assert.assertTrue(actualPolicies.containsAll(expectedPolicyList));
    }
}

package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestcasePage;
@Epic("Automation Exercise Web")
@Feature("Tính năng Testcase")

public class TestcaseTest extends BaseTest {
    @Test
    public void navigateTestcasePage(){
        TestcasePage testcasePage = homePage.clickTestCaseButton();
        handleGoogleAdIfNeeded();
        Assert.assertTrue(testcasePage.displayTestcase(),"Khong hien thi trang testcase");
    }
    @Test
    public void subscriptionEmailSuccessful(){
        homePage.SubscriptionEmail("ko@gmial");
        Assert.assertEquals(homePage.handleNotiSubscriptionEmail(),"You have been successfully subscribed!","Thong bao dki khong chinh xac");
    }
}




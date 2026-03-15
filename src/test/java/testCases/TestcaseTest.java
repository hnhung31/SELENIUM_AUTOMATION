package testCases;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestcasePage;

public class TestcaseTest extends BaseTest {
    @Test
    public void navigateTestcasePage(){
        HomePage homePage = new HomePage(driver);
        TestcasePage testcasePage = homePage.clickTestCaseButton();
        handleGoogleAdIfNeeded();
        Assert.assertTrue(testcasePage.displayTestcase(),"Khong hien thi trang testcase");
    }
    @Test
    public void subscriptionEmailSuccessful(){
        HomePage homePage = new HomePage(driver);
        homePage.SubscriptionEmail("ko@gmial");
        Assert.assertEquals(homePage.handleNotiSubscriptionEmail(),"You have been successfully subscribed!","Thong bao dki khong chinh xac");
    }
}

package testCases;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LogOutTest extends BaseTest {

        @Test
        public void LogOut(){
            HomePage homePage = new HomePage(driver);
            User user = new User("nhung@gmail.com", "1234567890");
            LoginPage loginPage = homePage.clickLoginPage();
            HomePage homePage1=  loginPage.loginAction(user);
            Assert.assertTrue(homePage1.isDisplayedUser());
            LoginPage t = homePage1.logOutAction();
            handleGoogleAdIfNeeded();
            Assert.assertTrue(t.containLabelLogin(),"Khong the dang xuat");
        }
}

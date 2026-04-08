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
            User user = new User("nhung@gmail.com", "1234567890");
            Assert.assertTrue(homePage.clickLoginPage()
                                        .loginAction(user)
                                        .isDisplayedUser());
            LoginPage t = homePage.logOutAction();
            handleGoogleAdIfNeeded();
            Assert.assertTrue(t.containLabelLogin(),"Khong the dang xuat");
        }
}

package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
@Epic("Automation Exercise Web")
@Feature("Đăng xuất")

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




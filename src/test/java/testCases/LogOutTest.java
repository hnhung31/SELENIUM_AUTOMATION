package testCases;

import dataProvider.LoginData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import bases.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
@Epic("Automation Exercise Web")
@Feature("Đăng xuất")
public class LogOutTest extends BaseTest {

        @Test(dataProvider = "loginDataSuccessful", dataProviderClass = LoginData.class)
        public void LogOut(User user){
            Assert.assertTrue(homePage.clickLoginPage()
                                        .loginActionSuccessful(user)
                                        .isDisplayedUser());
            LoginPage t = homePage.logOutAction();
            handleGoogleAdIfNeeded();
            Assert.assertTrue(t.containLabelLogin(),"Khong the dang xuat");
        }
}




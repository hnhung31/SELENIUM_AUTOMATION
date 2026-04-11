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
@Feature("Quản lý đăng nhập")
public class LoginTest extends BaseTest {

    @Test()
   public void testLoginSuccessfu(){
        User user = new User("nhung@gmail.com", "1234567890");
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(homePage.isDisplayedUser());
    }

    @Test()
    public void testLoginUnsuccessful(){
        User user = new User("nhung@gmail.com","123123123");
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(loginPage.isErrorMessage());
    }


}


























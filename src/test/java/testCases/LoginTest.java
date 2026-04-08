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

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Automation Exercise Web")
@Feature("Quản lý đăng nhập")

public class LoginTest extends BaseTest {

    @Test(priority = 1, description = "Login User with correct email and password")
    @Story("Successful Login")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Verify that a valid user can successfully login using correct email and password.")
    public void testLoginSuccessfu(){
        User user = new User("nhung@gmail.com", "1234567890");
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(homePage.isDisplayedUser());
    }

    @Test(priority = 2, description = "Login User with incorrect email and password")
    @Story("Unsuccessful Login")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that an invalid user cannot login using incorrect email or password.")
    public void testLoginUnsuccessful(){
        User user = new User("nhung@gmail.com","123123123");
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(loginPage.isErrorMessage());
    }


}


























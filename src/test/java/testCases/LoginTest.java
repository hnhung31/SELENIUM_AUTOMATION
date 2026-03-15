package testCases;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    //Login User with correct email and password
    @Test
    public void testLoginSuccessfu(){
        HomePage homePage = new HomePage(driver);
        User user = new User("nhung@gmail.com", "1234567890");
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(homePage.isDisplayedUser());
    }

    //Login User with incorrect email and password
    @Test
    public void testLoginUnsuccessful(){
        User user = new User("nhung@gmail.com","123123123");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginAction(user);
        Assert.assertTrue(loginPage.isErrorMessage());
    }


}























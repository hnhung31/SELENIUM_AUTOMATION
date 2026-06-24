package testCases;

import dataProvider.LoginData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;



@Epic("Automation Exercise Web")
@Feature("Quản lý đăng nhập")
public class LoginTest extends BaseTest {

    @Test(dataProvider = "loginDataSuccessful", dataProviderClass = LoginData.class)
   public void testLoginSuccessfu(User user){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginActionSuccessful(user);
        Assert.assertTrue(homePage.isDisplayedUser(),"Khong login thanh cong");
    }

    @Test(dataProvider = "loginDataUnsuccessful", dataProviderClass = LoginData.class)
    public void testLoginUnsuccessful(User user, String message, String errorType){
        LoginPage loginPage = homePage.clickLoginPage();
        loginPage.loginActionUnsuccessful(user);
        String actualMessage ="";
        if(errorType.equals("email")){
            actualMessage  = driver.findElement(By.cssSelector("input[data-qa='login-email']")).getAttribute("validationMessage");
        } else if(errorType.equals("password")){
            actualMessage  = driver.findElement(By.name("password")).getAttribute("validationMessage");
        } else {
            actualMessage  = driver.findElement(By.xpath("//p[contains(text(),'Your email or password is incorrect!')]")).getText();
        }
        Assert.assertTrue(actualMessage.contains(message),"Xử lý không đúng trường hợp đăng nhập sai");

    }


}


























package testCases;

import dataProvider.RegisterData;
import io.qameta.allure.*;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;

@Epic("Automation Exercise Web")
@Feature("Quản lý chức năng đăng ký")
public class RegisterTest extends BaseTest {
    @Test(priority = 1, dataProvider = "registerSuccessful", dataProviderClass = RegisterData.class)
    @Description("1. Launch browser\n" +
            "2. Navigate to url 'http://automationexercise.com'\n" +
            "3. Verify that home page is visible successfully\n" +
            "4. Click on 'Signup / Login' button\n" +
            "5. Verify 'New User Signup!' is visible\n" +
            "6. Enter name and email address\n" +
            "7. Click 'Signup' button\n" +
            "8. Verify that 'ENTER ACCOUNT INFORMATION' is visible\n" +
            "9. Fill details: Title, Name, Email, Password, Date of birth\n" +
            "10. Select checkbox 'Sign up for our newsletter!'\n" +
            "11. Select checkbox 'Receive special offers from our partners!'\n" +
            "12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number\n" +
            "13. Click 'Create Account button'\n" +
            "14. Verify that 'ACCOUNT CREATED!' is visible")
    @Story("Register User")
    public void testRegisterSuccessful(User user){
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginPage();
        handleGoogleAdIfNeeded();
        RegisterPage register = loginPage.signUpNewUserSuccessfulStep1(user);
        handleGoogleAdIfNeeded();
        AccountCreatedPage accCrr = register.registerNewUser(user);
        Assert.assertTrue(accCrr.displayAccountCreatedPage(),"Đăng ký thành công nhưng không chuyển sang trang Account Created page");
    }

    @Test(dataProvider = "registerUnsuccessfulStep1", dataProviderClass = RegisterData.class)
    public void testSignupInvalidPage1(User user, String errorField, String message){
        LoginPage loginPage=homePage.clickLoginPage();
        handleGoogleAdIfNeeded();
        RegisterPage registerPage = loginPage.signUpNewUserSuccessfulStep1(user);
        String messageError="";
        switch (errorField){
            case "name":
                messageError= driver.findElement(By.cssSelector("input[data-qa='signup-name']")).getAttribute("validationMessage");
                break;
            case "email":
                messageError= driver.findElement(By.xpath("//input[@data-qa='signup-email']")).getAttribute("validationMessage");
                break;
            case "errorcredential":
                messageError= driver.findElement(By.xpath("//p[contains(text(),'Email Address already exist!')]")).getText();
                break;
        }
        Assert.assertTrue(messageError.contains(message),"Không trả về đúng lỗi ở trang signup1");
    }


    @Test(dataProvider = "registerUnsuccessful", dataProviderClass = RegisterData.class)
    public void testSignupInvalidPage2(User user, String errorField, String message){
        LoginPage loginPage=homePage.clickLoginPage();
        handleGoogleAdIfNeeded();
        RegisterPage registerPage= loginPage.signUpNewUserSuccessfulStep1(user);
        registerPage.registerUserUnsuccessful(user);
        handleGoogleAdIfNeeded();
        String messageError="";
        switch (errorField){
            case "password":
                messageError= driver.findElement(By.id("password")).getAttribute("validationMessage");
                break;
            case "firstname":
                messageError= driver.findElement(By.id("first_name")).getAttribute("validationMessage");
                break;
            case "lastname":
                messageError= driver.findElement(By.id("last_name")).getAttribute("validationMessage");
                break;
            case "address":
                messageError= driver.findElement(By.id("address1")).getAttribute("validationMessage");
                break;
            case "state":
                messageError= driver.findElement(By.id("state")).getAttribute("validationMessage");
                break;
            case "city":
                messageError= driver.findElement(By.id("city")).getAttribute("validationMessage");
                break;
            case "zipcode":
                messageError= driver.findElement(By.id("zipcode")).getAttribute("validationMessage");
                break;
            case "phone":
                messageError= driver.findElement(By.id("mobile_number")).getAttribute("validationMessage");
                break;
        }
        Assert.assertTrue(messageError.contains(message),"Không trả về đúng lỗi ở trang signup2");
    }
}




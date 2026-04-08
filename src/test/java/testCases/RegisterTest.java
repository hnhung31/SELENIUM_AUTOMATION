package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import models.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountCreatedPage;
import pages.HomePage;
import pages.LoginPage;
import pages.RegisterPage;
import io.qameta.allure.Description;
@Epic("Automation Exercise Web")
@Feature("Quản lý chức năng đăng ký")

public class RegisterTest extends BaseTest {

    @Test(priority = 1)
    @Description("Kiểm tra đăng ký tài khoản thành công với dữ liệu hợp lệ")
    @Story("Đăng ký thành công")
    public void testRegisterFunction(){
        String t ="nhung" + System.currentTimeMillis() + "@gmail.com";
        User user = new User("NgocHoa",t,"123123123","Hoa","Nguyen","Dien Bien Phu","India","TP HCM","Thu Duc","456099","0123456789");
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.clickLoginPage();
        handleGoogleAdIfNeeded();
        RegisterPage register = loginPage.signUpNewUser(user);
        handleGoogleAdIfNeeded();
        AccountCreatedPage accCrr = register.registerNewUser(user);
        Assert.assertTrue(accCrr.displayAccountCreatedPage(),"Đăng ký thành công nhưng không chuyển sang trang Account Created page");
    }
    @Test
    public void testRegisterWithEmailExist(){
        homePage.clickLoginPage();

    }
}




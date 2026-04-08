package testCases;

import bases.BaseTest;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

import java.io.File;
import java.time.Duration;

public class OrderTest extends BaseTest {
    @Test
    public void placeOrderRegisterBeforeCheckout(){
        String dynamicEmail = "nhung" + System.currentTimeMillis() + "@gmail.com";
        User newUser = new User("Nhung", dynamicEmail, "123456", "Nhung", "Nguyen", "Q9", "India", "HCM", "HCM", "700000", "012345");
        Assert.assertTrue(homePage.clickLoginPage()
                                    .signUpNewUser(newUser)
                                    .registerNewUser(newUser)
                                    .displayAccountCreatedPage(),"Đăng ký thành công nhưng không chuyển sang trang Account Created page");
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        productPage.hoverAndClickAddProduct(2);
        handleGoogleAdIfNeeded();
        productPage.hoverAndClickAddProduct(4);
        handleGoogleAdIfNeeded();
        CartPage cartPage = productPage.moveToCartPage();
        OrderPage orderPage = cartPage.clickProceedToCheckoutLoggedIn();
        Assert.assertTrue(orderPage.isDisplayAddress(),"Khong hien thi");
        PaymentPage paymentPage = orderPage.enterCommentAndPlaceOrder("Khong co");
        paymentPage.enterPaymentDetails("000","23456789","234","12","2000");
        paymentPage.clickPayAndConfirmOrder();
        Assert.assertTrue(paymentPage.isOrderPlacedSuccessfully(),"Khong dat hang duoc");
        homePage.clickDeleteAccount();


    }

    @Test
    public void verifyAddressDetailsInCheckoutPage(){
        String name = "abc" + System.currentTimeMillis() + "@gmail.com";
        User newUser = new User("Nhung", name, "123456", "Nhung", "Nguyen", "Q9", "India", "HCM", "HCM", "700000", "012345");
        Assert.assertTrue(homePage.clickLoginPage()
                                    .signUpNewUser(newUser)
                                    .registerNewUser(newUser)
                                    .displayAccountCreatedPage(),"Đăng ký thành công nhưng không chuyển sang trang Account Created page");
        ProductPage productPage = homePage.clickProductButton();
        productPage.hoverAndClickAddProduct(1);
        handleGoogleAdIfNeeded();
        productPage.continueShopping();
        CartPage cartPage= homePage.moveToCartPage();
        Assert.assertTrue(cartPage.totalProductinCart() > 0, "Lỗi: Giỏ hàng trống!");
        OrderPage orderPage = cartPage.clickProceedToCheckoutLoggedIn();
        handleGoogleAdIfNeeded();
        String actualDelivery = orderPage.getDeliveryAddressText();
        String actualBilling = orderPage.getBillingAddressText();
        System.out.println("Đang kiểm tra delivery");
        Assert.assertTrue(actualDelivery.contains(newUser.getFirstName()), "Thiếu First Name");
        Assert.assertTrue(actualDelivery.contains(newUser.getLastName()), "Thiếu Last Name");
        Assert.assertTrue(actualDelivery.contains(newUser.getAddress()), "Thiếu Địa chỉ");
        Assert.assertTrue(actualDelivery.contains(newUser.getCity()), "Thiếu Thành phố");
        Assert.assertTrue(actualDelivery.contains(newUser.getPhone()), "Thiếu SĐT");

        System.out.println("Đang kiểm tra Billing");
        Assert.assertTrue(actualBilling.contains(newUser.getFirstName()), "Thiếu First Name");
        Assert.assertTrue(actualBilling.contains(newUser.getAddress()), "Thiếu Địa chỉ");
        Assert.assertTrue(actualBilling.contains(newUser.getCity()), "Thiếu Thành phố");
        homePage.clickDeleteAccount();
        System.out.println("Testcase đã hoàn thành");
    }
}

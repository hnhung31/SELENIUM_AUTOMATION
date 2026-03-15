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

import java.time.Duration;

public class CartTest extends BaseTest {
    @Test
    public void SendSubscriptionEmail(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage= homePage.clickCartButton();
        cartPage.SubscriptionEmail("h@gmail.com");
        Assert.assertEquals(cartPage.isDisplayedNotiSuccessful(),"You have been successfully subscribed!","Dang ki khong thanh cong");
    }

    @Test
    public void AddProductInCart(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        productPage.hoverAndClickAddProduct(2);
        handleGoogleAdIfNeeded();
        CartPage cartPage= productPage.moveToCartPage();
        int t = cartPage.totalProductinCart();
        Assert.assertEquals(t,1,"Tinh sai");
        verifyAccurate(cartPage,0);
        System.out.println("Kiểm tra giá, số lượng, tổng tiền của cả 2 sản phẩm đều CHÍNH XÁC!");


    }
    public void verifyAccurate(CartPage cartPage, int index){
        int price = cartPage.getPriceOfProduct(index);
        int quantity= cartPage.getQuantityOfProduct(index);
        int total = cartPage.getTotalPriceOfProduct(index);
        double result= price*quantity;
        Assert.assertEquals(total,result,"Tinh toan sai");
    }

    @Test
    public void removeProductsFromCart(){
        User user = new User("nhung@gmail.com","1234567890");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        productPage.hoverAndClickAddProduct(0);
        handleGoogleAdIfNeeded();
        productPage.continueShopping();
        productPage.hoverAndClickAddProduct(2);
        handleGoogleAdIfNeeded();
        CartPage cartPage= productPage.moveToCartPage();
        handleGoogleAdIfNeeded();
        cartPage.removeProductOutCart(0);
        handleGoogleAdIfNeeded();
        cartPage.removeProductOutCart(0);
    }

    @Test
    public void searchProductsAndVerifyCartAfterLogin(){
        User user = new User("nhung@gmail.com","1234567890");
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        productPage.searchProduct("dress");
        productPage.hoverAndClickAddProduct(0);
        handleGoogleAdIfNeeded();
        productPage.continueShopping();
        productPage.hoverAndClickAddProduct(1);
        handleGoogleAdIfNeeded();
        CartPage cartPage= productPage.moveToCartPage();
        int t = cartPage.totalProductinCart();
        Assert.assertEquals(t,2, "Khong khop");
        LoginPage loginPage = homePage.clickLoginPage();
        handleGoogleAdIfNeeded();
        loginPage.loginAction(user);
        cartPage = homePage.clickCartButton();
        Assert.assertEquals(t,2, "Khong khop");
    }

    @Test
    public void addToCartFromRecommendedItems(){
        HomePage homePage = new HomePage(driver);
        homePage.locateRecommendItem();
        homePage.addToCartByDynamic("Summer White Top");
        handleGoogleAdIfNeeded();
        homePage.continueShopping();
        CartPage cartPage = homePage.moveToCartPage();
        Assert.assertEquals(cartPage.totalProductinCart(),1,"Khong khop so luong them vao");

    }
}

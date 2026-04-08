package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductPage;
import pages.HomePage;
import pages.ProductPage;
import java.time.Duration;
@Epic("Automation Exercise Web")
@Feature("Quản lý sản phẩm")

public class ProductTest extends BaseTest {
    @Test
    public void viewAllProductSuccessful(){
        ProductPage productPage = homePage.clickProductButton();
        Assert.assertTrue(productPage.isDisplayAllProduct(),"Khong hien thi san pham");
    }

    @Test
    public void chooseProductByIndex(){
        ProductPage productPage = homePage.clickProductButton();
        productPage.viewProduct(0);

    }

    @Test
    public void viewProductDetailByDynamicXPath(){
        homePage.clickProductButton()
                .ProductViewDetailByXPathDynamic("Fancy Green Top");
    }

    /*@Test
    public void searchProductByName(){
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        productPage.searchProduct("Men tshirt");

        Assert.assertTrue(productPage.isDisplayedProduct(),"Khong hien product sau khi tim kiem");
    }*/

    @Test
    public void ViewCartBrandProducts(){
        ProductPage productPage = homePage.clickProductButton();
        handleGoogleAdIfNeeded();
        CategoryProductPage categoryProductPage= productPage.locateAndClickBrandProduct("Biba");
        Assert.assertEquals(categoryProductPage.getTitleCate(),"BRAND - BIBA PRODUCTS","Khong duoc");

    }
   
}




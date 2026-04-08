package testCases;

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

import java.time.Duration;

public class CategoryTest extends BaseTest {
    @Test
    public void viewCategoryProducts(){
        handleGoogleAdIfNeeded();
        Assert.assertTrue(homePage.isDisplayedCategory(),"Khong hien thi sidebar category");
        handleGoogleAdIfNeeded();
        CategoryProductPage categoryProductPage = homePage.chooseCategory("Women","Dress");
        handleGoogleAdIfNeeded();
        Assert.assertEquals(categoryProductPage.getTitleCate(),"WOMEN - DRESS PRODUCTS","khong co");

        HomePage leftSidebar = new HomePage(driver);
        handleGoogleAdIfNeeded();
        CategoryProductPage categoryProductPage1 = leftSidebar.chooseCategory("Kids","Tops & Shirts");
        Assert.assertEquals(categoryProductPage.getTitleCate(),"KIDS - TOPS & SHIRTS PRODUCTS","khong dc");
    }
}

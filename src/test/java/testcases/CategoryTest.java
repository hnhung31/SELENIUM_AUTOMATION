package testcases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryProductPage;
import pages.HomePage;

@Epic("Automation Exercise Web")
@Feature("Xem danh sách thể loại sản phẩm")

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




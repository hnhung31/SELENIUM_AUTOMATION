package testCases;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import bases.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.HomePage;
import pages.ProductViewDetailPage;
@Epic("Automation Exercise Web")
@Feature("Xem chi tiết sản phẩm và đánh giá sản phẩm")

public class ProductViewDetailTest extends BaseTest {
    @Test
    public void TestEditNumberOfProductInCart(){
        ProductViewDetailPage pr = homePage.viewDetailProduct("Sleeveless Unicorn Print Fit & Flare Net Dress - Multi");
        pr.editNumberOfProduct(4);
        CartPage cartPage = pr.moveToCartPage();
        int quantity = cartPage.getQuantityOfProduct(0);
        Assert.assertEquals(quantity,4,"Khong them san pham vao gio hang duoc");
    }
    @Test
    public  void addReviewOnProduct(){
        ProductViewDetailPage productViewDetailPage = homePage.viewDetailProduct("Sleeveless Dress");
        Assert.assertTrue(productViewDetailPage.isDisplayReviewSection(),"Khong co phan reivew");
        handleGoogleAdIfNeeded();
        productViewDetailPage.clickAndEnterReview("nhung","nhung@mail","San pham nay tot, nhung ma huong dan cach giat khong ro rang lam.");
        String review = productViewDetailPage.isDisplaySentReviewSuccessful();
        String expectedRe = "Thank you for your review.";
        Assert.assertEquals(review,expectedRe,"Gui danh gia khong thanh cong");

    }
}




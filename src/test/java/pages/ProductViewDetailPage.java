package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductViewDetailPage extends BasePage {
    public ProductViewDetailPage(WebDriver driver){
        super(driver);
    }
    private By txtQuantityProduct = By.id("quantity");
    private By btnAddToCart = By.cssSelector(".cart");

    private By popUpAdded = By.cssSelector(".modal .modal-dialog");
    private By lnkViewCart = By.xpath("//div[@id='cartModal']//a[@href='/view_cart']");
    private By btnContinueShopping = By.xpath("//button[@data-dismiss='modal']");

    public void editNumberOfProduct(int number){
        enterText(txtQuantityProduct, String.valueOf(number));
        clickElement(btnAddToCart);
    }
    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        clickElement(btnContinueShopping);
    }
    public CartPage moveToCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        clickElement(lnkViewCart);
        return new CartPage(driver);
    }
    private By lblWriteReview = By.xpath("//a[@data-toggle='tab']");
    private By txtName = By.id("name");
    private By txtEmail = By.id("email");
    private By txtReview = By.id("review");
    private By btnSubmit = By.id("button-review");
    private By lblReviewSuccess = By.xpath("//span[text()='Thank you for your review.']");

    public void clickAndEnterReview(String name, String email, String review){
        enterText(txtName, name);
        enterText(txtEmail, email);
        enterText(txtReview, review);
        clickElement(btnSubmit);
    }

    public boolean isDisplayReviewSection(){
        return isElementDisplayed(lblWriteReview);
    }
    public String isDisplaySentReviewSuccessful(){
        return getTextElement(lblReviewSuccess);
    }
}

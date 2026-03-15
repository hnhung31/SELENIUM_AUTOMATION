package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductViewDetailPage {
    private WebDriver driver;
    WebDriverWait wait;
    public ProductViewDetailPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    private By txtQuantityProduct = By.id("quantity");
    private By btnAddToCart = By.cssSelector(".cart");

    private By popUpAdded = By.cssSelector(".modal .modal-dialog");
    private By lnkViewCart = By.xpath("//div[@id='cartModal']//a[@href='/view_cart']");
    private By btnContinueShopping = By.xpath("//button[@data-dismiss='modal']");

    public void editNumberOfProduct(int number){
        driver.findElement(txtQuantityProduct).clear();
        driver.findElement(txtQuantityProduct).sendKeys(String.valueOf(number));
        driver.findElement(btnAddToCart).click();
    }
    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
    }
    public CartPage moveToCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        wait.until(ExpectedConditions.elementToBeClickable(lnkViewCart)).click();
        return new CartPage(driver);
    }
    private By lblWriteReview = By.xpath("//a[@data-toggle='tab']");
    private By txtName = By.id("name");
    private By txtEmail = By.id("email");
    private By txtReview = By.id("review");
    private By btnSubmit = By.id("button-review");
    private By lblReviewSuccess = By.xpath("//span[text()='Thank you for your review.']");

    public void clickAndEnterReview(String name, String email, String review){
        driver.findElement(txtName).sendKeys(name);
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtReview).sendKeys(review);
        driver.findElement(btnSubmit).click();
    }

    public boolean isDisplayReviewSection(){
        return driver.findElement(lblWriteReview).isDisplayed();
    }
    public String isDisplaySentReviewSuccessful(){
        return driver.findElement(lblReviewSuccess).getText();
    }
}

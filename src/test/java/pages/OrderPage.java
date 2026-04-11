package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.time.Duration;

public class OrderPage  extends BasePage {
    public OrderPage(WebDriver driver){
        super(driver);
    }
    private By addressDelivery = By.id("address_delivery");
    private By txtMessage = By.name("message");
    private By btnPlaceOrder = By.xpath("//a[@href='/payment']");

    private By addressDeliveryBlock = By.id("address_delivery");
    private By addressBillingBlock = By.id("address_invoice");

    public boolean isDisplayAddress(){
        return isElementDisplayed(addressDelivery);
    }

    public PaymentPage enterCommentAndPlaceOrder(String comment) {
        enterText(txtMessage, comment);
        WebElement placeOrderLnk = wait.until(ExpectedConditions.presenceOfElementLocated(btnPlaceOrder));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", placeOrderLnk);
        
        return new PaymentPage(driver);
    }

    public String getDeliveryAddressText() {
        return getTextElement(addressDeliveryBlock);
    }

    public String getBillingAddressText() {
        return getTextElement(addressBillingBlock);
    }



}

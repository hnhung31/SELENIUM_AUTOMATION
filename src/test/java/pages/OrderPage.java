package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage {
    private WebDriver driver;
    private WebDriverWait wait;
    public OrderPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    }
    private By addressDelivery = By.id("address_delivery");
    private By txtMessage = By.name("message");
    private By btnPlaceOrder = By.xpath("//a[@href='/payment']");

    private By addressDeliveryBlock = By.id("address_delivery");
    private By addressBillingBlock = By.id("address_invoice");

    public boolean isDisplayAddress(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement addressElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("address_delivery")));
        return driver.findElement(addressDelivery).isDisplayed();
    }

    public PaymentPage enterCommentAndPlaceOrder(String comment) {
        driver.findElement(txtMessage).sendKeys(comment);
        driver.findElement(btnPlaceOrder).click();
        return new PaymentPage(driver);
    }

    public String getDeliveryAddressText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressDeliveryBlock));
        return driver.findElement(addressDeliveryBlock).getText();
    }

    public String getBillingAddressText() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(addressBillingBlock));
        return driver.findElement(addressBillingBlock).getText();
    }



}

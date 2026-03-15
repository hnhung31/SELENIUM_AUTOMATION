package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    private WebDriver driver;
    private  WebDriverWait wait;
    public PaymentPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    private By txtName = By.xpath("//input[@data-qa='name-on-card']");
    private By txtCard = By.name("card_number");
    private By txtCvc = By.name("cvc");
    private By txtExpiration = By.name("expiry_month");
    private By txtYear = By.name("expiry_year");
    private By btnSubmit = By.id("submit");
    private By successMessage = By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
    private By btnDownload = By.xpath("//a[text()='Download Invoice']");
    public void enterPaymentDetails(String name, String cardNum, String cvc, String expMonth, String expYear) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(txtName));
        nameInput.sendKeys(name);
        driver.findElement(txtName).sendKeys(name);
        driver.findElement(txtCard).sendKeys(cardNum);
        driver.findElement(txtCvc).sendKeys(cvc);
        driver.findElement(txtExpiration).sendKeys(expMonth);
        driver.findElement(txtYear).sendKeys(expYear);
    }
    public void clickPayAndConfirmOrder() {
        WebElement btnsb = driver.findElement(btnSubmit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",btnsb);
        js.executeScript("arguments[0].click();",btnsb);
    }

    public boolean isOrderPlacedSuccessfully() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return driver.findElement(successMessage).isDisplayed();
    }
    public void clickDownloadButton(){
        driver.findElement(btnDownload).click();
    }

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage extends BasePage {
    public PaymentPage(WebDriver driver){
        super(driver);
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
        enterText(txtName, name);
        enterText(txtCard, cardNum);
        enterText(txtCvc, cvc);
        enterText(txtExpiration, expMonth);
        enterText(txtYear, expYear);    
    }
    public void clickPayAndConfirmOrder() {
        scrollToElement(btnSubmit);
        clickElement(btnSubmit);
    }

    public boolean isOrderPlacedSuccessfully() {
        try {
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickDownloadButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnDownload));
        clickElement(btnDownload);
    }

}

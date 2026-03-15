package pages;

import models.ContactUs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;

    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    private By txtName = By.xpath("//input[@data-qa='name']");
    private By txtEmail = By.xpath("//input[@data-qa='email']");
    private By txtSubject = By.xpath("//input[@data-qa='subject']");
    private By txtMessage = By.id("message");
    private By iconUpload = By.name("upload_file");
    private By btnSubmit = By.xpath("//input[@data-qa='submit-button']");
    private By notiSendContactSuccessful = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");

    public ContactUsPage conductContactUs(ContactUs contactUs){
        driver.findElement(txtName).sendKeys(contactUs.getName());
        driver.findElement(txtEmail).sendKeys(contactUs.getEmail());
        driver.findElement(txtSubject).sendKeys(contactUs.getSubject());
        driver.findElement(txtMessage).sendKeys(contactUs.getMessage());
        driver.findElement(iconUpload).sendKeys(contactUs.getUploadFile());
        WebElement submitButton = driver.findElement(btnSubmit);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
        js.executeScript("arguments[0].click();", submitButton);
        return new ContactUsPage(driver);
    }
    public boolean sendNoti(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(notiSendContactSuccessful));
        return driver.findElement(notiSendContactSuccessful).isDisplayed();
    }
    
    public void handleAlertOk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void handleAlterCancel(){
        Alert alter = driver.switchTo().alert();
        alter.dismiss();
    }



}

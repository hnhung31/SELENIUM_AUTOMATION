package pages;

import models.ContactUs;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver){
        super(driver);
    }

    private By txtName = By.xpath("//input[@data-qa='name']");
    private By txtEmail = By.xpath("//input[@data-qa='email']");
    private By txtSubject = By.xpath("//input[@data-qa='subject']");
    private By txtMessage = By.id("message");
    private By iconUpload = By.name("upload_file");
    private By btnSubmit = By.xpath("//input[@data-qa='submit-button']");
    private By notiSendContactSuccessful = By.xpath("//div[contains(text(),'Success! Your details have been submitted successfully.')]");

    public ContactUsPage conductContactUs(ContactUs contactUs){
        enterText(txtName, contactUs.getName());
        enterText(txtEmail, contactUs.getEmail());
        enterText(txtSubject, contactUs.getSubject());
        enterText(txtMessage, contactUs.getMessage());
        driver.findElement(iconUpload).sendKeys(contactUs.getUploadFile());
        scrollToElement(btnSubmit);
        clickElement(btnSubmit);
        return new ContactUsPage(driver);
    }
    public boolean sendNoti(){
        return isElementDisplayed(notiSendContactSuccessful);
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

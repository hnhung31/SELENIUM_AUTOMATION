package testCases;

import bases.BaseTest;
import models.ContactUs;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;

import java.time.Duration;

public class ContactUsTest extends BaseTest {
    java.io.File uploadFile = new java.io.File("src/test/resources/dssf.html");
    String absolutePath = uploadFile.getAbsolutePath();
    @Test
    public void sendFeedbackSuccessful(){
        HomePage homePage = new HomePage(driver);
        ContactUs contactUs = new ContactUs("h","abcd@gnhm","hhh","hhh",absolutePath);
        ContactUsPage contact = homePage.clickContactUs();
        handleGoogleAdIfNeeded();
        contact.conductContactUs(contactUs);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        contact.handleAlertOk();
        Assert.assertTrue(contact.sendNoti(),"Khong gui send successful");
    }

}

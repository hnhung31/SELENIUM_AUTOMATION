package testcases;

import dataprovider.ContactUsData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;

import bases.BaseTest;
import models.ContactUs;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

import java.time.Duration;

@Epic("Automation Exercise Web")
@Feature("Quản lý chức năng Liên hệ với chúng tôi")

public class ContactUsTest extends BaseTest {
    @Test(dataProvider = "getContactUsSuccessful", dataProviderClass = ContactUsData.class)
    public void testSendFeedbackSuccessful(ContactUs contactUs){
        ContactUsPage contact = homePage.clickContactUs();
        handleGoogleAdIfNeeded();
        contact.conductContactUs(contactUs);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        contact.handleAlertOk();
        Assert.assertTrue(contact.sendNoti(),"Khong gui send successful");
    }
    @Test(dataProvider = "getContactUsDataWithInvalidField", dataProviderClass = ContactUsData.class)
    public void testSendFeedbackUnsuccessful(ContactUs contactUs, String message){
        ContactUsPage contact = homePage.clickContactUs();
        handleGoogleAdIfNeeded();
        contact.conductContactUs(contactUs);
        String actualMessage = driver.findElement(By.xpath("//input[@data-qa='email']")).getAttribute("validationMessage");
        Assert.assertTrue(actualMessage.contains(message),"Khong xử lý trường hợp fail được");
    }

    @Test(dataProvider = "getContactUsSuccessful", dataProviderClass = ContactUsData.class)
    public void testCancelAlertAfterSubmit(ContactUs contactUs){
        ContactUsPage contact = homePage.clickContactUs();
        handleGoogleAdIfNeeded();
        contact.conductContactUs(contactUs);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.alertIsPresent());
        contact.handleAlterCancel();
        Assert.assertFalse(contact.sendNoti(),"Lỗi: Đã cancel nhưng vẫn gửi thành công");
    }


}




package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions; // Dòng này bị thiếu
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;
    HomePage homePage;


    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options); // Truyền options vào ChromeDriver
        driver.navigate().to("https://automationexercise.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        handleGoogleAdIfNeeded(); 
    }

    @AfterMethod
    public void testQuit(){
        driver.quit();
    }

    public void handleGoogleAdIfNeeded() {
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement adIframe = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@id, 'aswift_')]")));
            driver.switchTo().frame(adIframe);

            try {
                WebElement adIframe2 = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.id("ad_iframe")));
                driver.switchTo().frame(adIframe2);
            } catch (Exception e) {
            }

            WebElement closeButton = shortWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='dismiss-button']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", closeButton);

        } catch (Exception e) {
        } finally {
            driver.switchTo().defaultContent();
        }
    }


}




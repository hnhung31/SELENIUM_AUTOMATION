package bases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions; 
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
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    public WebDriver driver;
    protected HomePage homePage;

    @BeforeMethod
    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--disable-features=IsolateOrigins,site-per-process");
        options.addArguments("--blink-settings=imagesEnabled=false"); 
        
        options.setPageLoadStrategy(org.openqa.selenium.PageLoadStrategy.EAGER); 
        options.addArguments("--disable-extensions");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); 
        
        driver.navigate().to("https://automationexercise.com/");
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




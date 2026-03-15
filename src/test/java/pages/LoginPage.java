package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    private By email = By.cssSelector("input[data-qa='login-email']");
    private By password = By.name("password");
    private By btnLogin = By.cssSelector("button[data-qa='login-button']");
    private By textErrorLogin = By.xpath("//p[contains(text(),'Your email or password is incorrect!')]");

    private By nameSignup = By.cssSelector("input[data-qa='signup-name']");
    private By emailSignup = By.xpath("//input[@data-qa='signup-email']");
    private By btnSignup = By.xpath("//button[@data-qa='signup-button']");
    private By lblLogin = By.xpath("//h2[contains(text(),'Login to your account')]");
    private By lblEmailExist = By.xpath("//p[contains(text(),'Email Address already exist!']");

    public HomePage loginAction(User user){
        driver.findElement(email).sendKeys(user.getEmail());
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(btnLogin).submit();
        return new HomePage(driver);
    }
    public boolean isErrorMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOfElementLocated(textErrorLogin));
        return driver.findElement(textErrorLogin).isDisplayed();
    }

    public RegisterPage signUpNewUser(User user){
        driver.findElement(nameSignup).sendKeys(user.getName());
        driver.findElement(emailSignup).sendKeys(user.getEmail());
        driver.findElement(btnSignup).submit();
        return new RegisterPage(driver);
    }
    public boolean containLabelLogin(){
        try {
            WebElement loginLabel = driver.findElement(lblLogin);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(loginLabel));
            return loginLabel.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEmailExist(){
        return driver.findElement(lblEmailExist).isDisplayed();
    }

}

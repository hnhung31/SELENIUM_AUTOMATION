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

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);    
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
        enterText(email, user.getEmail());
        enterText(password, user.getPassword());    
        clickElement(btnLogin);
        return new HomePage(driver);
    }
    public boolean isErrorMessage(){
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            longWait.until(ExpectedConditions.visibilityOfElementLocated(textErrorLogin));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public RegisterPage signUpNewUser(User user){
        enterText(nameSignup, user.getName());
        enterText(emailSignup, user.getEmail());
        clickElement(btnSignup);
        return new RegisterPage(driver);
    }
    public boolean containLabelLogin(){
        return isElementDisplayed(lblLogin);
    }

    public boolean isEmailExist(){
        return isElementDisplayed(lblEmailExist);
    }

}

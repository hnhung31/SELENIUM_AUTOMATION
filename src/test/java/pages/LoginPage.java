package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver){
        super(driver);    
    }

    private By email = By.cssSelector("input[data-qa='login-email']");
    private By password = By.name("password");
    private By btnLogin = By.cssSelector("button[data-qa='login-button']");

    private By nameSignup = By.cssSelector("input[data-qa='signup-name']");
    private By emailSignup = By.xpath("//input[@data-qa='signup-email']");
    private By btnSignup = By.xpath("//button[@data-qa='signup-button']");
    private By lblLogin = By.xpath("//h2[contains(text(),'Login to your account')]");
    private By lblEmailExist = By.xpath("//p[contains(text(),'Email Address already exist!')]");

    public HomePage loginActionSuccessful(User user){
        enterText(email, user.getEmail());
        enterText(password, user.getPassword());    
        clickElement(btnLogin);
        return new HomePage(driver);
    }

    public void loginActionUnsuccessful(User user){
        enterText(email, user.getEmail());
        enterText(password, user.getPassword());
        clickElement(btnLogin);
    }

    public RegisterPage signUpNewUserSuccessfulStep1(User user){
        enterText(nameSignup, user.getName());
        enterText(emailSignup, user.getEmail());
        clickElement(btnSignup);
        return new RegisterPage(driver);
    }
    public void signUpNewUserUnSuccessful(User user){
        enterText(nameSignup, user.getName());
        enterText(emailSignup, user.getEmail());
        clickElement(btnSignup);
    }
    public boolean containLabelLogin(){
        return isElementDisplayed(lblLogin);
    }

}

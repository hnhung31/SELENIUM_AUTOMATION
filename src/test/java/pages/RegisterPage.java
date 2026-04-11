package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Step;
public class RegisterPage extends BasePage {

    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    private By password = By.id("password");
    private By firstName = By.id("first_name");
    private By lastName = By.id("last_name");
    private By address = By.id("address1");
    private By country = By.id("country");
    private By state = By.id("state");
    private By city = By.id("city");
    private By zipCode = By.id("zipcode");
    private By phone = By.id("mobile_number");
    private By btnCreateUser = By.xpath("//button[@data-qa='create-account']");

    @Step("Registering new user with email: {0}")   
    public AccountCreatedPage registerNewUser(User user){
        enterText(password, user.getPassword());
        enterText(firstName, user.getFirstName());
        enterText(lastName, user.getLastName());
        enterText(address, user.getAddress());
        Select selectCountry = new Select(driver.findElement(country));
        selectCountry.selectByValue(user.getCountry());
        enterText(state, user.getState());
        enterText(city, user.getCity());
        enterText(zipCode, user.getZipCode());
        enterText(phone, user.getPhone());
        
        org.openqa.selenium.WebElement createBtn = wait.until(org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated(btnCreateUser));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", createBtn);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", createBtn);
        
        return new AccountCreatedPage(driver);
    }
}

package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.Step;
public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
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
        driver.findElement(password).sendKeys(user.getPassword());
        driver.findElement(firstName).sendKeys(user.getFirstName());
        driver.findElement(lastName).sendKeys(user.getLastName());
        driver.findElement(address).sendKeys(user.getAddress());
        Select selectCountry = new Select(driver.findElement(country));
        selectCountry.selectByValue(user.getCountry());
        driver.findElement(state).sendKeys(user.getState());
        driver.findElement(city).sendKeys(user.getCity());
        driver.findElement(zipCode).sendKeys(user.getZipCode());
        driver.findElement(phone).sendKeys(user.getPhone());
        driver.findElement(btnCreateUser).submit();
        return new AccountCreatedPage(driver);
    }
}

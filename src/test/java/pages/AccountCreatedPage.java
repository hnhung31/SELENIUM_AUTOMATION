package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage {
    private  WebDriver driver;

    public  AccountCreatedPage(WebDriver driver){
        this.driver = driver;
    }
    private By lblAccountCreate = By.xpath("//b[contains(text(),'Account Created!')]");
    public boolean displayAccountCreatedPage(){
        return driver.findElement(lblAccountCreate).isDisplayed();
    }
}

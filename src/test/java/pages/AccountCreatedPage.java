package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountCreatedPage extends BasePage {
    public AccountCreatedPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By accountCreatedMessage = By.xpath("//b[contains(text(),'Account Created!')]");
    private final By continueButton = By.xpath("//a[@data-qa='continue-button']");

    public boolean displayAccountCreatedPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountCreatedMessage));
        return driver.findElement(accountCreatedMessage).isDisplayed();
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }
}

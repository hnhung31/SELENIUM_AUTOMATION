package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CategoryProductPage extends BasePage {
    public CategoryProductPage(WebDriver driver){
        super(driver);
    }
    private By locaTitle = By.xpath("//h2[@class='title text-center']");

    public String getTitleCate(){
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        longWait.until(ExpectedConditions.visibilityOfElementLocated(locaTitle));
        return getTextElement(locaTitle);
    }


}

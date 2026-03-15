package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CategoryProductPage {
    private WebDriver driver;

    public CategoryProductPage(WebDriver driver){
        this.driver = driver;
    }
    private By locaTitle = By.xpath("//h2[@class='title text-center']");

    public String getTitleCate(){
        return driver.findElement(locaTitle).getText();
    }


}

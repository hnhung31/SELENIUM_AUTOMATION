package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestcasePage {
    private WebDriver driver;

    public TestcasePage(WebDriver driver){
        this.driver = driver;
    }
    private By lblTestcase = By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']");

    public boolean displayTestcase(){
        return driver.findElement(lblTestcase).isDisplayed();
    }
}

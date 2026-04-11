package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TestcasePage extends BasePage {

    public TestcasePage(WebDriver driver){
        super(driver);
    }
    private By lblTestcase = By.xpath("//span[text()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']");

    public boolean displayTestcase(){
        return isElementDisplayed(lblTestcase);
    }
}

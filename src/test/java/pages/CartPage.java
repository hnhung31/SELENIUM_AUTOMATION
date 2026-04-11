package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver){
        super(driver);
    }

    private By txtSubEmail = By.id("susbscribe_email");
    private By btnSubEmail = By.id("subscribe");
    private By alertNoti = By.xpath("//div[@class='alert-success alert']");
    public void SubscriptionEmail(String email){
        enterText(txtSubEmail, email);
        clickElement(btnSubEmail);
    }

    public String isDisplayedNotiSuccessful(){
        return getTextElement(alertNoti);
    }

    private By cartRows = By.xpath("//tbody/tr");
    private By price = By.xpath("./td[@class='cart_price']/p");
    private By quantity = By.xpath("./td[@class='cart_quantity']/button");
    private By totalPrice = By.xpath("./td[@class='cart_total']/p");
    private By btnCheckout = By.xpath("//a[text()='Proceed To Checkout']");
    private By btnRemove = By.xpath("//a[@class='cart_quantity_delete']");

    public int totalProductinCart(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement t = driver.findElement(cartRows);
        try{
            List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartRows));
            return list.size();
        } catch (Exception e) {
            return 0;
        }
    }
    public int getPriceOfProduct( int index){
        List<WebElement> list = driver.findElements(cartRows);
        String t =list.get(index).findElement(price).getText();
        return Integer.parseInt(t.replace("Rs. ","").trim());
    }
    public int getQuantityOfProduct( int index){
        List<WebElement> list = driver.findElements(cartRows);
        String t = list.get(index).findElement(quantity).getText();
        return Integer.parseInt(t.trim());
    }
    public int getTotalPriceOfProduct( int index){
        List<WebElement> list = driver.findElements(cartRows);
        String t = list.get(index).findElement(totalPrice).getText();
        return Integer.parseInt(t.replace("Rs. ","").trim());
    }
    private By lnkRegisterOnModal = By.xpath("//div[@id='checkoutModal']//a[@href='/login']");
    private By modalCheckoutBefore = By.id("checkoutModal");

    public void clickProceedToCheckout() {
        WebElement checkoutBtn = driver.findElement(btnCheckout);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", checkoutBtn);
    }

    public LoginPage clickRegisterLoginOnModal() {
        clickElement(lnkRegisterOnModal);
        return new LoginPage(driver);
    }

    public OrderPage clickProceedToCheckoutLoggedIn() {
        WebElement proceedBtn = driver.findElement(btnCheckout);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", proceedBtn);

        return new OrderPage(driver);
    }

    public void removeProductOutCart(int index){
        List<WebElement> list = driver.findElements(btnRemove);
        list.get(index).click();
    }

}

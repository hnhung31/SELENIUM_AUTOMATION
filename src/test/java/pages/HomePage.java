package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private  WebDriver driver;
    private By lnkLogin = By.cssSelector("a[href='/login']");
    private By loggedAs = By.xpath("//li/a[contains(text(), 'Logged in as')]");
    private By lnkLogOut = By.cssSelector("a[href='/logout']");
    private By btnContactUs = By.cssSelector("a[href='/contact_us']");
    private By btnTestcase = By.xpath("//a[@href='/test_cases']");
    private By btnProduct = By.cssSelector("a[href='/products']");
    private By txtSubscriptionEmail = By.id("susbscribe_email");
    private By btnSubscriptionEmail = By.id("subscribe");
    private By alertNotiSendEmail = By.xpath("//div[@class='alert-success alert']");
    private By btnCart = By.cssSelector("a[href='/view_cart']");
    private By menuDeleteAccount = By.xpath("//ul[@class='nav navbar-nav']//a[@href='/delete_account']");
    private By locaSideBar = By.id("accordian");
    private By lblRecommendItem = By.xpath("//h2[text()='recommended items']");
    private By popUpAdded = By.cssSelector(".modal .modal-dialog");
    private By lnkViewCart = By.xpath("//div[@id='cartModal']//a[@href='/view_cart']");
    private By btnContinueShopping = By.xpath("//button[@data-dismiss='modal']");
    private By btnScrollUp = By.id("scrollUp");
    private By txtFullFledged = By.xpath("//h2[contains(text(),'Full-Fledged practice website')]");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public LoginPage clickLoginPage(){
        driver.findElement(lnkLogin).click();
        return new LoginPage(driver);
    }

    public boolean isDisplayedUser() {
        try {
            WebElement loggedInUser = driver.findElement(loggedAs);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(loggedInUser));
            return loggedInUser.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public LoginPage logOutAction(){
        driver.findElement(lnkLogOut).click();
        return new LoginPage(driver);
    }

    public ContactUsPage clickContactUs(){
        driver.findElement(btnContactUs).click();
        return new ContactUsPage(driver);
    }

    public TestcasePage clickTestCaseButton(){
        driver.findElement(btnTestcase).click();
        return new TestcasePage(driver);
    }

    public ProductPage clickProductButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnProduct));
        driver.findElement(btnProduct).click();
        return new ProductPage(driver);
    }

    public void SubscriptionEmail(String email){
        WebElement email1 = driver.findElement(txtSubscriptionEmail);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",email1);

        email1.sendKeys(email);
        driver.findElement(btnSubscriptionEmail).click();
    }

    public String handleNotiSubscriptionEmail(){
        return driver.findElement(alertNotiSendEmail).getText();
    }

    public CartPage clickCartButton(){
        driver.findElement(btnCart).click();
        return new CartPage(driver);
    }

    public ProductViewDetailPage viewDetailProduct(String name){
        String locator = String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]",name);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement loca = driver.findElement(By.xpath(locator));
        js.executeScript("arguments[0].scrollIntoView(true)",loca);
        js.executeScript("arguments[0].click();",loca);
        return new ProductViewDetailPage(driver);
    }

    public void clickDeleteAccount() {
        driver.findElement(menuDeleteAccount).click();
    }

    public boolean isDisplayedCategory(){
        return driver.findElement(locaSideBar).isDisplayed();
    }

    public CategoryProductPage chooseCategory(String mainCate, String subCate){
        String dynamicXpath = String.format("//a[normalize-space()='%s']",mainCate);
        WebElement mainLink = driver.findElement(By.xpath(dynamicXpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", mainLink);

        String dynamicSubCate = String.format("//div[@id='%s']//a[contains(text(),'%s')]",mainCate,subCate);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement subLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicSubCate)));
        js.executeScript("arguments[0].click();", subLink);
        return new CategoryProductPage(driver);
    }

    public void locateRecommendItem(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement t = driver.findElement(lblRecommendItem);
        js.executeScript("arguments[0].scrollIntoView(true);",t);

    }

    public void addToCartByDynamic(String productName){
        String dynamicProduct = String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']/ancestor::div[@class='carousel-inner']//a[@class='btn btn-default add-to-cart']",productName);
        WebElement product = driver.findElement(By.xpath(dynamicProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",product);
        js.executeScript("arguments[0].click();",product);
    }

    public void continueShopping(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
    }

    public CartPage moveToCartPage(){
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        WebElement viewCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(lnkViewCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCartBtn);
        return new CartPage(driver);
    }

    public void clickScrollUpButton(){
        driver.findElement(btnScrollUp).click();
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    public void clickScrollUpArrow() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement arrow = wait.until(ExpectedConditions.elementToBeClickable(btnScrollUp));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", arrow);
    }


    public boolean isAtTopOfPage() {
    JavascriptExecutor js = (JavascriptExecutor) driver;

    Long scrollPosition = (Long) js.executeScript(
            "return window.pageYOffset;"
    );

    return scrollPosition == 0;
}

    public boolean isTopTextVisible() {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(txtFullFledged)).isDisplayed();
    }
    public void scrollToTopWithoutArrow() {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollTo(0, 0)");
}




}










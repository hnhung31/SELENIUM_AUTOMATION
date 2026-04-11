package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage extends BasePage {
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
        super(driver);
    }

    public LoginPage clickLoginPage(){
        WebElement loginLnk = wait.until(ExpectedConditions.presenceOfElementLocated(lnkLogin));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginLnk);
        return new LoginPage(driver);
    }

    public boolean isDisplayedUser() {
        return isElementDisplayed(loggedAs);
    }

    public LoginPage logOutAction(){
        WebElement logoutLnk = wait.until(ExpectedConditions.presenceOfElementLocated(lnkLogOut));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutLnk);
        return new LoginPage(driver);
    }

    public ContactUsPage clickContactUs(){
        WebElement contactLnk = wait.until(ExpectedConditions.presenceOfElementLocated(btnContactUs));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", contactLnk);
        return new ContactUsPage(driver);
    }

    public TestcasePage clickTestCaseButton(){
        WebElement testcaseLnk = wait.until(ExpectedConditions.presenceOfElementLocated(btnTestcase));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", testcaseLnk);
        return new TestcasePage(driver);
    }

    public ProductPage clickProductButton(){
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement productLnk = longWait.until(ExpectedConditions.visibilityOfElementLocated(btnProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productLnk);
        return new ProductPage(driver);
    }

    public void SubscriptionEmail(String email){
        scrollToElement(txtSubscriptionEmail);
        enterText(txtSubscriptionEmail, email);
        clickElement(btnSubscriptionEmail);
    }

    public String handleNotiSubscriptionEmail(){
        return getTextElement(alertNotiSendEmail);
    }

    public CartPage clickCartButton(){
        WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        WebElement cartLnk = longWait.until(ExpectedConditions.visibilityOfElementLocated(btnCart));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLnk);
        return new CartPage(driver);
    }

    public ProductViewDetailPage viewDetailProduct(String name){
        String locatorXpath = String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]",name);
        By locator = By.xpath(locatorXpath);
        scrollToElement(locator);
        
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", product);
        
        return new ProductViewDetailPage(driver);
    }

    public void clickDeleteAccount() {
        WebElement deleteLnk = wait.until(ExpectedConditions.presenceOfElementLocated(menuDeleteAccount));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteLnk);
    }

    public boolean isDisplayedCategory(){
        return isElementDisplayed(locaSideBar);
    }

    public CategoryProductPage chooseCategory(String mainCate, String subCate){
        String dynamicXpath = String.format("//a[normalize-space()='%s']",mainCate);
        By mainLocator = By.xpath(dynamicXpath);
        scrollToElement(mainLocator);
        
        WebElement mainLink = wait.until(ExpectedConditions.presenceOfElementLocated(mainLocator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", mainLink);

        String dynamicSubCate = String.format("//div[@id='%s']//a[contains(text(),'%s')]",mainCate,subCate);
        By subLocator = By.xpath(dynamicSubCate);
        WebElement subLink = wait.until(ExpectedConditions.visibilityOfElementLocated(subLocator));
        js.executeScript("arguments[0].click();", subLink);
        
        return new CategoryProductPage(driver);
    }

    public void locateRecommendItem(){
        scrollToElement(lblRecommendItem);
    }

    public void addToCartByDynamic(String productName){
        String dynamicProduct = String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']/ancestor::div[@class='carousel-inner']//a[@class='btn btn-default add-to-cart']",productName);
        By locator = By.xpath(dynamicProduct);
        scrollToElement(locator);
        
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", product);
    }

    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        
        WebElement continueBtn = wait.until(ExpectedConditions.presenceOfElementLocated(btnContinueShopping));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", continueBtn);
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpAdded));
    }

    public CartPage moveToCartPage(){
        WebElement viewCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(lnkViewCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCartBtn);
        return new CartPage(driver);
    }

    public void clickScrollUpButton(){
        WebElement btn = wait.until(ExpectedConditions.visibilityOfElementLocated(btnScrollUp));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", btn);
    }

    public void scrollToBottom() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    
    public void clickScrollUpArrow() {
        WebElement arrow = wait.until(ExpectedConditions.visibilityOfElementLocated(btnScrollUp));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", arrow);
    }

    public boolean isAtTopOfPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scrollPosition = (Long) js.executeScript("return window.pageYOffset;");
        return scrollPosition == 0;
    }

    public boolean isTopTextVisible() {
        try {
            WebDriverWait longWait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return longWait.until(ExpectedConditions.visibilityOfElementLocated(txtFullFledged)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void scrollToTopWithoutArrow() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0)");
    }
}










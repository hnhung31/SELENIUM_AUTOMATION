package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait ;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private By lbAllProduct = By.xpath("//h2[text()='All Products']");
    private By btnViewProducts = By.xpath("//div[@class='choose']//a");
    private By txtSearchProduct = By.id("search_product");
    private By btnSearch = By.id("submit_search");
    private By cardProductDisplay = By.xpath("//div[@class='col-sm-4']");

    public boolean isDisplayAllProduct(){
        return driver.findElement(lbAllProduct).isDisplayed();
    }

    public ProductViewDetailPage viewProduct(int index){
        wait =  new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(btnViewProducts));

        List<WebElement> listProduct = driver.findElements(btnViewProducts);
        if(index >= listProduct.size()){
            System.out.println("Khong co san pham thu: " + index );
        } else{
            WebElement product1 = listProduct.get(index);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", product1);
            js.executeScript("arguments[0].click();", product1);
        }
        return new ProductViewDetailPage(driver);
    }

    public ProductViewDetailPage ProductViewDetailByXPathDynamic(String productName){
        String dynamicProduct = String.format("//p[text()='%s']/ancestor::div[@class='product-image-wrapper']//a[contains(text(),'View Product')]",productName);
        WebElement product = driver.findElement(By.xpath(dynamicProduct));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",product);
        js.executeScript("arguments[0].click();",product);
        return new ProductViewDetailPage(driver);
    }

    public void searchProduct(String name){
        driver.findElement(txtSearchProduct).sendKeys(name);
        driver.findElement(btnSearch).click();
    }

    public boolean isDisplayedProduct(){
        WebElement card = driver.findElement(cardProductDisplay);
        return card.isDisplayed();
    }

    private By cartModalProduct = By.xpath("//div[@class='product-image-wrapper']");
    private By btnAddToCart = By.cssSelector(".overlay-content .add-to-cart");
    private By popUpAdded = By.cssSelector(".modal .modal-dialog");
    private By lnkViewCart = By.xpath("//div[@id='cartModal']//a[@href='/view_cart']");
    private By btnContinueShopping = By.xpath("//button[@data-dismiss='modal']");

    public void hoverAndClickAddProduct( int index){
        List<WebElement> products = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(cartModalProduct));
        List<WebElement> listbtnAddToCart = driver.findElements(btnAddToCart);

        Actions actions = new Actions(driver);
        actions.moveToElement(products.get(index)).perform();

        WebElement btnToClick = listbtnAddToCart.get(index);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", btnToClick);
        js.executeScript("arguments[0].click();", btnToClick);
    }
    public void continueShopping(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        wait.until(ExpectedConditions.elementToBeClickable(btnContinueShopping)).click();
    }
    public CartPage moveToCartPage(){
        WebElement viewCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(lnkViewCart));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCartBtn);
        return new CartPage(driver);
    }

    public CategoryProductPage locateAndClickBrandProduct(String brand){
        String dynamicBrand = String.format("//div[@class='brands-name']//a[@href='/brand_products/%s']",brand);
        WebElement xs = driver.findElement(By.xpath(dynamicBrand));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);",xs);
        js.executeScript("arguments[0].click();",xs);
        return new CategoryProductPage(driver);
    }

}

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

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver){
        super(driver);
    }

    private By lbAllProduct = By.xpath("//h2[text()='All Products']");
    private By btnViewProducts = By.xpath("//div[@class='choose']//a");
    private By txtSearchProduct = By.id("search_product");
    private By btnSearch = By.id("submit_search");
    private By cardProductDisplay = By.xpath("//div[@class='col-sm-4']");

    public boolean isDisplayAllProduct(){
        return isElementDisplayed(lbAllProduct);
    }

    public ProductViewDetailPage viewProduct(int index){
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
        By locator = By.xpath(dynamicProduct);
        
        WebElement product = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", product);
        js.executeScript("arguments[0].click();", product);
        
        return new ProductViewDetailPage(driver);
    }

    public void searchProduct(String name){
        enterText(txtSearchProduct, name);
        clickElement(btnSearch);
    }

    public boolean isDisplayedProduct(){
        return isElementDisplayed(cardProductDisplay);
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
        WebElement btnShop = wait.until(ExpectedConditions.presenceOfElementLocated(btnContinueShopping));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", btnShop); 
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpAdded));
    }
    
    public CartPage moveToCartPage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(popUpAdded));
        WebElement viewCartBtn = wait.until(ExpectedConditions.presenceOfElementLocated(lnkViewCart));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", viewCartBtn);
        
        wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpAdded));
        return new CartPage(driver);
    }

    public CategoryProductPage locateAndClickBrandProduct(String brand){
        String dynamicBrand = String.format("//div[@class='brands-name']//a[@href='/brand_products/%s']",brand);
        By locator = By.xpath(dynamicBrand);
        
        scrollToElement(locator);
        
        WebElement brandLink = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", brandLink);
        
        return new CategoryProductPage(driver);
    }

}

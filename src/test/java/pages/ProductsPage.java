package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    String productName;
    private final By TITLE = By.cssSelector(".title");
    private final By CART = By.cssSelector(".shopping_cart_link");
    public ProductsPage(WebDriver driver){
        super(driver);
    }
    public String getTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE));
        return driver.findElement(TITLE).getText();
    }
    public void clickAddButton(String productName){
        By ADD_BUTTON = By.xpath("//div[text() = '" + productName + "']/" +
                "ancestor::div[@class = 'inventory_item']//button");
        driver.findElement(ADD_BUTTON).click();
    }
    public void clickShoppingCart(){
        driver.findElement(CART).click();
    }
}
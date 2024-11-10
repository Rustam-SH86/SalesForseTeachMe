import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LocatorTest extends BaseTest {
    @Test
    public void locatorTest() {
        Actions actions = new Actions(driver);
        driver.get("https://www.saucedemo.com/");
        WebElement user = driver.findElement(By.id("user-name"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement addToCartButton = driver.findElement(By.name("add-to-cart-sauce-labs-backpack"));
        WebElement title = driver.findElement(By.className("login_logo"));
        WebElement sortProductButton = driver.findElement(By.tagName("select"));
        WebElement sauceLabsBackpackLinkButton = driver.findElement(By.linkText("Sauce Labs Backpack"));
        WebElement sauceLabsOnesieLinkButton = driver.findElement(By.partialLinkText("Onesie"));
        WebElement shoppingCart = driver.findElement(By.xpath("//select[@class='product_sort_container']"));
        WebElement submitButton = driver.findElement(By.cssSelector(".submit-button.btn_action"));

        actions.click(user).sendKeys("standard_user").perform();
        actions.click(password).sendKeys("secret_sauce").perform();
        submitButton.click();
        String secondPageTitle = driver.findElement(By.cssSelector(".title")).getText();
        assertEquals(secondPageTitle, "Products");
    }
}

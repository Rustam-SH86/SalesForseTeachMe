package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    public final By CHECKOUT_BUTTON = (By.id("checkout"));
    public final By CONTINUE_SHOPPING = (By.id("continue-shopping"));
    public final By YOUR_CART_TITLE = (By.cssSelector(".title"));

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(BASE_URL + "cart.html");
    }

    public boolean isProductInCart(String product) {
        return driver.findElement(By.xpath(String.format("//*[@class = 'cart_item']//*[text() = '%s']", product))).isDisplayed();
    }

    public boolean isProductRemovedFromCart(String product) {
        List<WebElement> elements = driver.findElements(By.xpath(String.format("//*[@class = 'cart_item']//*[text() = '%s']",
                product)));
        return elements.isEmpty();
    }

    public String getProductPrice(String productName) {
        By priceLocator = By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::" +
                "div[@class='cart_item']//button[contains(@class, 'cart_button')]", productName));
        return driver.findElement(priceLocator).getText();
    }

    public void removeProductFromCart(String productName) {
        By removeButton = By.xpath(String.format("//*[contains(text(), '%s')]/ancestor::div[@class='cart_item']" +
                "//button[contains(@class, 'cart_button')]", productName));
        driver.findElement(removeButton).click();
    }

    public ArrayList<String> getProductsName() {
        List<WebElement> allProductsElements = driver.findElements(By.cssSelector(".inventory_item_name"));
        ArrayList<String> names = new ArrayList<>();
        for (WebElement product : allProductsElements) {
            names.add(product.getText());
        }
        return names;
    }

    public String getProductNameFromCard(int index) {
        return driver.findElements(By.cssSelector(".inventory_item_name"))
                .get(index)
                .getText();
    }
}
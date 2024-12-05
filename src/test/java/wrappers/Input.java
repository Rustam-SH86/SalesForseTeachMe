package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Input {
    WebDriver driver;
    String label;

    public Input(WebDriver driver,String label) {
        this.driver = driver;
        this.label = label;
    }

    public void fillAccountsField(String text) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-input//input",label)))
                .sendKeys(text);
    }
}
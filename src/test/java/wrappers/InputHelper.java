package wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InputHelper {
    public void fillAccountsField(WebDriver driver,String text,String label) {
        driver.findElement(By.xpath(String.format("//label[text()='%s']//ancestor::lightning-textarea//textarea",label)))
                .sendKeys(text);
    }
}


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {
    @Test
    public void checkWrongPassword() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret");
        driver.findElement(By.className("submit-button")).click();
        String errorText = driver.findElement(By.cssSelector(".error-message-container.error")).getText();
        assertTrue(errorText.equals("Epic sadface: Username and password do not match any user in this service"));
    }
}

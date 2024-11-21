package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
       super(driver);
    }

    private final By USER_INPUT = (By.id("user-name"));
    private final By PASSWORD_INPUT = (By.id("password"));
    private final By LOGIN_BUTTON = (By.className("submit-button"));
    private final By ERROR_MESSAGE = By.cssSelector(".error-message-container.error");

    public void open() {
        driver.get(BASE_URL);
    }

    public void login(String user, String password) {
        driver.findElement(USER_INPUT).sendKeys(user);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }
    public String getErrorMessage() {
        return driver.findElement(ERROR_MESSAGE).getText();

    }

}

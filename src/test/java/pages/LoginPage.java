package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

import static org.openqa.selenium.By.className;

public class LoginPage extends BasePage {

    private final By USER_INPUT = (By.id("username"));
    private final By PASSWORD_INPUT = (By.id("password"));
    private final By LOGIN_BUTTON = By.xpath("//*[@id='Login']");




    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open login page")
    public LoginPage open() {
        driver.get(Urls.LOGIN_PAGE);
        return this;
    }


    @Step("Login with valid credentials")
    public HomePage LogIn() {
        driver.findElement(USER_INPUT).sendKeys("abobus@example.com");
        driver.findElement(PASSWORD_INPUT).sendKeys("enter555");
        driver.findElement(LOGIN_BUTTON).click();
        return new HomePage(driver);
    }
}

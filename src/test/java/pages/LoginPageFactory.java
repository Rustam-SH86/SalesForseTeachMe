package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPageFactory extends BasePage {
    @FindBy(id = "username")
    public WebElement userNameField;
    @FindBy(id = "password")
    public WebElement password;
    @FindBy(id = "login")
    public WebElement loginButton;

    public LoginPageFactory(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public BasePage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) loginButton));
        return this;
    }
    @Override
    public BasePage open() {
        return null;
    }
    public void loggIn(String username, String password) {
        userNameField.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}


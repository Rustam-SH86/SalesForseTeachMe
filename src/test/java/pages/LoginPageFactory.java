package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    public void loggIn(String username, String password) {
        userNameField.sendKeys(username);
        this.password.sendKeys(password);
        loginButton.click();
    }
}


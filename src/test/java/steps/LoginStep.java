package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginStep {
    LoginPage loginPage;
    public LoginStep(WebDriver driver) {
        loginPage = new LoginPage(driver);
    }
    public void logIn() {
        loginPage.open();
        loginPage.isPageOpened();
        loginPage.LogIn();
    }
}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    @Override
    public BasePage isPageOpened() {
        return null;
    }
    @Override
    public BasePage open() {
        return null;
    }
    @Step("Navigate to New Account Page")
    public AccountPage navigateToAccountPage() {
        driver.get(Urls.NEW_ACCOUNT_PAGE);
        return new AccountPage(driver);
    }
}
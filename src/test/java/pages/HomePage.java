package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.base.BaseTest;
import utils.Urls;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Navigate to Account Page")
    public AccountPage navigateToAccountPage() {
        driver.get(Urls.NEW_ACCOUNT_PAGE);
        return new AccountPage(driver);
    }
}
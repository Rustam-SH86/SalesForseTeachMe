package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.BaseTest;

@Log4j2
public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogIn();
        String expectedPageTitle = "Setup Home";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Проверка, что заголовок страницы содержит ожидаемое название.");
    }
}
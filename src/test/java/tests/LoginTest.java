package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import tests.base.BaseTest;

public class LoginTest extends BaseTest {
    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.LogIn();
        String expectedPageTitle = "Setup Home";
        Assert.assertTrue(driver.getTitle().contains(expectedPageTitle), "Проверка, что заголовок страницы содержит ожидаемое название.");

    }

}
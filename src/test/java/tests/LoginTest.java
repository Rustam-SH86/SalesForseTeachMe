package tests;

import jdk.jfr.Enabled;
import net.bytebuddy.build.Plugin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BasePage;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"standard_user", "123342424", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(testName = "Проверка позитивного логина",  description = "Проверка позитивного логина",
            retryAnalyzer = Retry.class, groups = {"smoke"},priority = 2,enabled = true)
    public void checkLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertEquals(
                productsPage.getTitle(),
                "Переход на страницу не выполнен");
    }

    @Test (dataProvider = "loginData", testName = "Негативные проверки гистрации",description = "Негативные проверки для login и password",
            retryAnalyzer = Retry.class,groups = {"smoke"},priority = 3,enabled = true)
    public void test(String user, String password, String expectedError) {
        loginPage.open();
        loginPage.login(user, password);
        assertEquals(
                loginPage.getErrorMessage(),
                expectedError,
                "Сообщение об ошибке не верное");
    }
}
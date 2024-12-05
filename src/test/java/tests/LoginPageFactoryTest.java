package tests;

import org.testng.annotations.Test;
import pages.LoginPageFactory;
import tests.base.BaseTest;
import utils.Urls;

public class LoginPageFactoryTest extends BaseTest {
    LoginPageFactory loginPageFactory = new LoginPageFactory(driver);
    @Test
    public void loginWithPageFactory(){
        driver.get(Urls.LOGIN_PAGE);
        loginPageFactory.loggIn("abobus@example.com","enter555");
    }
}

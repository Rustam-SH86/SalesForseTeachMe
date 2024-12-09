package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Test;
import pages.LoginPageFactory;
import tests.base.BaseTest;
import utils.Urls;

@Log4j2
public class LoginPageFactoryTest extends BaseTest {
    LoginPageFactory loginPageFactory = new LoginPageFactory(driver);

    @Test
    public void loginWithPageFactory() {
        driver.get(Urls.LOGIN_PAGE);
        loginPageFactory.loggIn("abobus@example.com", "enter555");
    }
}

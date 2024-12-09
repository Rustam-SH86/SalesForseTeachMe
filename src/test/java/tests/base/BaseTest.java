package tests.base;

import io.qameta.allure.Step;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import pages.NewAccountModal;
import steps.AccountStep;
import steps.LoginStep;
import tests.TestListener;
import utils.AllureUtils;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    protected NewAccountModal newAccountModal;
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected AccountStep accountStep;
    protected LoginStep loginStep;

    @Parameters({"browser"})
    @BeforeTest
    @Step("Открытие браузера")
    public void setup(@Optional("chrome") String browser, ITestContext context) {
        if (browser.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            options.addArguments("--disable-notifications");
            options.addArguments("--start-maximized");
            options.addArguments("--incognito");
            //options.addArguments("--headless");
            driver = new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        newAccountModal = new NewAccountModal(driver);
        loginPage = new LoginPage(driver);
        accountStep = new AccountStep(driver);
        loginStep = new LoginStep(driver);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Закрытие браузера")
    public void quitDriver(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            AllureUtils.takeScreenshot(driver);
        }
        driver.quit();
    }
}
package tests;
import pages.NewAccountModal;


import DTO.Account;
import DTO.AccountFakeFactory;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;

@Listeners(TestListener.class)
public class AccountTest extends BaseTest {
    Account account = AccountFakeFactory.getAccount("Hot");

    @Test(testName = "Логинимся и создаем новый аккаунт",
            retryAnalyzer = Retry.class, groups = {"smoke"}, priority = 1)
    @Description("Логинимся и создаем новый аккаунт")
    public void accountsTest() {
        loginPage.open()
                .LogIn()
                .navigateToAccountPage();
        newAccountModal.createAccount(account);
    }
}


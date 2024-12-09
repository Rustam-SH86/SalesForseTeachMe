package steps;

import DTO.Account;
import org.openqa.selenium.WebDriver;
import pages.AccountPage;
import pages.HomePage;
import pages.NewAccountModal;

public class AccountStep {
    HomePage homePage;
    AccountPage accountPage;
    NewAccountModal newAccountModal;

    public AccountStep(WebDriver driver) {
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        newAccountModal = new NewAccountModal(driver);

    }
    public void create(Account account) {
        homePage.navigateToAccountPage();
        newAccountModal.createAccount(account)
                .saveEdit();
    }
}

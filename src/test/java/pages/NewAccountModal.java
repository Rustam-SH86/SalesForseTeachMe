package pages;

import DTO.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {
    public NewAccountModal(WebDriver driver) {
        super(driver);
    }


    @Step("Create new account")
    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").fillAccountsField(account.getAccountName());
        new Picklist(driver, "Rating").Select(account.getRating());
        new Input(driver, "Phone").fillAccountsField(account.getPhone());
        new Input(driver, "Fax").fillAccountsField(account.getFax());
        new Textarea(driver, "Billing Street").fillAccountsField(account.getStreet());
        driver.findElement(By.xpath("//*[@name='SaveEdit']")).click();
        return this;
    }
}

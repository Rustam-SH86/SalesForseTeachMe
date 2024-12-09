package pages;

import DTO.Account;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import wrappers.Input;
import wrappers.Picklist;
import wrappers.Textarea;

public class NewAccountModal extends BasePage {
    public NewAccountModal(WebDriver driver) {
        super(driver);
    }
    @Override
    public BasePage isPageOpened() {
        return null;
    }
    @Override
    public BasePage open() {
        return null;
    }
    @Step("Create new account")
    public NewAccountModal createAccount(Account account) {
        new Input(driver, "Account Name").fillAccountsField(account.getAccountName());
        new Picklist(driver, "Rating").select(account.getRating());
        new Input(driver, "Phone").fillAccountsField(account.getPhone());
        new Input(driver, "Fax").fillAccountsField(account.getFax());
       // new Picklist(driver, "Type").select(account.getType());
       // new Picklist(driver, "Ownership").select(account.getOwnership());
        new Textarea(driver, "Billing Street").fillAccountsField(account.getStreet());

        return this;
    }
    @Step("save changes after creating a new contact")
    public void saveEdit () {
        WebElement saveEditButton = driver.findElement(By.xpath("//*[@name='SaveEdit']"));
        saveEditButton.click();
    }
}

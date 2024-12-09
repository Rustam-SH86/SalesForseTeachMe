package tests;

import DTO.Account;
import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import tests.base.BaseTest;


@Log4j2
@Listeners(TestListener.class)
public class AccountTest extends BaseTest {
    Faker faker = new Faker();
    Account account1 = Account.builder()
            .accountName(faker.name().fullName())
            .rating("Warm")
            .phone(faker.phoneNumber().phoneNumber())
            .fax(faker.phoneNumber().cellPhone())
            .type("Prospect")
            //.ownership("Public")
            //.street(faker.address().streetName())
            .build();
    @Test(testName = "Логинимся и создаем новый аккаунт",
            retryAnalyzer = Retry.class, groups = {"smoke"}, priority = 1)
    @Description("Логинимся и создаем новый аккаунт")
    public void accountsTest() {
        loginStep.logIn();
        accountStep.create(account1);
    }
}


package DTO;

import com.github.javafaker.Faker;

public class AccountFakeFactory {
    public static Account getAccount(String rating) {
        Faker faker = new Faker();
        return new Account(
                faker.company().name(),
                faker.phoneNumber().phoneNumber(),
                faker.phoneNumber().cellPhone(),
                faker.address().streetName(),
                rating
        );
    }
}
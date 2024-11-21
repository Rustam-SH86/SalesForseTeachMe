package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;

public class CartTest extends BaseTest {
    SoftAssert softAssert = new SoftAssert();

    @Test(testName = "Добавление продуктов",  description = "Добавляем продукты, проверяем корзину",
            retryAnalyzer = Retry.class, groups = {"smoke"},priority = 1,enabled = true)
    public void checkCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Backpack");
        cartPage.openPage();
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Bike Light"),
                "Cart doesn't contain the required product");
        softAssert.assertTrue(cartPage.isProductInCart("Sauce Labs Backpack"),
                "Cart doesn't contain 'Sauce Labs Backpack'");
        String actualPrice = cartPage.getProductPrice("Sauce Labs Bike Light");
        String expectedPrice = "$9.99";
        softAssert.assertEquals(actualPrice, expectedPrice,
                "The product price in the cart does not match the expected value");
        String actualPriceBackpack = cartPage.getProductPrice("Sauce Labs Backpack");
        String expectedPriceBackpack = "$29.99";
        softAssert.assertEquals(actualPriceBackpack, expectedPriceBackpack,
                "The price for 'Sauce Labs Backpack' does not match the expected value");
        softAssert.assertAll();
    }

    @Test(testName = "Удаление продуктов с корзины",  description = "удаляем продукты с корзины и проверям их отсутсвие в корзине,",
            retryAnalyzer = Retry.class, groups = {"smoke"},priority = 2,enabled = true)
    public void checkEmptyCart() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddButton("Sauce Labs Bike Light");
        productsPage.clickAddButton("Sauce Labs Backpack");
        cartPage.openPage();
        cartPage.removeProductFromCart("Sauce Labs Bike Light");
        cartPage.removeProductFromCart("Sauce Labs Backpack");
        for (String s : Arrays.asList("Sauce Labs Bike Light", "Sauce Labs Backpack")) {
            softAssert.assertTrue(cartPage.isProductRemovedFromCart(s));
        }
        softAssert.assertAll();
    }
}
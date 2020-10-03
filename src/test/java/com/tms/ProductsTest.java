package com.tms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static com.tms.pages.ProductsPage.addToCartLocator;
import static org.testng.Assert.*;

public class ProductsTest extends BaseTest {

    @Test
    public void fullPurchaseProcess() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.productDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
        checkoutPage.checkout();
        checkoutPage.fillInTheForm(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        checkoutPage.continueButton();
    }

    @Test
    public void addToCartButtonChangesToRemoveButton() {
        final String product = "Sauce Labs Fleece Jacket";

        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart(product);
        WebElement element = driver.findElement(By.xpath(String.format(addToCartLocator, product)));
        String actualText = element.getText();
        assertEquals(actualText, "REMOVE");
    }


    @Test
    public void cart() {
        String priceOnTheMainPage = "//*[contains(text(),'%s')]/ancestor::*[@class='inventory_item']//div[@class='inventory_item_price']";
        String priceInTheCart = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']//div[@class='inventory_item_price']";

        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        String priceMainPage = driver.findElement(By.xpath(String.format(priceOnTheMainPage, "Sauce Labs Fleece Jacket"))).getText();
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        String priceCart = driver.findElement(By.xpath(String.format(priceInTheCart, "Sauce Labs Fleece Jacket"))).getText();
        assertTrue(priceMainPage.contains(priceCart));
    }
}

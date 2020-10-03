package com.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {
    public static final By CHECKOUT = By.className("checkout_button");
    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.cssSelector("input[value='CONTINUE']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void checkout() {
        driver.findElement(CHECKOUT).click();
    }

    public void fillInTheForm(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(POSTAL_CODE).sendKeys(postalCode);
    }

    public void continueButton() {
        driver.findElement(CONTINUE_BUTTON).click();

    }
}

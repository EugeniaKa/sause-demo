package com.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/index.html";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");

    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void openPage() {
        driver.get(URL);
    }

    public void login(String username, String password) {

        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void logInWithoutCredentials() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void logiInWithoutPassword(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void logInWithoutUsername(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    //TODO create method to get error message
}

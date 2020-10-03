package com.tms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;

public class LoginTest extends BaseTest {

    @Test
    public void logInWithoutCredentials() {
        loginPage.openPage();
        loginPage.logInWithoutCredentials();
        WebElement element = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertNotNull(element.getText());
    }

    @Test
    public void logInWithoutPassword() {
        loginPage.openPage();
        loginPage.logiInWithoutPassword(USERNAME);
        WebElement element = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertNotNull(element.getText());
    }

    @Test
    public void logInWithoutUsername() {
        loginPage.openPage();
        loginPage.logInWithoutUsername(PASSWORD);
        WebElement element = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertNotNull(element.getText());
    }
}

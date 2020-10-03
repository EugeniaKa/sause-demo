package com.tms.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public final static String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();

    }
}
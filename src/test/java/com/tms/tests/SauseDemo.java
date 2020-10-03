package com.tms.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SauseDemo {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private void logIn() {
        // заходим на сайт
        driver.get("https://www.saucedemo.com/index.html");
        //находим поле Username
        WebElement username = driver.findElement(By.id("user-name"));
        // передаем в него значение "standard_user"
        username.sendKeys("standard_user");
        //находим поле Password
        WebElement password = driver.findElement(By.id("password"));
        // передаем в него значение "secret_sauce"
        password.sendKeys("secret_sauce");
        //находим кнопку Login
        WebElement loginButton = driver.findElement(By.id("login-button"));
        //нажимаем на кнопку Login
        loginButton.click();
    }

    @Test
    public void mainPage() {

        logIn();

        // ГЛАВНАЯ СТРАНИЦА

        // находим интересующий товар по id
        WebElement item = driver.findElement(By.id("item_1_title_link"));
        // выбираем его, попадаем на страницу с описанием товара
        item.click();
        // находим кнопку Add to cart
        WebElement addToCart = driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
        // нажимаем на нее
        addToCart.click();
        // Вместо Add to cart видим Remove. Если хотим убрать товар из корзины - нажимаем на нее
        WebElement removeFromCart = driver.findElement(By.xpath("//button[text()='REMOVE']"));
        // нажимаем на нее
        removeFromCart.click();
        // чтобы вернуться в главное меню, находим внопку Back
        WebElement backButton = driver.findElement(By.xpath("//button[text()='<- Back']"));
        // нажимаем на нее и попадаем на главную страницу
        backButton.click();

        // на главной странице имеем каталог товаров - создаем коллекцию
        List<WebElement> addToCartMainPage = driver.findElements(By.className("btn_primary"));
        // для каждого интересующего товара нажимаем Add to cart
        addToCartMainPage.get(0).click();
        addToCartMainPage.get(1).click();
        addToCartMainPage.get(3).click();
        // получаем коллекцию товаров, находящихся в корзине, которые мажно удалить
        List<WebElement> removeFromCartMainPage = driver.findElements(By.className("btn_secondary"));
        // для удаления из корзины жмем Remove
        removeFromCartMainPage.get(0).click();

        // МЕНЮ НА ГЛАВНОЙ СТРАНИЦЕ

        // для открытия меню находим 3 полоски в верхнем левом углу
        WebElement menu = driver.findElement(By.xpath("//button[text()='Open Menu']"));
        // жмем на них
        menu.click();
        // опция All Items
        WebElement allItems = driver.findElement(By.id("inventory_sidebar_link"));
        // жмем - попадаем на главную страницу с каталогом
        allItems.click();
        // возвращаемся в меню
        WebElement menu1 = driver.findElement(By.xpath("//button[text()='Open Menu']"));
        menu1.click();
        // опция - Reset App State
        WebElement reset = driver.findElement(By.id("reset_sidebar_link"));
        // нажимаем - если в корзине что-то есть, оно пропадает
        reset.click();
        // опция - About
        WebElement about = driver.findElement(By.id("about_sidebar_link"));
        // нажимаем - переходим на сайт с описанием
        about.click();
        driver.navigate().back();
        // возвращаемся в меню
        WebElement menu2 = driver.findElement(By.xpath("//button[text()='Open Menu']"));
        menu2.click();
        // опция - Logout
        WebElement logout = driver.findElement(By.id("logout_sidebar_link"));
        // нажимаем - выходим из аккаунта
        logout.click();
    }

    @Test
    public void shoppingCart() {

        logIn();

        // КОРЗИНА

        // добавляем товар в корзину
        List<WebElement> addToCartMainPage1 = driver.findElements(By.className("btn_primary"));
        addToCartMainPage1.get(0).click();
        addToCartMainPage1.get(2).click();
        addToCartMainPage1.get(3).click();
        // чтобы зайти в корзину находим иконку с изображением корзины
        WebElement shoppingCart = driver.findElement(By.id("shopping_cart_container"));
        // нажимаем на нее
        shoppingCart.click();
        // имеем коллекцию товаров, добавленных в корзину, которые можем удалить
        List<WebElement> removeInsideShoppingCart = driver.findElements(By.className("btn_secondary"));
        // для удаления жмем Remove
        removeInsideShoppingCart.get(0).click();
        // чтобы продолжить смотреть каталог ищем кнопку Continue shopping
        WebElement continueShopping = driver.findElement(By.xpath("//div/a[text()='Continue Shopping']"));
        // жмем на нее, попадаем на главную страницу
        continueShopping.click();

        // возвращаемся в корзину
        WebElement shoppingCart1 = driver.findElement(By.id("shopping_cart_container"));
        shoppingCart1.click();
        // для того, чтобы выйти из аккаунта, находим кнопку Checkout
        WebElement checkoutButton = driver.findElement(By.className("btn_action"));
        // Жмем на нее
        checkoutButton.click();
        // для отмены команды Checkout находим кнопку Cancel
        WebElement cancelButton = driver.findElement(By.className("cart_cancel_link"));
        // нажимаем на нее
        cancelButton.click();
        // еще раз делаем Checkout из корзины
        WebElement checkoutButton1 = driver.findElement(By.className("btn_action"));
        checkoutButton1.click();
        // заполняем форму. Находим поле First Name
        WebElement firstName = driver.findElement(By.id("first-name"));
        // передаем в нее значение
        firstName.sendKeys("Eugenia");
        // Находим поле Last Name
        WebElement lastName = driver.findElement(By.id("last-name"));
        // передаем в нее значение
        lastName.sendKeys("Kashanok");
        // Находим поле Zip/Postal Code
        WebElement zipCode = driver.findElement(By.id("postal-code"));
        // передаем в него значение
        zipCode.sendKeys("555");
        // находим кнопку Continue
        WebElement continueButton = driver.findElement(By.xpath("//input[@value='CONTINUE']"));
        // нажимаем на нее
        continueButton.click();
        // для завершения находим кнопку Finish
        WebElement finish = driver.findElement(By.xpath("//div/a[text()='FINISH']"));
        // нажимаем на нее
        finish.click();
    }

    @Test
    public void listOfItems() {
        logIn();

        // получили коллекцию наименований товаров
        List<WebElement> listOfItems = driver.findElements(By.className("inventory_item_name"));
        // получили коллекцию цен товаров
        List<WebElement> listOfPrices = driver.findElements(By.className("inventory_item_price"));
        // выводим в консоль наименование+цена
        int i = 0;
        int j = 0;
        do {
            System.out.println(listOfItems.get(i).getText());
            System.out.println(listOfPrices.get(j).getText());
            i++;
            j++;
        } while (i < listOfItems.size() && j < listOfPrices.size());
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
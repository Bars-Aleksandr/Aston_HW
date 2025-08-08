package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {


    public static void main(String[] args) {
        // Автоматически настроит путь к драйверу chrome
        WebDriverManager.chromedriver().setup();

        // Создаем экземпляр веб-драйвера для Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем страницу
        driver.get("https://www.google.com");

        // Закрываем браузер
        //driver.quit();
    }


}

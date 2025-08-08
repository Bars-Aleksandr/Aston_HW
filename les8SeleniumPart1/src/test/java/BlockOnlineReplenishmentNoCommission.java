import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
// Проверить название указанного блока;
// Проверить наличие логотипов платёжных систем;
// Проверить работу ссылки «Подробнее о сервисе»;
// Заполнить поля и проверить работу кнопки «Продолжить» (проверяем только вариант «Услуги связи»,номер для теста 297777777)

public class BlockOnlineReplenishmentNoCommission {
    private static WebDriver driver;
    private static WebDriverWait wait;


    @BeforeAll
    static void setupUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
       // chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-cookies");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }
    @BeforeEach
    void beforeEachTest(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://mts.by/");
        try {
            WebElement cookieButtonClose = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn_black.cookie__ok")));
            cookieButtonClose.click();
        } catch (TimeoutException e) {
            System.out.println("Окно использование файлов Cookie не найдена, продолжаю выполнение теста...");
        }
    }

//    @AfterAll
//    static void teardown() {
//        driver.manage().deleteAllCookies();
//        driver.quit();
//    }

    @Test
    @DisplayName("Проверка работы кнопки «Продолжить» блока «Онлайн пополнение без комиссии» при пополнении баланса")
    void checkFormFillAndSubmit(){
        WebElement phoneInput = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInput.click();
        phoneInput.clear();
        phoneInput.sendKeys("297777777");
        System.out.println(phoneInput.getText());

        WebElement sumInput = driver.findElement(By.id("connection-sum"));
        sumInput.click();
        sumInput.clear();
        sumInput.sendKeys("10");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement form = driver.findElement(By.cssSelector("#pay-connection"));
        WebElement continueButton = form.findElement(By.cssSelector("button.button.button__default"));
        continueButton.click();
        //WebElement iframe = driver.findElement(By.className("bepaid-app__container"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.tagName("iframe")));
        List<WebElement> iframes = driver.findElements(By.tagName("iframe"));

       // wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("bepaid-iframe")));
        WebElement firstIframe = iframes.get(0);
        System.out.println("Count iframes = " + iframes.size());
        System.out.println("IFRAME SRC: " + firstIframe.getAttribute("src"));
        System.out.println("IFRAME CLASS: " + firstIframe.getAttribute("class"));
        System.out.println("IFRAME STYLE: " + firstIframe.getAttribute("style"));
        System.out.println("IFRAME TITLE: " + firstIframe.getAttribute("title"));


        System.out.println("count iframes = " + iframes.size());


//        try {
//            // Загрузка целевой страницы
//            driver.get("http://your-target-page.com");
//
//            // Ждем, пока iframe станет доступен и будет готов к использованию
//            WebDriverWait wait = new WebDriverWait(driver, 10); // ждем до 10 секунд
//            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe#your-iframe-id")));
//
//            // Выполняем дополнительное действие, если нужно (например, проверка содержимого фрейма)
//            // Но здесь наша цель - убедиться, что iframe загрузился
//
//            // Тест успешен!
//            System.out.println("Iframe loaded successfully.");
//
//        } catch (Throwable e) {
//            System.err.println("Error loading iframe: " + e.getMessage());
//        } finally {
//            // Завершаем работу браузера
//            driver.quit();
//        }
//
//        List<WebElement> iframesIframes = driver.findElements(By.tagName("iframe"));
//        for (WebElement iframe : iframesIframes) {
//            String src = iframe.getAttribute("src");
//            if (src.contains("https://www.googletagmanager.com/ns.html?id=GTM-58MXNGS")) { // Проверяем специфический источник
//                driver.switchTo().frame(iframe); // Переходим в фрейм
//                // Теперь можно взаимодействовать с содержимым фрейма
//                break;
//            }
//        }
//
//
//        List<WebElement> allElements = driver.findElements(By.xpath("//*"));
//        for(WebElement element : allElements){
//            String tagName = element.getTagName();           // Имя тега
//            String textContent = element.getText();          // Текст содержимого
//            String attributeClass = element.getAttribute("class");   // Атрибут класса
//
//            System.out.println("Tag Name: " + tagName +
//                    ", Text Content: '" + textContent +
//                    "', Class Attribute: '" + attributeClass + "'");
//        }
//
//
//        // Получаем заголовок открытого фрейма и проверяем его равенство
//        String title = driver.getTitle();
//        assert title.equals("BePaidWidget") : "Фрейм не открыт или заголовок неверный!";


    }

    @Test
    @DisplayName("Проверка текста название блока «Онлайн пополнение без комиссии»")
    void checkBlockTitle() {
        String expectedText = "Онлайн пополнение\nбез комиссии";
        By blockNameLocator = By.cssSelector(".pay__wrapper h2");
        String actualText = driver.findElement(blockNameLocator).getText();
        assertEquals(expectedText, actualText, "Текст заголовка не совпадает.");
    }


    @Test
    @DisplayName("Проверка наличие логотипов платёжных систем")
    void checkAvailabilityPaySystemsLogo() {
        WebElement payPartnersContainer = driver.findElement(By.className("pay__partners"));
        List<WebElement> images = payPartnersContainer.findElements(By.tagName("img"));
        assertFalse(images.isEmpty(), "Логотипы не в блоке Онлайн пополнение без комиссии не найдены");
        for (WebElement img : images) {
            String src = img.getAttribute("src");
            String alt = img.getAttribute("alt");
            assertNotNull(src, "Атрибут src отсутствует у изображения с alt: " + alt);
            assertFalse(src.trim().isEmpty(), "Атрибут src пуст у изображения с alt: " + alt);
            Boolean imageLoaded = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "var img = arguments[0];" +
                            "return img.complete && typeof img.naturalWidth != 'undefined' && img.naturalWidth > 0;", img);
            assertTrue(imageLoaded, "Изображение не загружено или сломано: " + src);
        }
    }

    @Test
    @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
    void checkWorkLinkMoreAboutService() {

        // Находим ссылку по тексту или по атрибуту href
        // Предположим, что текст ссылки — "Подробнее о сервисе"
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Подробнее о сервисе")));

        // Проверяем, что ссылка видима
        assertTrue(link.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");

        // Проверяем атрибут href
        String href = link.getAttribute("href");
        assertNotNull(href, "Атрибут href у ссылки отсутствует");
        assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Href не содержит ожидаемый путь");

        // Кликаем по ссылке
        link.click();

        // Ждем загрузки новой страницы
        wait.until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));

        // Проверяем текущий URL
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Переход по ссылке не произошел или URL некорректен");

    }
}

package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import org.openqa.selenium.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.IframeForSectionPayment;
import pages.MainPage;
import pages.SectionPaymentNoCommission;


import java.util.List;


public class BlockOnlineReplenishmentNoCommission {
    private final String testDateNumPhone = "297777777";
    private final String testDateAmountPay = "10";
    private static WebDriver driver;

    private static MainPage mainPage;
    private static SectionPaymentNoCommission paymentSection;

    /**
     * первоначальная настройка браузера
     */

    @BeforeAll
    static void setupUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--disable-cookies");
        driver = new ChromeDriver(chromeOptions);
        mainPage = new MainPage(driver);

    }

    @BeforeEach
    void beforeEachTest() {
        mainPage.openBasePage();
        mainPage.closeCookieBannerWithOK();
        paymentSection = mainPage.getPaymentSection();
    }

    @AfterAll
    static void teardown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    @Test
    @DisplayName("Проверка работы кнопки «Продолжить» блока «Онлайн пополнение без комиссии» при пополнении баланса")
    void checkFormFillAndSubmit() {
        paymentSection.fillPhoneNumber(testDateNumPhone);
        paymentSection.fillAmount(testDateAmountPay);
        paymentSection.submitForm();
        assertTrue(paymentSection.isIFramePresent(), "iFrame не появился после нажатия Продолжить");
    }

    @Test
    @DisplayName("Проверка текста название блока «Онлайн пополнение без комиссии»")
    void checkBlockTitle() {
        String expectedText = "Онлайн пополнение\nбез комиссии";
        String actualText = paymentSection.titleSection.getText();
        assertEquals(expectedText, actualText, "Текст заголовка не совпадает.");
    }


    @Test
    @DisplayName("Проверка наличие логотипов платёжных систем")
    void checkAvailabilityPaySystemsLogo() {
        List<WebElement> images = paymentSection.getPartnerLogos();
        assertFalse(images.isEmpty(), "Логотипы платежных систем не найдены");
        assertTrue(mainPage.areImagesLoaded(images), "Некоторые изображения не загружены");

    }

    @Test
    @DisplayName("Проверка работы ссылки «Подробнее о сервисе»")
    void checkWorkLinkMoreAboutService() {
        WebElement expectedLink = paymentSection.linkMoreAboutService;
        assertTrue(expectedLink.isDisplayed(), "Ссылка 'Подробнее о сервисе' не отображается");
        String href = expectedLink.getAttribute("href");
        assertNotNull(href, "Атрибут href у ссылки отсутствует");
        assertTrue(href.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Href не содержит ожидаемый путь");
        expectedLink.click();
        paymentSection.getWait().until(ExpectedConditions.urlContains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"));
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains("/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/"),
                "Переход по ссылке не произошел или URL некорректен");

    }

    @Test
    @DisplayName("Проверка плейсхолдеров пункт меню - услуги связи")
    void checkPlaceholdersInSelectConnectionPhone() {
        paymentSection.clickSelectionMenu();

        WebElement optionElement = paymentSection.itemSelectConnectionPhone;
        optionElement.click();

        WebElement fieldInputPhone = paymentSection.fieldInputPhone;
        String placeholderActual = fieldInputPhone.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.PHONE_PLACEHOLDER_EXPECTED, placeholderActual, "Плейсхолдер не соответсвует фактическому");

        String labelFieldInputPhone = paymentSection.labelForFieldInputPhone.getText();
        assertEquals(SectionPaymentNoCommission.LABEL_PHONE_EXPECTED, labelFieldInputPhone, "Код страны в поле телефона не соответсвует ожидаемому");

        WebElement fieldAmountPay = paymentSection.fieldInputAmountPay;
        String fieldAmountPayPlaceholderActual = fieldAmountPay.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.PAYAMOUNT_PLACEHOLDER_EXPECTED, fieldAmountPayPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

        String labelFieldAmountPayActual = paymentSection.labelForFieldAmountPay.getText();
        assertEquals(SectionPaymentNoCommission.LABEL_PAYAMOUNT_EXPECTED, labelFieldAmountPayActual, "в поле валюта не соответсвует ожидаемому");

        WebElement fieldEmail = paymentSection.fieldInputEmail;
        String fieldEmailPlaceholderActual = fieldEmail.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.EMAIL_PLACEHOLDER_EXPECTED, fieldEmailPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

    }

    @Test
    @DisplayName("Проверка плейсхолдеров пункта меню - Домашний интернет")
    void checkPlaceholdersInSelectHomeInet() {
        paymentSection.clickSelectionMenu();

        WebElement optionElement = paymentSection.itemSelectHomeInet;
        optionElement.click();


        WebElement fieldInputPhone = paymentSection.fieldInputSubscriberNUmber;
        String placeholderActual = fieldInputPhone.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.SUBSCRIBER_NUMBER_PLACEHOLDER_EXPECTED, placeholderActual, "Плейсхолдер не соответсвует ожидаемому");

        String labelFieldInput = paymentSection.labelForFieldInputPhoneHomeInet.getText();
        assertEquals(SectionPaymentNoCommission.LABEL_PHONE_EXPECTED, labelFieldInput, "Код страны в поле телефона не соответсвует ожидаемому");

        WebElement fieldAmountPay = paymentSection.fieldInputAmountPay;
        String fieldAmountPayPlaceholderActual = fieldAmountPay.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.PAYAMOUNT_PLACEHOLDER_EXPECTED, fieldAmountPayPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

        paymentSection.getWait().until(ExpectedConditions.visibilityOf(paymentSection.labelForFieldAmountPayHomeInet));
        String labelFieldAmountPayActual = paymentSection.labelForFieldAmountPayHomeInet.getText();
        assertEquals(SectionPaymentNoCommission.LABEL_PAYAMOUNT_EXPECTED, labelFieldAmountPayActual, "в поле валюта не соответсвует ожидаемому");

        WebElement fieldEmail = paymentSection.fieldInputEmail;
        String fieldEmailPlaceholderActual = fieldEmail.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.EMAIL_PLACEHOLDER_EXPECTED, fieldEmailPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

    }

    @Test
    @DisplayName("Проверка плейсхолдеров пункта меню - Рассрочка")
    void checkPlaceholdersInSelectInstallmentPlan() {
        paymentSection.clickSelectionMenu();

        WebElement optionElement = paymentSection.itemSelectInstallment;
        optionElement.click();


        WebElement fieldInputAccountNum = paymentSection.fieldInputAccountNum;
        String placeholderActual = fieldInputAccountNum.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.INSTALMENT_PLACEHOLDER_EXPECTED, placeholderActual, "Плейсхолдер не соответсвует ожидаемому");


        WebElement fieldAmountPay = paymentSection.fieldInputAmountPayInstalment;
        String fieldAmountPayPlaceholderActual = fieldAmountPay.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.PAYAMOUNT_PLACEHOLDER_EXPECTED, fieldAmountPayPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

        paymentSection.getWait().until(ExpectedConditions.visibilityOf(paymentSection.labelForFieldInputAmountPayInstalment));
        String labelFieldAmountPayActual = paymentSection.labelForFieldInputAmountPayInstalment.getText();
        assertEquals(SectionPaymentNoCommission.LABEL_PAYAMOUNT_EXPECTED, labelFieldAmountPayActual, "в поле валюта не соответсвует ожидаемому");

        WebElement fieldEmail = paymentSection.fieldInputEmail;
        String fieldEmailPlaceholderActual = fieldEmail.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.EMAIL_PLACEHOLDER_EXPECTED, fieldEmailPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

    }


    @Test
    @DisplayName("Проверка плейсхолдеров пункта меню - Задолженность")
    void checkPlaceholdersInSelectArrears() {
        paymentSection.clickSelectionMenu();

        WebElement optionElement = paymentSection.itemSelectArrears;
        optionElement.click();


        WebElement fieldInputAccountNum = paymentSection.fieldInputAccountNumArrears;
        String placeholderActual = fieldInputAccountNum.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.ARREARS_PLACEHOLDER_EXPECTED, placeholderActual, "Плейсхолдер не соответсвует ожидаемому");


        WebElement fieldAmountPay = paymentSection.fieldInputAmountPayArrears;
        String fieldAmountPayPlaceholderActual = fieldAmountPay.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.PAYAMOUNT_PLACEHOLDER_EXPECTED, fieldAmountPayPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");


        paymentSection.getWait().until(ExpectedConditions.visibilityOf(paymentSection.labelForFieldInputAmountPayArrears));
        String labelFieldAmountPayActual = paymentSection.labelForFieldInputAmountPayArrears.getText();

        System.out.println("LAbel = " + labelFieldAmountPayActual);
        assertEquals(SectionPaymentNoCommission.LABEL_PAYAMOUNT_EXPECTED, labelFieldAmountPayActual, "в поле валюта не соответсвует ожидаемому");

        WebElement fieldEmail = paymentSection.fieldInputEmail;
        String fieldEmailPlaceholderActual = fieldEmail.getAttribute("placeholder");
        assertEquals(SectionPaymentNoCommission.EMAIL_PLACEHOLDER_EXPECTED, fieldEmailPlaceholderActual, "Плейсхолдер не соответсвует ожидаемому");

    }

    @Test
    @DisplayName("проверка элементов на iframe")
    void checkElementsFrame() {
        String expectedPhoneNumber = "Оплата: Услуги связи Номер:375" + testDateNumPhone;
        String expectedAmount = (String.format("%.2f", Double.valueOf(testDateAmountPay)) + " BYN").replace(',', '.');

        paymentSection.getWait().until(ExpectedConditions.elementToBeClickable(paymentSection.fieldInputPhone));
        paymentSection.fillPhoneNumber(testDateNumPhone);
        paymentSection.fillAmount(testDateAmountPay);
        paymentSection.submitForm();
        IframeForSectionPayment iframe = new IframeForSectionPayment(driver, paymentSection.getWait());
        iframe.switchToIframe();


        WebElement totalSum = iframe.findElementWhenReady(iframe.sumDisplay);
        WebElement phoneNumber = iframe.findElementWhenReady(iframe.phoneNumber);
        WebElement button = iframe.findElementWhenReady(iframe.payButton);
        WebElement numCard = iframe.findElementWhenReady(iframe.creditCardInput);
        WebElement expirationDateCard = iframe.findElementWhenReady(iframe.expirationDateInput);
        WebElement cvcField = iframe.findElementWhenReady(iframe.cvcInput);
        WebElement nameOnCard = iframe.findElementWhenReady(iframe.nameOnCardInput);

        String actualAmount = totalSum.getText();
        assertEquals(expectedAmount, actualAmount, "Неправильное содержимое поля суммы.");


        assertEquals(expectedPhoneNumber, phoneNumber.getText(), "Неправильное содержимое поля телефон.");
        assertEquals("Оплатить " + expectedAmount, button.getText(), "Неправильная надпись на кнопке оплаты.");
        assertEquals("Номер карты", numCard.getText(), "Некорректное начальное значение поля номер карты.");
        assertEquals("Срок действия", expirationDateCard.getText(), "Некорректное начальное значение поля срок действия карты.");
        assertEquals("CVC", cvcField.getText(), "Некорректное начальное значение поля CVV/CVC.");
        assertEquals("Имя и фамилия на карте", nameOnCard.getText(), "Некорректное начальное значение поля имя владельца карты.");
        boolean isIconsBrands = mainPage.areImagesLoaded(iframe.paymentIcons);

        assertTrue(isIconsBrands, "Одна или несколько иконок платежных систем не были загружены.");
    }
}
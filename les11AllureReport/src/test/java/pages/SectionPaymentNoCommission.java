package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SectionPaymentNoCommission {
    private WebDriver driver;

    private WebDriverWait wait;
    public static final String PHONE_PLACEHOLDER_EXPECTED = "Номер телефона";
    public static final String SUBSCRIBER_NUMBER_PLACEHOLDER_EXPECTED = "Номер абонента";
    public static final String INSTALMENT_PLACEHOLDER_EXPECTED = "Номер счета на 44";
    public static final String ARREARS_PLACEHOLDER_EXPECTED = "Номер счета на 2073";
    public static final String LABEL_PHONE_EXPECTED = "+375";
    public static final String PAYAMOUNT_PLACEHOLDER_EXPECTED = "Сумма";

    public static final String LABEL_PAYAMOUNT_EXPECTED = "Руб.";

    public static final String EMAIL_PLACEHOLDER_EXPECTED = "E-mail для отправки чека";

    /**
     * конструктор класса
     *
     * @param driver
     * @param wait
     */
    public SectionPaymentNoCommission(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }

    public WebDriverWait getWait() {
        return wait;
    }

    /**
     * название блока
     */
    @FindBy(css = ".pay__wrapper h2")
    public WebElement titleSection;

    /**
     * контейнер с логотипами платежных систем
     */
    @FindBy(className = "pay__partners")
    private WebElement payPartnersContainer;

    /**
     * Подробнее о сервисе
     */
    @FindBy(linkText = "Подробнее о сервисе")
    public WebElement linkMoreAboutService;

    /**
     * поле ввода номера телефона
     */
    @FindBy(id = "connection-phone")
    public WebElement fieldInputPhone;

    /**
     * поле ввода номера абонента
     */
    @FindBy(id = "internet-phone")
    public WebElement fieldInputSubscriberNUmber;

    /**
     * поле ввода email
     */
    @FindBy(id = "connection-email")
    public WebElement fieldInputEmail;

    /**
     * label "+375" для поля ввода номера телефона пункта "Услуги связи"
     */
    @FindBy(css = "label[for='connection-phone']")
    public WebElement labelForFieldInputPhone;

    /**
     * label "+375" для поля ввода номера телефона пункта "Домашний интернет"
     */
    @FindBy(css = "label[for='internet-phone']")
    public WebElement labelForFieldInputPhoneHomeInet;

    /**
     * label "Руб." для поля ввода суммы оплаты пункта "Услуги связи"
     */
    @FindBy(css = "label[for='connection-sum']")
    public WebElement labelForFieldAmountPay;

    /**
     * label - Руб. для поля ввода суммы оплаты пункта Домашнего интернета
     */
    @FindBy(css = "label[for='internet-sum']")
    public WebElement labelForFieldAmountPayHomeInet;

    /**
     * поле ввода суммы платежа
     */
    @FindBy(id = "connection-sum")
    public WebElement fieldInputAmountPay;

    /**
     * кнопка продолжить
     */

    @FindBy(css = "#pay-connection button.button.button__default")
    private WebElement buttonSubmit;

    /**
     * iframe locator после нажатия кнопки продолжить
     */
    @FindBy(css = "iframe.bepaid-iframe[src^='https://checkout.bepaid.by/widget_v2/']")
    private WebElement iframeLocator;

    /**
     * выбор элементов выподающего списка
     */
    @FindBy(css = ".select__wrapper")
    public WebElement buttonSelect;

    /**
     * Услуги связи
     */
    @FindBy(css = ".select__list>li:nth-of-type(1)")
    public WebElement itemSelectConnectionPhone;


    /**
     * Домашний интернет
     */
    @FindBy(css = ".select__list>li:nth-of-type(2)")
    public WebElement itemSelectHomeInet;

    /**
     * Рассрочка
     */
    @FindBy(css = ".select__list>li:nth-of-type(3)")
    public WebElement itemSelectInstallment;

    /**
     * поле ввода номера счета пункта "Рассрочка"
     */
    @FindBy(id = "score-instalment")
    public WebElement fieldInputAccountNum;


    /**
     * поле ввода суммы платежа пункта "Рассрочка"
     */
    @FindBy(id = "instalment-sum")
    public WebElement fieldInputAmountPayInstalment;

    /**
     * label "Руб." поля суммы платежа пункта "Рассрочка"
     */
    @FindBy(xpath = "//form[@id='pay-instalment']//label[normalize-space(text())='Руб.']")
    public WebElement labelForFieldInputAmountPayInstalment;



    /**
     * пункт выподающего меню - Задолженность
     */
    @FindBy(css = ".select__list>li:nth-of-type(4)")
    public WebElement itemSelectArrears;

    /**
     * поле ввода номера счета пункта "Задолженность"
     */
    @FindBy(id = "score-arrears")
    public WebElement fieldInputAccountNumArrears;


    /**
     * поле ввода суммы платежа пункта "Задолженность"
     */
    @FindBy(id = "arrears-sum")
    public WebElement fieldInputAmountPayArrears;

    /**
     * label "Руб." поля суммы платежа пункта "Задолженность"
     */
    @FindBy(xpath = "//form[@id='pay-arrears']//label[normalize-space(text())='Руб.']")
    public WebElement labelForFieldInputAmountPayArrears;

    public void clickSelectionMenu(){
        buttonSelect.click();
    }
    public void fillPhoneNumber(String number) {
        fieldInputPhone.clear();
        fieldInputPhone.sendKeys(number);
    }

    public void fillAmount(String amount) {
        fieldInputAmountPay.clear();
        fieldInputAmountPay.sendKeys(amount);
    }

    public void submitForm() {
        buttonSubmit.click();
    }

    public List<WebElement> getPartnerLogos() {
        return payPartnersContainer.findElements(By.tagName("img"));
    }

    public boolean isIFramePresent() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe.bepaid-iframe[src^='https://checkout.bepaid.by/widget_v2/']")));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}

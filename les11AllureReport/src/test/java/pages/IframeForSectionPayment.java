package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class IframeForSectionPayment {

    private final WebDriverWait wait;

    public IframeForSectionPayment(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//iframe[starts-with(@src, 'https://checkout.bepaid.by/widget_v2/')]")
    private WebElement xpathLocatorIframe;

    public void switchToIframe() {
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(xpathLocatorIframe));

    }

    public WebElement findElementWhenReady(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Локатор для отображения суммы
     */
    @FindBy(css = ".pay-description__cost span")
    public WebElement sumDisplay;

    /**
     * Локатор кнопки "Оплатить"
     */
    @FindBy(xpath = "//button[contains(text(), 'Оплатить')]")
    public WebElement payButton;

    /**
     * Локатор поля ввода номера кредитки
     */
    @FindBy(css = "#cc-number + label")
    public WebElement creditCardInput;

    /**
     * локатор отображения номера телефона
     */
    @FindBy(css = ".pay-description__text span")
    public WebElement phoneNumber;

    /**
     * поле Срок действия карты
     */
    @FindBy(xpath = "//label[contains(text(), 'Срок действия')]")
    public WebElement expirationDateInput;

    /**
     * Поле CVC
     */
    @FindBy(xpath = "//label[contains(text(), 'CVC')]")
    public WebElement cvcInput;

    /**
     * Имя и фамилия на карте
     */
    @FindBy(xpath = "//label[contains(text(), 'Имя и фамилия на карте')]")
    public WebElement nameOnCardInput;

    /**
     * иконки платежных систем
     */
    @FindBy(css = ".cards-brands__container img")
    public List<WebElement> paymentIcons;


}

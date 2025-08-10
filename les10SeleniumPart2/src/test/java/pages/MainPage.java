package pages;

import org.example.ConfProperties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;


public class MainPage {
    protected final WebDriver driver;
    protected final WebDriverWait wait;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
     public void openBasePage(){
         driver.get(ConfProperties.getProperty("basePage"));
     }
    public void closeCookieBannerWithOK() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieBannerButtonOK)).click();
        } catch (TimeoutException ignored) {
            System.out.println("Окно использование файлов Cookie не найдена, продолжаю выполнение теста...");
        }
    }

    @FindBy(css = ".btn.btn_black.cookie__ok")
    private WebElement cookieBannerButtonOK;


    public boolean areImagesLoaded(List<WebElement> elements) {
        for (WebElement el : elements) {
            Boolean result = (Boolean) ((JavascriptExecutor) driver).executeScript(
                    "return arguments[0].complete && typeof arguments[0].naturalHeight !== \"undefined\" && arguments[0].naturalHeight > 0", el);
            if (!result) return false;
        }
        return true;
    }
    public SectionPaymentNoCommission getPaymentSection() {
        return new SectionPaymentNoCommission(this.driver, this.wait);
    }
}

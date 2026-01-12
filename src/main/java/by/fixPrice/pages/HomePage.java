package by.fixPrice.pages;

import by.fixPrice.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private final String BASE_URL = "https://fix-price.by/";
    private final By COOKIE_ALERT_ACCEPT_BTN = By.xpath("//div[@class='cookies-bar']//button[@class='button config']");
    private final By LOGIN_BTN = By.xpath("//div[@class='categories-wrapper categories']//button[@class='log-in link']");

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitForVisibleOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void acceptCookies() {
        waitForVisibleOfElement(COOKIE_ALERT_ACCEPT_BTN).click();
    }

    //Login
    private final By LOGIN_FORM_TITLE = By.xpath("//dialog//header//h3[@class='title']");

    public void openLoginForm() {
        waitForVisibleOfElement(LOGIN_BTN).click();
    }

    public String getLoginFormTitle() {
        return waitForVisibleOfElement(LOGIN_FORM_TITLE).getText();
    }

}

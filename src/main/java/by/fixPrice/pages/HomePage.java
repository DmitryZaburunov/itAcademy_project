package by.fixPrice.pages;

import by.fixPrice.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    protected final String BASE_URL = "https://fix-price.by/";
    protected final By COOKIE_ALERT_ACCEPT_BTN = By.xpath("//div[@class='cookies-bar']//button[@class='button config']");
    protected final By LOGIN_BTN = By.xpath("//div[@class='categories-wrapper categories']//button[@class='log-in link']");
    protected final By PROFILE_BTN_TEXT = By.xpath("//div[@class='categories-wrapper categories']/div[@class='profile-desktop']//span[@class='title']");

    public WebDriver driver;
    public WebDriverWait wait;

    public HomePage() {
        this.driver = Driver.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public WebElement waitFVOE(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void openPage() {
        driver.get(BASE_URL);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void acceptCookies() {
        waitFVOE(COOKIE_ALERT_ACCEPT_BTN).click();
    }

    public void openLoginForm() {
        waitFVOE(LOGIN_BTN).click();
    }
}

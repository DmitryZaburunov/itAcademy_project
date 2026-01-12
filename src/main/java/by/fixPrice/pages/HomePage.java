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
    private final By LOGIN_FORM_TOGGLE_BY_PHONE = By.xpath("//dialog//div[@data-component='MultiToggle']//button[1]");
    private final By LOGIN_FORM_TOGGLE_BY_EMAIL = By.xpath("//dialog//div[@data-component='MultiToggle']//button[2]");
    private final By LOGIN_FORM_LOGIN_LABEL_BY_PHONE = By.xpath("//dialog//form//div[@class='login']//label[@class='label']");
    private final By LOGIN_FORM_LOGIN_INPUT_BY_PHONE = By.xpath("//dialog//form//div[@class='login']//input[@class='input-text']");
    private final By LOGIN_FORM_PASSWORD_LABEL_BY_PHONE = By.xpath("//dialog//form//div[@class='password']//label[@class='label']");
    private final By LOGIN_FORM_PASSWORD_INPUT_BY_PHONE = By.xpath("//dialog//form//div[@class='password']//input[@class='input-text']");

    public void openLoginForm() {
        waitForVisibleOfElement(LOGIN_BTN).click();
    }

    public void clickLoginFormToggleByPhone() {
        waitForVisibleOfElement(LOGIN_FORM_TOGGLE_BY_PHONE).click();
    }

    public void clickLoginFormToggleByEmail() {
        waitForVisibleOfElement(LOGIN_FORM_TOGGLE_BY_EMAIL).click();
    }

    public String getLoginFormTitle() {
        return waitForVisibleOfElement(LOGIN_FORM_TITLE).getText();
    }

    public String getLoginFormToggleByPhone() {
        return waitForVisibleOfElement(LOGIN_FORM_TOGGLE_BY_PHONE).getText();
    }

    public String getLoginFormToggleByEmail() {
        return waitForVisibleOfElement(LOGIN_FORM_TOGGLE_BY_EMAIL).getText();
    }

    public String getLoginFormLoginLabelByPhone() {
        return waitForVisibleOfElement(LOGIN_FORM_LOGIN_LABEL_BY_PHONE).getText();
    }

    public WebElement getLoginFormLoginInputByPhone() {
        return waitForVisibleOfElement(LOGIN_FORM_LOGIN_INPUT_BY_PHONE);
    }

    public String getLoginFormPasswordLabelByPhone() {
        return waitForVisibleOfElement(LOGIN_FORM_PASSWORD_LABEL_BY_PHONE).getText();
    }

    public WebElement getLoginFormPasswordInputByPhone() {
        return waitForVisibleOfElement(LOGIN_FORM_PASSWORD_INPUT_BY_PHONE);
    }
}

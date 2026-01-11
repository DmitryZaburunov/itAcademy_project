package by.fixPrice.pages;

import by.fixPrice.driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private final String BASE_URL = "https://fix-price.by/";
    private final String COOKIE_ALERT_ACCEPT_BTN = "//div[@class='cookies-bar']//button[@class='button config']";

    public WebDriver driver;

    public HomePage() {
        this.driver = Driver.getDriver();
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public void acceptCookies() {
        driver.findElement(By.xpath(COOKIE_ALERT_ACCEPT_BTN)).click();
    }
}

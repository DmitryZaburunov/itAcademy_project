package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.SearchPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

public class SearchTest {
    private SearchPage searchPage;
    private Faker faker = new Faker();

    @BeforeEach
    public void startupAndAcceptCookie() {
        searchPage = new SearchPage();
        searchPage.open();
        searchPage.acceptCookies();
    }

    @Test
    public void verifyNotFoundText() {
        searchPage.getSearchInput().sendKeys(faker.lorem().characters(10));
        searchPage.getSearchInput().sendKeys(Keys.ENTER);
        Assertions.assertEquals("По Вашему запросу ничего не найдено", searchPage.getNotFoundText());
    }

    @Test
    public void searchInputClearBtnDisplayedAfterSendKeys() {
        searchPage.getSearchInput().sendKeys("1");
        Assertions.assertTrue(searchPage.getSearchInputClearBtn().isDisplayed());
    }

    @Test
    public void clearSearchInput() {
        searchPage.getSearchInput().sendKeys("testText");
        searchPage.getSearchInputClearBtn().click();
        Assertions.assertTrue(searchPage.getSearchInput().getAttribute("value").isEmpty());
    }

    @Test
    public void searchProduct() {
        searchPage.getSearchInput().sendKeys("Пакет");
        searchPage.getSearchInput().sendKeys(Keys.ENTER);
        Assertions.assertAll("Verify search page after product was found",
                () -> Assertions.assertTrue(searchPage.getSearchResultProducts().isDisplayed()),
                () -> Assertions.assertTrue(searchPage.getSearchResultFilterCategory().isDisplayed()),
                () -> Assertions.assertTrue(searchPage.getSearchResultFilterPrice().isDisplayed()),
                () -> Assertions.assertTrue(searchPage.getSearchResultFilterManufacturer().isDisplayed())
        );
    }

    @AfterEach
    public void closeBrowser() {
        Driver.quitDriver();
    }
}
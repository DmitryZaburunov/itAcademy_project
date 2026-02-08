package by.fixPrice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchPage extends HomePage {
    private final String SEARCH_PAGE_URL = "https://fix-price.by/search";

    private final By NOT_FOUND_TEXT = By.xpath("//div[@class='page-content']//div[@class='empty search-not-found']//div[@class='title']");

    private final By SEARCH_INPUT = By.xpath("//div[@id='app-header']//input[@type='search']");

    private final By SEARCH_INPUT_CLEAR_BTN = By.xpath("//div[@id='app-header']//i[@data-test='close']");

    private final By SEARCH_RESULT_PRODUCTS = By.xpath("//div[@class='search-result']//main[@class='page-content']/div[@class='products']");

    private final By SEARCH_RESULT_FILTER_CATEGORY = By.xpath("//div[@class='search-result']//div[@class='filterM-popup-content']/div[1]/div[@class='title']");

    private final By SEARCH_RESULT_FILTER_PRICE = By.xpath("//div[@class='search-result']//div[@class='filterM-popup-content']/div[2]/div[@class='title']");

    private final By SEARCH_RESULT_FILTER_MANUFACTURER = By.xpath("//div[@class='search-result']//div[@class='filterM-popup-content']/div[3]/div[@class='title']");

    public void open() {
        logger.info("Opening Page [{}]", SEARCH_PAGE_URL);
        openPage(SEARCH_PAGE_URL);
    }

    public String getNotFoundText() {
        logger.info("getNotFoundText");
        return waitFVOE(NOT_FOUND_TEXT).getText();
    }

    public WebElement getSearchInput() {
        logger.info("getSearchInput");
        return waitFVOE(SEARCH_INPUT);
    }

    public WebElement getSearchInputClearBtn() {
        logger.info("getSearchInputClearBtn");
        return waitFVOE(SEARCH_INPUT_CLEAR_BTN);
    }

    public WebElement getSearchResultProducts() {
        logger.info("getSearchResultProducts");
        return waitFVOE(SEARCH_RESULT_PRODUCTS);
    }

    public WebElement getSearchResultFilterCategory() {
        logger.info("getSearchResultFilterCategory");
        return waitFVOE(SEARCH_RESULT_FILTER_CATEGORY);
    }

    public WebElement getSearchResultFilterPrice() {
        logger.info("getSearchResultFilterPrice");
        return waitFVOE(SEARCH_RESULT_FILTER_PRICE);
    }

    public WebElement getSearchResultFilterManufacturer() {
        logger.info("getSearchResultFilterManufacturer");
        return waitFVOE(SEARCH_RESULT_FILTER_MANUFACTURER);
    }
}

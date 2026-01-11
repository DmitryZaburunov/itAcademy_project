package by.fixPrice.pages;

import org.openqa.selenium.By;

public class SearchPage extends HomePage {
    private final String SEARCH_PAGE_URL = "https://fix-price.by/search";

    private final String NOT_FOUND_TEXT = "//div[@class=\"page-content\"]//div[@class=\"title\"]";

    public void open() {
        openPage(SEARCH_PAGE_URL);
    }

    public String getNotFoundText() {
        return driver.findElement(By.xpath(NOT_FOUND_TEXT)).getText();
    }
}

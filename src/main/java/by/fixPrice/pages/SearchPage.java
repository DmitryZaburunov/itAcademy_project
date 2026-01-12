package by.fixPrice.pages;

import org.openqa.selenium.By;

public class SearchPage extends HomePage {
    private final String SEARCH_PAGE_URL = "https://fix-price.by/search?q=qwer&sort=sold";

    private final By NOT_FOUND_TEXT = By.xpath("//div[@class='page-content']//div[@class='title']");

    public void open() {
        openPage(SEARCH_PAGE_URL);
    }

    public String getNotFoundText() {
        return waitForVisibleOfElement(NOT_FOUND_TEXT).getText();
    }
}

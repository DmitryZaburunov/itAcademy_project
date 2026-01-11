package by.fixPrice.ui;

import by.fixPrice.pages.SearchPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private SearchPage searchPage;

    @BeforeEach
    public void startupAndAcceptCookie() {
        searchPage = new SearchPage();
        searchPage.open();
        searchPage.acceptCookies();
    }

    @Test
    public void verifyNotFoundText() {
        Assertions.assertEquals("По Вашему запросу ничего не найдено", searchPage.getNotFoundText());
    }
}

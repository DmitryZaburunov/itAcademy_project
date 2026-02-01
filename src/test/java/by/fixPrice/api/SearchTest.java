package by.fixPrice.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchTest {
    private ProductSearchService productSearchService;

    @Test
    public void searchTest() {
        productSearchService = new ProductSearchService();
        productSearchService.doRequest("Книги");
        Assertions.assertTrue(productSearchService.getRequestCategories().contains("Книги"), "Search results is not contains searchText");
    }
}

package by.fixPrice.api;

import io.restassured.response.Response;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProductSearchService {
    private final String SEARCH_PRODUCT_URL = "https://api.fix-price.by/buyer/v1/product/filter/properties";
    public Logger logger = LoggerFactory.getLogger(this.getClass());

    private Response response;

    private Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json, text/plain, */*");
        headers.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/144.0.0.0 Safari/537.36");
        headers.put("x-city", "14");
        headers.put("X-Key", "Vm5vbkNQZzY0NVdGUlZWaFc1NFhGQT09OjoxWkNBMVhtNHBKQjRZRjhMZmZubE1BPT0=:e53ed7021182b35047cdb1c66ac9a050");
        return headers;
    }

    private Map<String, Object> getBody(String productName) {
        return Map.of(
                "category", List.of(),
                "searchText", productName,
                "filter", Map.of(
                        "brand", List.of(),
                        "price", List.of(),
                        "isSpecialPrice", false,
                        "isDividedPrice", false
                )
        );
    }

    public void doRequest(String product) {
        logger.info("Start doRequest by product [{}]",  product);
        response =
                given()
                        .headers(getHeaders())
                        .body(getBody(product))
                        .when()
                        .post(SEARCH_PRODUCT_URL);
    }

    public String getRequestCategories() {
        logger.info("get request categories");
        return response.jsonPath().getString("category");
    }
}

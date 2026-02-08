package by.fixPrice.api;

import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserAuthService {
    private final String USER_AUTH_URL = "https://api.fix-price.by/buyer/v2/auth/login";
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

    private String getBody(String email, String password) {
        return "{\"password\":\"" + password + "\",\"email\":\"" + email + "\"}";
    }

    public void doRequest(String email, String password) {
        logger.info("Start request user auth email:{}, password:{}", email, password);
        response =
                given()
                        .headers(getHeaders())
                        .body(getBody(email, password))
                        .when()
                        .post(USER_AUTH_URL);
    }

    public int getResponseCode() {
        logger.info("Get response code");
        return response.statusCode();
    }

    public String getResponseMessage(String path) {
        logger.info("Get response message");
        return response.jsonPath().getString(path);
    }

    public boolean getIsUserConfirmed() {
        logger.info("Get isUserConfirmed");
        return response.jsonPath().getBoolean("isUserConfirmed");
    }

}

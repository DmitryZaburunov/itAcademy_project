package by.fixPrice.api;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private final Faker faker = new Faker();

    private UserAuthService userAuthService;
    private final String validEmail = "dzmitry3077@gmail.com";
    private final String validPassword = "23025Fix";
    private final String invalidEmail = faker.internet().emailAddress();
    private final String invalidPassword = faker.internet().password();

    @BeforeEach
    public void setUp() {
        userAuthService = new UserAuthService();
    }

    @Test
    public void invalidAuthData() {
        userAuthService.doRequest(invalidEmail, invalidPassword);

        Assertions.assertAll(
                () -> Assertions.assertEquals(400, userAuthService.getResponseCode()),
                () -> Assertions.assertTrue(userAuthService.getResponseMessage("message").contains("Неверный логин или пароль. Проверьте введённые данные и попробуйте снова"))
        );
    }

    @Test
    public void validAuthData() {
        userAuthService.doRequest(validEmail, validPassword);

        Assertions.assertAll(
                () -> Assertions.assertFalse(userAuthService.getIsUserConfirmed()),
                () -> Assertions.assertEquals(200, userAuthService.getResponseCode())
        );
    }
}

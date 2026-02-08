package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import by.fixPrice.pages.LoginPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginPage loginPage;
    private Faker faker = new Faker();

    @BeforeEach
    public void startupAndAcceptCookie() {
        HomePage homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
        homePage.openLoginForm();
        loginPage = new LoginPage();
    }

    @Test
    public void successLoginByPhoneNumber() {
        loginPage.enterUserPhone(faker.phoneNumber().phoneNumber());
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Профиль", loginPage.getProfileBtnText(), "User isn't login by phone");
    }

    @Test
    public void successLoginByEmail() {
        loginPage.selectLoginForm("Email");
        loginPage.enterUserEmail("succesEmail@vfr.com");
        loginPage.enterUserPassword("92TQd8wddMC@4h!");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Профиль", loginPage.getProfileBtnText(), "User isn't login by email");
    }

    @Test
    public void checkboxIsNotCheckedByDefault() {
        Assertions.assertEquals(false, loginPage.getCheckboxChecked(), "Checkbox is checked by default");
    }

    @Test
    public void submitDisabledUntilCheckboxChecked() {
        Assertions.assertFalse(loginPage.getLoginFormSubmitButtonBy().isEnabled(), "Submit button is not disabled before checkbox will checked");
    }

    @Test
    public void forgotPasswordLinkRedirected() {
        loginPage.clickLoginFormForgotPasswordLink();
        Assertions.assertEquals("Восстановление пароля", loginPage.getLoginFormTitle(), "Login form title is not contains 'Восстановление пароля'");
    }

    @Test
    public void registerLinkRedirected() {
        loginPage.clickLoginFormRegisterLink();
        Assertions.assertEquals("Регистрация", loginPage.getLoginFormTitle(), "Login form title is not contains 'Регистрация'");
    }

    @Test
    public void loginFormHeaderHasTitle() {
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle(), "Login form is not have title");
    }

    @Test
    public void submitEmptyForm() {
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", loginPage.getLoginErrorText(), "Form submit error text is incorrect");
    }

    @Test
    public void submitFormWithoutPhone() {
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", loginPage.getLoginErrorText(), "Form submit error text isn't match");
    }

    @Test
    public void submitFormWithoutEmail() {
        loginPage.clickLoginFormToggleByEmail();
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать email", loginPage.getLoginErrorText(), "Email required text isn't match");
    }

    @Test
    public void submitFormWithoutPassword() {
        loginPage.enterUserPhone(faker.phoneNumber().phoneNumber());
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать пароль", loginPage.getPasswordErrorText(), "Password required text isn't match");
    }

    @Test
    public void submitFormWithIncorrectPhone() {
        loginPage.enterUserPhone(faker.phoneNumber().phoneNumber());
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный номер телефона", loginPage.getLoginErrorText(), "Incorrect or no phone text isn't match");
    }

    @Test
    public void submitFormWithIncorrectEmail() {
        loginPage.clickLoginFormToggleByEmail();
        loginPage.enterUserEmail(faker.internet().emailAddress());
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный email", loginPage.getLoginErrorText(), "Incorrect or no email text isn't match");
    }

    @Test
    public void submitFormWithInvalidPassword() {
        loginPage.enterUserPhone(faker.phoneNumber().phoneNumber());
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertTrue(loginPage.getInvalidCredentialErrorText().contains("Неверный логин или пароль. Проверьте введённые данные и попробуйте снова."), "Incorrect or no error text");
    }

    @Test
    public void submitFormWithInvalidCredentialToManyTimes() {
        loginPage.enterUserPhone(faker.phoneNumber().phoneNumber());
        loginPage.enterUserPassword(faker.internet().password(5, 9, true, true, true));
        loginPage.submitCheckbox();
        for (int i = 0; i < 3; i++) {
            loginPage.clickLoginFormSubmit();
        }
        Assertions.assertEquals("Слишком много запросов", loginPage.getInvalidCredentialErrorText(), "Incorrect or no error text");
    }

    @Test
    public void loginFormByPhoneBodyHasContent() {
        loginPage.clickLoginFormToggleByPhone();
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle(), "There's no or incorrect text 'Вход'");
        Assertions.assertEquals("По номеру телефона", loginPage.getLoginFormToggleByPhone(), "There's no or incorrect text 'По номеру телефона'");
        Assertions.assertEquals("По email", loginPage.getLoginFormToggleByEmail(), "There's no or incorrect text 'По email'");
        Assertions.assertEquals("Номер телефона", loginPage.getLoginFormLoginLabelByPhone(), "There's no or incorrect text 'Номер телефона'");
        Assertions.assertEquals("Пароль", loginPage.getLoginFormPasswordLabelByPhone(), "There's no or incorrect text 'Пароль'");
    }

    @Test
    public void loginFormByEmailBodyHasContent() {
        loginPage.clickLoginFormToggleByEmail();
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle(), "There's no or incorrect text 'Вход'");
        Assertions.assertEquals("По номеру телефона", loginPage.getLoginFormToggleByPhone(), "There's no or incorrect text 'По номеру телефона'");
        Assertions.assertEquals("По email", loginPage.getLoginFormToggleByEmail(), "There's no or incorrect text 'По email'");
        Assertions.assertEquals("Электронная почта", loginPage.getLoginFormLoginLabelByPhone(), "There's no or incorrect text 'Электронная почта'");
        Assertions.assertEquals("Пароль", loginPage.getLoginFormPasswordLabelByPhone(), "There's no or incorrect text 'Пароль'");
    }

    @AfterEach
    public void closeBrowser() {
        Driver.quitDriver();
    }
}

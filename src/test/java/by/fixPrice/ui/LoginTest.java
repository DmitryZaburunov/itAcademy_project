package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import by.fixPrice.pages.LoginPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private HomePage homePage;
    private LoginPage loginPage;

    @BeforeEach
    public void startupAndAcceptCookie() {
        homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
        homePage.openLoginForm();
        loginPage = new LoginPage();
    }

    @Test
    public void successLoginByPhoneNumber() {
        loginPage.enterUserPhone("333772320");
        loginPage.enterUserPassword("92TQbg8MC@sh4h!");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Профиль", loginPage.getProfileBtnText(), "User isn't login by phone");
    }

    @Test
    public void successLoginByEmail() {
        loginPage.selectLoginForm("Email");
        loginPage.enterUserEmail("dzmitry3077@gmail.com");
        loginPage.enterUserPassword("92TQbg8MC@sh4h!");
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
        Assertions.assertFalse(loginPage.getLoginFormSubmitButtonBy().isEnabled());
    }

    @Test
    public void forgotPasswordLinkRedirected() {
        loginPage.clickLoginFormForgotPasswordLink();
        Assertions.assertEquals("Восстановление пароля", loginPage.getLoginFormTitle());
    }

    @Test
    public void registerLinkRedirected() {
        loginPage.clickLoginFormRegisterLink();
        Assertions.assertEquals("Регистрация", loginPage.getLoginFormTitle());
    }

    @Test
    public void loginFormHeaderHasTitle() {
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle());
    }

    @Test
    public void submitEmptyForm() {
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", loginPage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutPhone() {
        loginPage.enterUserPassword("12342151");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", loginPage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutEmail() {
        loginPage.clickLoginFormToggleByEmail();
        loginPage.enterUserPassword("12324215");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать email", loginPage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutPassword() {
        loginPage.enterUserPhone("333779999");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать пароль", loginPage.getPasswordErrorText());
    }

    @Test
    public void submitFormWithIncorrectPhone() {
        loginPage.enterUserPhone("999999999");
        loginPage.enterUserPassword("12342151");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный номер телефона", loginPage.getLoginErrorText());
    }

    @Test
    public void submitFormWithIncorrectEmail() {
        loginPage.enterUserEmail("aaawadw@ddd");
        loginPage.enterUserPassword("12342151");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный email", loginPage.getLoginErrorText());
    }

    @Test
    public void submitFormWithInvalidPassword() {
        loginPage.enterUserPhone("333779999");
        loginPage.enterUserPassword("123");
        loginPage.submitCheckbox();
        loginPage.clickLoginFormSubmit();
        Assertions.assertEquals("Неверный логин или пароль. Проверьте введённые данные и попробуйте снова. Осталось попыток: 4", loginPage.getInvalidCredentialErrorText());
    }

    @Test
    public void loginFormByPhoneBodyHasContent() {
        loginPage.clickLoginFormToggleByPhone();
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle());
        Assertions.assertEquals("По номеру телефона", loginPage.getLoginFormToggleByPhone());
        Assertions.assertEquals("По email", loginPage.getLoginFormToggleByEmail());
        Assertions.assertEquals("Номер телефона", loginPage.getLoginFormLoginLabelByPhone());
        Assertions.assertEquals("Пароль", loginPage.getLoginFormPasswordLabelByPhone());
    }

    @Test
    public void loginFormByEmailBodyHasContent() {
        loginPage.clickLoginFormToggleByEmail();
        Assertions.assertEquals("Вход", loginPage.getLoginFormTitle());
        Assertions.assertEquals("По номеру телефона", loginPage.getLoginFormToggleByPhone());
        Assertions.assertEquals("По email", loginPage.getLoginFormToggleByEmail());
        Assertions.assertEquals("Электронная почта", loginPage.getLoginFormLoginLabelByPhone());
        Assertions.assertEquals("Пароль", loginPage.getLoginFormPasswordLabelByPhone());
    }

    @AfterEach
    public void closeBrowser() {
        Driver.quitDriver();
    }
}

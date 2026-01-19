package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    public HomePage homePage;

    @BeforeEach
    public void startupAndAcceptCookie() {
        homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
    }

    //позитиные кейсы

    @Test
    public void successLoginByPhoneNumber() {
        homePage.openLoginForm();
        homePage.enterUserPhone("333772320");
        homePage.enterUserPassword("92TQbg8MC@sh4h!");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Профиль", homePage.getProfileBtnText(), "User isn't login by phone");
    }

    @Test
    public void successLoginByEmail() {
        homePage.openLoginForm();
        homePage.selectLoginForm("Email");
        homePage.enterUserEmail("dzmitry3077@gmail.com");
        homePage.enterUserPassword("92TQbg8MC@sh4h!");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Профиль", homePage.getProfileBtnText(), "User isn't login by email");
    }

    @Test
    public void checkboxIsNotCheckedByDefault() {
        homePage.openLoginForm();
        Assertions.assertEquals(false, homePage.getCheckboxChecked(), "Checkbox is checked by default");
    }

    @Test
    public void submitDisabledUntilCheckboxChecked() {
        homePage.openLoginForm();
        Assertions.assertFalse(homePage.getLoginFormSubmitButtonBy().isEnabled());
    }

    @Test
    public void forgotPasswordLinkRedirected() {
        homePage.openLoginForm();
        homePage.clickLoginFormForgotPasswordLink();
        Assertions.assertEquals("Восстановление пароля", homePage.getLoginFormTitle());
    }

    @Test
    public void registerLinkRedirected() {
        homePage.openLoginForm();
        homePage.clickLoginFormRegisterLink();
        Assertions.assertEquals("Регистрация", homePage.getLoginFormTitle());
    }

    @Test
    public void loginFormHeaderHasTitle() {
        homePage.openLoginForm();
        Assertions.assertEquals("Вход", homePage.getLoginFormTitle());
    }

    //негативные тесты логина

    @Test
    public void submitEmptyForm() {
        homePage.openLoginForm();
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", homePage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutPhone() {
        homePage.openLoginForm();
        homePage.enterUserPassword("12342151");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать телефон", homePage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutEmail() {
        homePage.openLoginForm();
        homePage.clickLoginFormToggleByEmail();
        homePage.enterUserPassword("12324215");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать email",  homePage.getLoginErrorText());
    }

    @Test
    public void submitFormWithoutPassword() {
        homePage.openLoginForm();
        homePage.enterUserPhone("333779999");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Требуется указать пароль", homePage.getPasswordErrorText());
    }

    @Test
    public void submitFormWithIncorrectPhone() {
        homePage.openLoginForm();
        homePage.enterUserPhone("999999999");
        homePage.enterUserPassword("12342151");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный номер телефона", homePage.getLoginErrorText());
    }

    @Test
    public void submitFormWithIncorrectEmail() {
        homePage.openLoginForm();
        homePage.enterUserEmail("aaawadw@ddd");
        homePage.enterUserPassword("12342151");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Укажите корректный email", homePage.getLoginErrorText());
    }

    @Test
    public void submitFormWithInvalidPassword() {
        homePage.openLoginForm();
        homePage.enterUserPhone("333779999");
        homePage.enterUserPassword("123");
        homePage.submitCheckbox();
        homePage.clickLoginFormSubmit();
        Assertions.assertEquals("Неверный логин или пароль. Проверьте введённые данные и попробуйте снова. Осталось попыток: 4", homePage.getInvalidCredentialErrorText());
    }

    //UI тесты

    @Test
    public void loginFormByPhoneBodyHasContent() {
        homePage.openLoginForm();
        homePage.clickLoginFormToggleByPhone();
        Assertions.assertEquals("Вход", homePage.getLoginFormTitle());
        Assertions.assertEquals("По номеру телефона", homePage.getLoginFormToggleByPhone());
        Assertions.assertEquals("По email", homePage.getLoginFormToggleByEmail());
        Assertions.assertEquals("Номер телефона", homePage.getLoginFormLoginLabelByPhone());
        Assertions.assertEquals("Пароль", homePage.getLoginFormPasswordLabelByPhone());
    }

    @Test
    public void loginFormByEmailBodyHasContent() {
        homePage.openLoginForm();
        homePage.clickLoginFormToggleByEmail();
        Assertions.assertEquals("Вход", homePage.getLoginFormTitle());
        Assertions.assertEquals("По номеру телефона", homePage.getLoginFormToggleByPhone());
        Assertions.assertEquals("По email", homePage.getLoginFormToggleByEmail());
        Assertions.assertEquals("Электронная почта", homePage.getLoginFormLoginLabelByPhone());
        Assertions.assertEquals("Пароль", homePage.getLoginFormPasswordLabelByPhone());
    }

    @AfterEach
    public void closeBrowser() {
        Driver.quitDriver();
    }
}

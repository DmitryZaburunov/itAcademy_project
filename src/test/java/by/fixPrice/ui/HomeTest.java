package by.fixPrice.ui;

import by.fixPrice.driver.Driver;
import by.fixPrice.pages.HomePage;
import org.junit.jupiter.api.*;

public class HomeTest {
    public HomePage homePage;

    @BeforeEach
    public void startupAndAcceptCookie(){
        homePage = new HomePage();
        homePage.openPage();
        homePage.acceptCookies();
    }

    @Test
    public void loginFormHeaderHasTitle() {
        homePage.openLoginForm();
        Assertions.assertEquals("Вход",  homePage.getLoginFormTitle());
    }

    @Test
    public void loginFormByPhoneBodyHasContent() {
        homePage.openLoginForm();
        homePage.clickLoginFormToggleByPhone();
        Assertions.assertEquals("Вход",  homePage.getLoginFormTitle());
        Assertions.assertEquals("По номеру телефона", homePage.getLoginFormToggleByPhone());
        Assertions.assertEquals("По email", homePage.getLoginFormToggleByEmail());
        Assertions.assertEquals("Номер телефона", homePage.getLoginFormLoginLabelByPhone());
        Assertions.assertEquals("Пароль", homePage.getLoginFormPasswordLabelByPhone());
    }

    @Test
    public void loginFormByEmailBodyHasContent() {
        homePage.openLoginForm();
        homePage.clickLoginFormToggleByEmail();
        Assertions.assertEquals("Вход",  homePage.getLoginFormTitle());
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

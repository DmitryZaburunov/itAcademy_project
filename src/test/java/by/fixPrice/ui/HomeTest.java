package by.fixPrice.ui;

import by.fixPrice.pages.HomePage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}

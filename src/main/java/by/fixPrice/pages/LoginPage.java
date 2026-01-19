package by.fixPrice.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends HomePage {
    private final By LOGIN_FORM_TITLE = By.xpath("//dialog//header//h3[@class='title']");
    private final By LOGIN_FORM_TOGGLE_BY_PHONE = By.xpath("//dialog//div[@data-component='MultiToggle']//button[1]");
    private final By LOGIN_FORM_TOGGLE_BY_EMAIL = By.xpath("//dialog//div[@data-component='MultiToggle']//button[2]");
    private final By LOGIN_FORM_LOGIN_LABEL = By.xpath("//dialog//form//div[@class='login']//label[@class='label']");
    private final By LOGIN_FORM_LOGIN_INPUT = By.xpath("//dialog//form//div[@class='login']//input[@class='input-text']");
    private final By LOGIN_FORM_PASSWORD_LABEL = By.xpath("//dialog//form//div[@class='password']//label[@class='label']");
    private final By LOGIN_FORM_PASSWORD_INPUT = By.xpath("//dialog//form//div[@class='password']//input[@class='input-text']");
    private final By LOGIN_FORM_SUBMIT_BTN = By.xpath("//div[@class='login-form-modal']/form[@class='content']//button[@data-component='VButton']");
    private final By LOGIN_FORM_FORGOT_PASSWORD_LINK = By.xpath("//div[@class='login-form-modal']/button[@class='to-recovering button hug minimal full-width']");
    private final By LOGIN_FORM_REGISTER_LINK = By.xpath("//div[@class='login-form-modal']/button[@class='button hug minimal full-width']");
    private final By LOGIN_FORM_CHECKBOX = By.xpath("//div[@class='login-form-modal']//div[@data-test='checkbox']/div[@data-test='checkbox-field']");
    private final By LOGIN_FORM_LOGIN_EMPTY_INPUT_ERROR = By.xpath("//dialog//form//div[@class='login']//div[@data-test='error']");
    private final By LOGIN_FORM_PASSWORD_EMPTY_INPUT_ERROR = By.xpath("//dialog//form//div[@class='password']//div[@data-test='error']");
    private final By LOGIN_FORM_INVALID_CREDENTIAL_ERROR = By.xpath("//div[@id='modal']/dialog[@class='wrapper modal-child']/div[@data-component='AuthWrapperError']/p");

    public void clickLoginFormToggleByPhone() {
        waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).click();
    }

    public void clickLoginFormToggleByEmail() {
        waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).click();
    }

    public void selectLoginForm(String formType) {
        if (formType.equals("Phone")) {
            waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).click();
        }
        if (formType.equals("Email")) {
            waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).click();
        }
    }

    public void enterUserPhone(String phone) {
        waitFVOE(LOGIN_FORM_LOGIN_INPUT).sendKeys(phone);
    }

    public void enterUserEmail(String email) {
        waitFVOE(LOGIN_FORM_LOGIN_INPUT).sendKeys(email);
    }

    public void enterUserPassword(String password) {
        waitFVOE(LOGIN_FORM_PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginFormSubmit() {
        waitFVOE(LOGIN_FORM_SUBMIT_BTN).click();
    }

    public void clickLoginFormForgotPasswordLink() {
        waitFVOE(LOGIN_FORM_FORGOT_PASSWORD_LINK).click();
    }

    public void clickLoginFormRegisterLink() {
        waitFVOE(LOGIN_FORM_REGISTER_LINK).click();
    }

    public void submitCheckbox() {
        String checkboxCurrentClass = waitFVOE(LOGIN_FORM_CHECKBOX).getAttribute("class");

        if (checkboxCurrentClass.equals("checkbox-field")) {
            waitFVOE(LOGIN_FORM_CHECKBOX).click();
        }
    }

    public String getProfileBtnText() {
        return waitFVOE(PROFILE_BTN_TEXT).getText();
    }

    public Boolean getCheckboxChecked() {
        return waitFVOE(LOGIN_FORM_CHECKBOX).getAttribute("class").contains("checked");
    }

    public String getLoginFormTitle() {
        return waitFVOE(LOGIN_FORM_TITLE).getText();
    }

    public String getLoginFormToggleByPhone() {
        return waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).getText();
    }

    public String getLoginFormToggleByEmail() {
        return waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).getText();
    }

    public String getLoginFormLoginLabelByPhone() {
        return waitFVOE(LOGIN_FORM_LOGIN_LABEL).getText();
    }

    public WebElement getLoginFormLoginInputByPhone() {
        return waitFVOE(LOGIN_FORM_LOGIN_INPUT);
    }

    public String getLoginFormPasswordLabelByPhone() {
        return waitFVOE(LOGIN_FORM_PASSWORD_LABEL).getText();
    }

    public WebElement getLoginFormPasswordInputByPhone() {
        return waitFVOE(LOGIN_FORM_PASSWORD_INPUT);
    }

    public WebElement getLoginFormSubmitButtonBy() {
        return waitFVOE(LOGIN_FORM_SUBMIT_BTN);
    }

    public String getLoginErrorText() {
        return waitFVOE(LOGIN_FORM_LOGIN_EMPTY_INPUT_ERROR).getText();
    }

    public String getPasswordErrorText() {
        return waitFVOE(LOGIN_FORM_PASSWORD_EMPTY_INPUT_ERROR).getText();
    }

    public String getInvalidCredentialErrorText() {
        return waitFVOE(LOGIN_FORM_INVALID_CREDENTIAL_ERROR).getText();
    }
}

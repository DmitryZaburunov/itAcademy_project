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
        logger.info("Clicking on login form toggle by phone");
        waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).click();
    }

    public void clickLoginFormToggleByEmail() {
        logger.info("Clicking on login form toggle by email");
        waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).click();
    }

    public void selectLoginForm(String formType) {
        if (formType.equals("Phone")) {
            logger.info("Selecting login form to Phone");
            waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).click();
        }
        if (formType.equals("Email")) {
            logger.info("Selecting login form to email");
            waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).click();
        }
    }

    public void enterUserPhone(String phone) {
        logger.info("Entering user phone number");
        waitFVOE(LOGIN_FORM_LOGIN_INPUT).sendKeys(phone);
    }

    public void enterUserEmail(String email) {
        logger.info("Entering user email");
        waitFVOE(LOGIN_FORM_LOGIN_INPUT).sendKeys(email);
    }

    public void enterUserPassword(String password) {
        logger.info("Entering user password");
        waitFVOE(LOGIN_FORM_PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginFormSubmit() {
        logger.info("Clicking on login form submit");
        waitFVOE(LOGIN_FORM_SUBMIT_BTN).click();
    }

    public void clickLoginFormForgotPasswordLink() {
        logger.info("Clicking on login form forgot password link");
        waitFVOE(LOGIN_FORM_FORGOT_PASSWORD_LINK).click();
    }

    public void clickLoginFormRegisterLink() {
        logger.info("Clicking on login form register link");
        waitFVOE(LOGIN_FORM_REGISTER_LINK).click();
    }

    public void submitCheckbox() {
        logger.info("Getting checkbox status not checked");
        String checkboxCurrentClass = waitFVOE(LOGIN_FORM_CHECKBOX).getAttribute("class");

        if (checkboxCurrentClass.equals("checkbox-field")) {
            logger.info("Submitting checkbox");
            waitFVOE(LOGIN_FORM_CHECKBOX).click();
        }
    }

    public String getProfileBtnText() {
        logger.info("Getting profile button text");
        return waitFVOE(PROFILE_BTN_TEXT).getText();
    }

    public Boolean getCheckboxChecked() {
        logger.info("Getting checkbox status checked");
        return waitFVOE(LOGIN_FORM_CHECKBOX).getAttribute("class").contains("checked");
    }

    public String getLoginFormTitle() {
        logger.info("Getting login form title");
        return waitFVOE(LOGIN_FORM_TITLE).getText();
    }

    public String getLoginFormToggleByPhone() {
        logger.info("Getting login form toggle by phone");
        return waitFVOE(LOGIN_FORM_TOGGLE_BY_PHONE).getText();
    }

    public String getLoginFormToggleByEmail() {
        logger.info("Getting login form toggle by email");
        return waitFVOE(LOGIN_FORM_TOGGLE_BY_EMAIL).getText();
    }

    public String getLoginFormLoginLabelByPhone() {
        logger.info("Getting login form login label");
        return waitFVOE(LOGIN_FORM_LOGIN_LABEL).getText();
    }

    public String getLoginFormPasswordLabelByPhone() {
        logger.info("Getting login form password label");
        return waitFVOE(LOGIN_FORM_PASSWORD_LABEL).getText();
    }

    public WebElement getLoginFormSubmitButtonBy() {
        logger.info("Getting login form submit button");
        return waitFVOE(LOGIN_FORM_SUBMIT_BTN);
    }

    public String getLoginErrorText() {
        logger.info("Getting login error text");
        return waitFVOE(LOGIN_FORM_LOGIN_EMPTY_INPUT_ERROR).getText();
    }

    public String getPasswordErrorText() {
        logger.info("Getting password error text");
        return waitFVOE(LOGIN_FORM_PASSWORD_EMPTY_INPUT_ERROR).getText();
    }

    public String getInvalidCredentialErrorText() {
        logger.info("Getting invalid credential error text");
        return waitFVOE(LOGIN_FORM_INVALID_CREDENTIAL_ERROR).getText();
    }
}

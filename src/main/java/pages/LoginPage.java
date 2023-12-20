package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(xpath = "//input[@id='email']")
    private WebElement logInEmailField;
    @FindBy(xpath = "//input[@id='pass' and @name='login[password]']")
    private WebElement logInPasswordField;
    @FindBy(xpath = "//button[@id='send2' and @class = 'action login primary']")
    private WebElement signInButton;

    public void enterTextToLoginField(String email) {
        logInEmailField.sendKeys(email);
    }

    public void enterTextToPasswordField(String loginPassword) {
        logInPasswordField.sendKeys(loginPassword);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void login(String login, String password) {
        HomePage.clickSignInLink();
        enterTextToLoginField(login);
        enterTextToPasswordField(password);
        clickSignInButton();
    }
}

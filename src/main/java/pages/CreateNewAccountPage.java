package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage extends BasePage {
    @FindBy(id = "firstname")
    private WebElement firstNameField;
    @FindBy(id = "lastname")
    private WebElement lastNameField;
    @FindBy(id = "email_address")
    private WebElement emailAddressField;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordField;
    @FindBy(xpath = "//input[@id='password-confirmation']")
    private WebElement confirmationPasswordField;
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;

    public void enterFirstName(String firstname) {
        firstNameField.sendKeys(firstname);
    }

    public void enterLastName(String lastname) {
        lastNameField.sendKeys(lastname);
    }

    public void enterEmailAddress(String emailAddress) {
        emailAddressField.sendKeys(emailAddress);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void enterConfirmationPassword(String confirmationPassword) {
        confirmationPasswordField.sendKeys(confirmationPassword);
    }

    public void clickCreateAnAccountButton() {
        createAnAccountButton.click();
    }
}

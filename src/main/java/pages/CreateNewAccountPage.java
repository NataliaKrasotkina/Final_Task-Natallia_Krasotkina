package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewAccountPage {
    @FindBy(id = "firstname")
    private WebElement firstNameInput;
    @FindBy(id = "lastname")
    private WebElement lastNameInput;
    @FindBy(id = "email_address")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//div[@class='field confirmation required']")
    private WebElement confirmationPasswordInput;
    @FindBy(xpath = "//button[@class='action submit primary']")
    private WebElement createAnAccountButton;
}

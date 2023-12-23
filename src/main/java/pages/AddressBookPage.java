package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AddressBookPage extends BasePage {
    @FindBy(xpath = "//span[text()='Add New Address']")
    private WebElement addNewAddressButton;
    @FindBy(xpath = "//input[@id='telephone']")
    private WebElement phoneNumberField;
    @FindBy(xpath = "//input[@id='street_1']")
    private WebElement streetAddressField;
    @FindBy(xpath = "//input[@id='city']")
    private WebElement cityField;
    @FindBy(xpath = "//select[@id='region_id']")
    private WebElement stateProvinceList;
    @FindBy(xpath = "//select[@id='country']")
    private WebElement countryList;
    @FindBy(xpath = "//input[@id='zip']")
    private WebElement zipPostalCodeField;
    @FindBy(xpath = "//button [@class='action save primary']")
    private WebElement saveAddressButton;

    private String phoneNumberXpathPattern = "//tr/td[@class='col phone' and text()='%s']";


    public void clickAddNewAddressButton() {
        addNewAddressButton.click();
    }
    public void enterPhoneNumber(String phoneNumber) {//TODO: rename enterPhoneNumber(String phoneNumber)
        phoneNumberField.sendKeys(phoneNumber);
    }

    public void enterStreetAddress(String streetAddress) {//TODO: rename enterStreetAddress(String streetAddress)
        streetAddressField.sendKeys(streetAddress);
    }

    public void enterCity(String city) {//TODO: rename enterCity(String city)
        cityField.sendKeys(city);
    }

    public void enterZipPostalCode(String zipPostalCode) {
        zipPostalCodeField.sendKeys(zipPostalCode);
    }

    public void clickSaveAddressButton() {
        saveAddressButton.click();
    }

    public void selectCountry() {
        Select dropdown = new Select(countryList);
        List<WebElement> countries = dropdown.getOptions();
        dropdown.selectByValue(countries.get(9).getAttribute("value"));
    }

    public boolean isPhoneNumberDisplayed(String number) {
        return isElementDisplayed(By.xpath(String.format(phoneNumberXpathPattern, number)));
    }
}

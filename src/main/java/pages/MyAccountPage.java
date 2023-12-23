package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "// header//span[@class ='logged-in']")
    private WebElement accountName;
    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/customer/address/'and text()='Address Book']")
    private WebElement addressBookLink;


    public String getAccountName() {
        return accountName.getText();
    }

    public void waitForPageLoad() {
        waitForPageLoad(accountName);
    }

    public void clickAddressBookLink() {
        addressBookLink.click();
    }
}

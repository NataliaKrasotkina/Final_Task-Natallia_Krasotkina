package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    @FindBy(xpath = "// header//span[@class ='logged-in']")
    private WebElement accountName;

    public String getAccountName() {
        return accountName.getText();
    }

    public void waitForPageLoad() {
        waitForPageLoad(accountName);
    }
}

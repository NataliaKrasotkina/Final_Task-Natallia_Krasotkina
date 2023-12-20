package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")
    private WebElement createAnAccountLink;
    @FindBy(xpath = "//div[@class='panel header']//a[contains(@href,'https://magento.softwaretestingboard.com/customer/account/login')]")
    private static WebElement signInLink;


    public void clickCreateAnAccountLink() {
        createAnAccountLink.click();
    }

    public void waitForPageLoad() {
        waitForPageLoad(createAnAccountLink);
    }

    public static void clickSignInLink() {
        signInLink.click();
    }
}
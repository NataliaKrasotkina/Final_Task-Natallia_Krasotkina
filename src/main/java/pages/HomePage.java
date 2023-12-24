package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//div[@class='panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")
    private WebElement createAnAccountLink;
    @FindBy(xpath = "//div[@class='panel header']//a[contains(@href,'https://magento.softwaretestingboard.com/customer/account/login')]")
    private static WebElement signInLink;
    @FindBy(xpath = "//div[@class='panel header']//button[@data-action ='customer-menu-toggle']")
    private static WebElement switchArrow;
    @FindBy(xpath = "//div[@class='panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//a//span[text()='Women']")
    private WebElement womenLink;


    public void clickCreateAnAccountLink() {
        createAnAccountLink.click();
    }

    public void waitForPageLoad() {
        waitForElementVisible(createAnAccountLink);
    }

    public static void clickSignInLink() {
        signInLink.click();
    }

    public void clickSwitchArrow() {
        switchArrow.click();
    }

    public void clickMyAccountLink() {
        myAccountLink.click();
    }

    public void clickWomanLink() {
        womenLink.click();
    }

}
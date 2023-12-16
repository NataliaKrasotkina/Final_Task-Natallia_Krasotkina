package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    @FindBy(xpath = "//div[@class='panel header']//a[@href='https://magento.softwaretestingboard.com/customer/account/create/']")
    private WebElement createAnAccountLink;
}

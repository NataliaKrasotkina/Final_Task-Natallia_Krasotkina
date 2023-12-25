package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenTopsPage extends BasePage {
    @FindBy(xpath = "//ol[@class = 'products list items product-items']")
    private List<WebElement> topsProductsList;

    public void clickProductByIndex(int number) {
        topsProductsList.get(number).click();
    }
}

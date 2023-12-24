package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenPage extends BasePage {
    @FindBy(css = ".product-item-photo")
    private List<WebElement> productsList;

    public void clickProductByIndexIfExist(int number) {
        if (productsList.size() >= number) {
            productsList.get(number).click();
        }
    }
}
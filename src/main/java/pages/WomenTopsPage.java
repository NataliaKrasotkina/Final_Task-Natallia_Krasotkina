package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenTopsPage extends BasePage {
    @FindBy(css = ".grid .product-image-photo")
    private List<WebElement> topsProductsList;

    public void clickProductByIndex(int number) {
        topsProductsList.get(number).click();
    }
}

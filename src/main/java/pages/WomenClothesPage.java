package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WomenClothesPage extends BasePage {
    @FindBy(css = ".product-item-photo")
    private List<WebElement> productsList;
    @FindBy(xpath = "//a[@href='https://magento.softwaretestingboard.com/women/tops-women.html' and text()='Tops']")
    private WebElement womenTopsLink;


    public void clickProductByIndexIfExist(int number) {
        if (productsList.size() >= number) {
            productsList.get(number).click();
        }
    }

    public void clickWomenTopsLink() {
        womenTopsLink.click();
    }
}
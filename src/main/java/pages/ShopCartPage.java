package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class ShopCartPage extends BasePage {
    @FindBy(xpath = "//span[contains(@data-bind,'subtotal')]")
    private WebElement productsSubtotal;
    @FindBy(css = ".minicart-items .product-item-name a")
    private List<WebElement> productsNamesList;


    private String removeProductFromCartIconXpathPattern = "//div[@class='product-item-details']//a[text ()='%s']/../..//a[@class='action delete']";

    public int getProductsSubtotal() {
        waitForElementVisible(productsSubtotal);
        String subTotalValue = productsSubtotal.getText();
        subTotalValue = subTotalValue.replace("$", "");
        return (int) Double.parseDouble(subTotalValue);
    }

    public List<String> getProductNames() {
        List<String> productNames = new ArrayList<>();
        for (WebElement productName : productsNamesList) {
            productNames.add(productName.getText());

        }
        return productNames;
    }

    public void removeProductFromCart(String productName) {
        WebElement removeProductFromCartIcon = driver.findElement(By.xpath(String.format(removeProductFromCartIconXpathPattern, productName)));
        removeProductFromCartIcon.click();
        deleteConfirmButton.click();
    }
}

package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//a[@class='action towishlist']")
    private WebElement addToWishListLink;
    @FindBy(xpath = "//h1[@class ='page-title']")
    private WebElement productTitle;
    @FindBy(xpath = "//button[@title ='Add to Cart']")
    private WebElement addToCartButton;
    @FindBy(xpath = "//div[@class='product-info-price']//span[@class ='price-wrapper ']")
    private WebElement productPrice;
    @FindBy(xpath = "//div[@class='swatch-option text']")
    private List<WebElement> sizeList;
    @FindBy(xpath = "//div[@class='swatch-option color']")
    private List<WebElement> colorList;

    public void clickAddToWishListLink() {
        addToWishListLink.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public void selectProductSizeByIndex(int index) {
        sizeList.get(index).click();
    }

    public void selectProductColourByIndex(int index) {
        colorList.get(index).click();
    }

    public int getProductPrice() {
        return Integer.parseInt(productPrice.getAttribute("data-price-amount"));
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
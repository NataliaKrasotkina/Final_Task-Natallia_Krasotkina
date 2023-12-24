package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailsPage extends BasePage {
    @FindBy(xpath = "//a[@class='action towishlist']")
    private WebElement addToWishListLink;
    @FindBy(xpath = "//h1[@class ='page-title']")
    private WebElement productTitle;

    public void clickAddToWishListLink() {
        addToWishListLink.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
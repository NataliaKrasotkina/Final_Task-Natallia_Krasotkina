package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWishListPage extends BasePage {
    @FindBy(xpath = "//div[@data-container ='product-grid']//a[@class='product-item-link']")
    private WebElement productNameLink;
    @FindBy(xpath = "//div[@class= 'actions-secondary']//a[@class ='btn-remove action delete']")
    private WebElement removeFromWishListIcon;
    @FindBy(css = ".action.update")
    private WebElement updateWishListButton;

    public String getProductName() {
        return productNameLink.getText();
    }

    public void removeProductFromWishList() {
        updateWishListButton.click();
        waitForElementVisible(removeFromWishListIcon);
        removeFromWishListIcon.click();
    }
}
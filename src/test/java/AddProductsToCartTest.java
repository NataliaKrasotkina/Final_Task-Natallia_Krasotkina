import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

import java.util.ArrayList;
import java.util.List;

public class AddProductsToCartTest extends BaseTest {
    private List<String> productNames;
    private int subTotal;
    private final static String PASSWORD = "NK852456!NK";
    private final static String LOGIN = "nataliakrasotkina7@gmail.com";

    private HomePage homePage;
    private LoginPage loginPage;
    private WomenClothesPage womenPage;
    private WomenTopsPage womenTopsPage;
    private ProductDetailsPage productDetailsPage;
    private ShopCartPage shopCartPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        womenPage = new WomenClothesPage();
        productDetailsPage = new ProductDetailsPage();
        productNames = new ArrayList<>();
        womenTopsPage = new WomenTopsPage();
        shopCartPage = new ShopCartPage();

    }

    @AfterEach
    public void cleanUp() {
        for (String productName : shopCartPage.getProductNames()) {
            shopCartPage.removeProductFromCart(productName);
        }
    }

    @Test
    public void addProductsToCartTest() {
        loginToApp();
        navigateToClothesPage();
        addProductToCart(1);
        addProductToCart(2);
        addProductToCart(3);
        validateProductCart();
    }

    private void validateProductCart() {
        womenTopsPage.clickShopCartIcon();
        Assertions.assertEquals(subTotal, shopCartPage.getProductsSubtotal(), "Subtotal is not correct");
        Assertions.assertTrue(shopCartPage.getProductNames().containsAll(productNames), "list of added products is not correct");
    }

    private void addProductToCart(int productIndex) {
        womenTopsPage.clickProductByIndex(productIndex);
        productNames.add(productDetailsPage.getProductTitle());
        subTotal = subTotal + productDetailsPage.getProductPrice();
        productDetailsPage.selectProductSizeByIndex(0);
        productDetailsPage.selectProductColourByIndex(0);
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.waitForProductsNumberIcon();
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        womenPage.clickWomenTopsLink();
        productDetailsPage.waitForProductsNumberIcon();
    }

    public void loginToApp() {
        loginPage.login(LOGIN, PASSWORD);
    }

    private void navigateToClothesPage() {
        homePage.clickWomanLink();
        womenPage.clickWomenTopsLink();
    }
}
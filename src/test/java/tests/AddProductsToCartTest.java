package tests;

import cofiguration.MyTestWatcher;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.*;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MyTestWatcher.class)
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
    @Description("The test checks add products")
    public void addProductsToCartTest() {
        loginToApp();
        navigateToClothesPage();
        addProductToCart(1);
        addProductToCart(2);
        addProductToCart(3);
        validateProductCart();
    }

    @Step("Validate Product Cart")
    private void validateProductCart() {
        womenTopsPage.clickShopCartIcon();
        Assertions.assertEquals(subTotal, shopCartPage.getProductsSubtotal(), "Subtotal is not correct");
        Assertions.assertTrue(shopCartPage.getProductNames().containsAll(productNames), "list of added products is not correct");
    }

    @Step("Add Product To Cart")
    private void addProductToCart(int productIndex) {
        womenTopsPage.clickProductByIndex(productIndex);
        productNames.add(productDetailsPage.getProductTitle());
        subTotal = subTotal + productDetailsPage.getProductPrice();
        productDetailsPage.selectProductSizeByIndex(0);
        productDetailsPage.selectProductColourByIndex(0);
        productDetailsPage.clickAddToCartButton();
        productDetailsPage.waitForProductsNumberIcon();
        womenPage.clickWomenTopsLink();
        productDetailsPage.waitForProductsNumberIcon();
    }

    @Step("Login To App")
    public void loginToApp() {
        loginPage.login(LOGIN, PASSWORD);
    }

    @Step("Navigate To Clothes Page")
    private void navigateToClothesPage() {
        homePage.clickWomanLink();
        womenPage.clickWomenTopsLink();
    }
}
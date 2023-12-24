import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.*;

public class AddProductToWishlistTest extends BaseTest {
    private final static String PASSWORD = "NK852456!NK";
    private final static String LOGIN = "nataliakrasotkina7@gmail.com";
    private String productTitle;

    private HomePage homePage;
    private LoginPage loginPage;
    private WomenPage womenPage;
    private ProductDetailsPage productDetailsPage;
    private MyWishListPage myWishListPage;


    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        womenPage = new WomenPage();
        productDetailsPage = new ProductDetailsPage();
        myWishListPage = new MyWishListPage();
    }

    @AfterEach
    public void cleanUp() {
        myWishListPage.removeProductFromWishList();
    }

    @Test
    public void addProductToWishlistTest() {
        loginToApp();
        navigateToWomenPage();
        navigateToProductDetailsPage();
        addProductToWishList();
        validateProductAddedToWishList();
    }

    public void loginToApp() {
        loginPage.login(LOGIN, PASSWORD);
    }

    private void navigateToWomenPage() {
        homePage.clickWomanLink();
    }

    private void navigateToProductDetailsPage() {
        womenPage.clickProductByIndexIfExist(0);
        productTitle = productDetailsPage.getProductTitle();
    }

    private void addProductToWishList() {
        productDetailsPage.clickAddToWishListLink();
    }

    private void validateProductAddedToWishList() {
        Assertions.assertEquals(productTitle, myWishListPage.getProductName(), "Product is not added to wishlist");
    }
}
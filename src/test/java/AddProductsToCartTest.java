import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductDetailsPage;
import pages.WomenClothesPage;

public class AddProductsToCartTest extends BaseTest {

    private final static String PASSWORD = "NK852456!NK";
    private final static String LOGIN = "nataliakrasotkina7@gmail.com";

    private HomePage homePage;
    private LoginPage loginPage;
    private WomenClothesPage womenPage;
    private ProductDetailsPage productDetailsPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        womenPage = new WomenClothesPage();
        productDetailsPage = new ProductDetailsPage();
    }

    @Test
    public void addProductsToCartTest() {
        loginToApp();
        navigateToClothesPage();
    }

    public void loginToApp() {
        loginPage.login(LOGIN, PASSWORD);
    }

    private void navigateToClothesPage() {
        homePage.clickWomanLink();
        womenPage.clickWomenTopsLink();
    }
}
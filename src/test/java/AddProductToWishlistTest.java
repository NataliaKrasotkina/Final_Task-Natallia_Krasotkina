import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddressBookPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class AddProductToWishlistTest extends BaseTest {
    private final static String PASSWORD = "NK852456!NK";
    private final static String LOGIN = "nataliakrasotkina7@gmail.com";

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private AddressBookPage addressBookPage;


    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();

    }

    @Test
    public void addProductToWishlistTest() {
        loginPage.login(LOGIN, PASSWORD);
        homePage.clickWomanLink();
    }
}
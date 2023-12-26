import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AddressBookPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;

public class AddAddressTest extends BaseTest {
    private final static String PASSWORD = "NK852456!NK";
    private final static String LOGIN = "nataliakrasotkina7@gmail.com";
    private final static String STREET_ADDRESS = "Test Street 1";
    private final static String CITY = "Test City 1";
    private final static String ZIP_POSTAL_CODE = "12345";
    private final static String PHONE_NUMBER = "+" + ((int) (Math.random() * 1000000000));

    private HomePage homePage;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;
    private AddressBookPage addressBookPage;


    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        addressBookPage = new AddressBookPage();
    }

    @AfterEach
    public void cleanUp() {
        addressBookPage.deleteAddressRecord(PHONE_NUMBER);
    }

    @Test
    public void addAddressTest() {
        loginToApp();
        navigateToMyAccount();
        addNewAddress();
        validateAddressAdded();
    }

    public void loginToApp() {
        loginPage.login(LOGIN, PASSWORD);
    }

    private void navigateToMyAccount() {
        homePage.clickSwitchArrow();
        homePage.clickMyAccountLink();
    }

    private void addNewAddress() {
        myAccountPage.clickAddressBookLink();
        addressBookPage.clickAddNewAddressButton();
        addressBookPage.enterPhoneNumber(PHONE_NUMBER);
        addressBookPage.enterStreetAddress(STREET_ADDRESS);
        addressBookPage.enterCity(CITY);
        addressBookPage.enterZipPostalCode(ZIP_POSTAL_CODE);
        addressBookPage.selectCountry();
        addressBookPage.clickSaveAddressButton();
    }

    private void validateAddressAdded() {
        Assertions.assertTrue(addressBookPage.isPhoneNumberDisplayed(PHONE_NUMBER), "Address is not added");
    }
}

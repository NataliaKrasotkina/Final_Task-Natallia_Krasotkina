import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.CreateNewAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.UUID;

public class CreateAccountTest extends BaseTest {
    private final static String FIRST_NAME = "Natallia";
    private final static String LAST_NAME = "Krasotkina";
    private final static String EMAIL = UUID.randomUUID().toString().substring(0, 4) + "@gmail.com";
    private final static String PASSWORD = "NK852456!NK";
    private final static String CREATED_ACCOUNT_TEXT = String.format("Welcome, %s %s!", FIRST_NAME, LAST_NAME);

    private HomePage homePage;
    private CreateNewAccountPage createNewAccountPage;
    private MyAccountPage myAccountPage;

    @BeforeEach
    public void setUp() {
        homePage = new HomePage();
        myAccountPage = new MyAccountPage();
        createNewAccountPage = new CreateNewAccountPage();
    }

    @Test
    public void createAccountTest() {
        clickCreateAnAccountLink();
        createAccount();
        validateAccountCreated();
    }

    private void clickCreateAnAccountLink() {
        homePage.waitForPageLoad();
        homePage.clickCreateAnAccountLink();
    }

    private void createAccount() {
        createNewAccountPage.enterTextToFirstNameField(FIRST_NAME);
        createNewAccountPage.enterTextToLastNameField(LAST_NAME);
        createNewAccountPage.enterTextToEmailAddressField(EMAIL);
        createNewAccountPage.enterTextToPasswordField(PASSWORD);
        createNewAccountPage.enterTextToConfirmationPasswordField(PASSWORD);
        createNewAccountPage.clickCreateAnAccountButton();
        myAccountPage.waitForPageLoad();
    }

    private void validateAccountCreated() {
        Assertions.assertEquals(myAccountPage.getAccountName(), CREATED_ACCOUNT_TEXT, "Account is not created");
    }
}




package tests;

import cofiguration.MyTestWatcher;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.CreateNewAccountPage;
import pages.HomePage;
import pages.MyAccountPage;

import java.util.UUID;

@ExtendWith(MyTestWatcher.class)
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
    @Description("The test checks new account creation")
    public void createAccountTest() {
        clickCreateAnAccountLink();
        createAccount();
        validateAccountCreated();
    }

    @Step("Click Create An Account Link")
    private void clickCreateAnAccountLink() {
        homePage.waitForPageLoad();
        homePage.clickCreateAnAccountLink();
    }

    @Step("Create Account")
    private void createAccount() {
        createNewAccountPage.enterFirstName(FIRST_NAME);
        createNewAccountPage.enterLastName(LAST_NAME);
        createNewAccountPage.enterEmailAddress(EMAIL);
        createNewAccountPage.enterPassword(PASSWORD);
        createNewAccountPage.enterConfirmationPassword(PASSWORD);
        createNewAccountPage.clickCreateAnAccountButton();
        myAccountPage.waitForPageLoad();
    }

    @Step("Validate Account Created")
    private void validateAccountCreated() {
        Assertions.assertEquals(myAccountPage.getAccountName(), CREATED_ACCOUNT_TEXT, "Account is not created");
    }
}




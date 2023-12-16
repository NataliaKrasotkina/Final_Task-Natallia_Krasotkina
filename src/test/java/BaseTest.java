import cofiguration.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    private WebDriver driver;
    private final static String MAGENTO_URL = "https://magento.softwaretestingboard.com";

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        driver.get(MAGENTO_URL);
    }

    @AfterEach
    void cleanup() {

        DriverManager.quit();
    }
}

package tests;

import cofiguration.DriverManager;
import cofiguration.MyTestWatcher;
import com.google.common.collect.ImmutableMap;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;

import static com.github.automatedowl.tools.AllureEnvironmentWriter.allureEnvironmentWriter;

@ExtendWith(MyTestWatcher.class)
public class BaseTest {
    private static WebDriver driver;
    private final static String MAGENTO_URL = "https://magento.softwaretestingboard.com";

    @BeforeAll
    public static void setAllureEnvironment() {
        allureEnvironmentWriter(
                ImmutableMap.<String, String>builder()
                        .put("Browser", DriverManager.getInfo())
                        .put("URL", MAGENTO_URL)
                        .build(), System.getProperty("user.dir")
                        + "\\allure-results\\");
    }

    @BeforeEach
    void setup() {
        driver = DriverManager.getInstance();
        driver.get(MAGENTO_URL);
    }

    @AfterAll
    static void cleanup() {
        DriverManager.quit();
    }
}

package cofiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getInstance() {
        if (driver.get() == null) {

            driver.set(new ChromeDriver());
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }
        return driver.get();
    }
    public static void quit() {
        driver.get().quit();
        driver.set(null);
    }
}

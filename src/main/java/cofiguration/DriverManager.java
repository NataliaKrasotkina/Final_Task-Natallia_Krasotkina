package cofiguration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getInstance() {
        if (driver.get() == null) {
            switch (RunConfiguration.runType) {
                case LOCAL:
                    localRun();
                    break;
                case SELENIUM_GRID:
                    seleniumGridRun();
                    break;
                case SAUCE_LABS:
                    sauceLabsRun();
                    break;
            }
            driver.get().manage().window().maximize();
            driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }
        return driver.get();
    }

    private static void localRun() {
        switch (RunConfiguration.browser) {
            case CHROME:
                driver.set(new ChromeDriver());
                break;
            case FIREFOX:
                driver.set(new FirefoxDriver());
        }
    }

    private static void seleniumGridRun() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        switch (RunConfiguration.browser) {
            case CHROME:
                capabilities.setCapability("browserName", "chrome");
                break;
            case FIREFOX:
                capabilities.setCapability("browserName", "firefox");
        }

        try {
            driver.set(new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    capabilities
            ));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sauceLabsRun() {
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", "oauth-nataliakrasotkina7-1ad75");
        sauceOptions.put("accessKey", "f07e0903-40bb-46d6-97d0-af8817a1af12");
        sauceOptions.put("build", "selenium-build-G40Y1");
        sauceOptions.put("name", "<your test name>");

        switch (RunConfiguration.browser) {
            case CHROME:
                ChromeOptions chromeBrowserOptions = new ChromeOptions();
                chromeBrowserOptions.setPlatformName("Windows 11");
                chromeBrowserOptions.setBrowserVersion("latest");
                chromeBrowserOptions.setCapability("sauce:options", sauceOptions);
                driver.set(new ChromeDriver(chromeBrowserOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxBrowserOptions = new FirefoxOptions();
                firefoxBrowserOptions.setPlatformName("Windows 11");
                firefoxBrowserOptions.setBrowserVersion("latest");
                firefoxBrowserOptions.setCapability("sauce:options", sauceOptions);
                driver.set(new FirefoxDriver(firefoxBrowserOptions));
                break;
        }
    }

    public static String getInfo() {
        var cap = ((RemoteWebDriver) getInstance()).getCapabilities();
        String browserName = cap.getBrowserName();
        String platform = cap.getPlatformName().toString();
        String version = cap.getBrowserVersion();
        String dateAndTime = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        return String.format("browser: %s v: %s platform: %s date-time: %s", browserName, version, platform, dateAndTime);
    }

    public static void quit() {
        driver.get().quit();
        driver.set(null);
    }
}
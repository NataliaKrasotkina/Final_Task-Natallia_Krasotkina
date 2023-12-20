package pages;

import cofiguration.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        driver = DriverManager.getInstance();
        PageFactory.initElements(driver, this);
    }

    protected void waitForPageLoad(WebElement element) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getInstance(), Duration.ofSeconds(60));
        wait.pollingEvery(Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException ex) {
            return false;
        }
    }
}

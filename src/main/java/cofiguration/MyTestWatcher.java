package cofiguration;

import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class MyTestWatcher implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext extensionContext, Throwable throwable) {
        makeScreenshotOnFailure();
    }

    @Attachment("Screenshot on failure")
    public byte[] makeScreenshotOnFailure() {
        return ((TakesScreenshot) DriverManager.getInstance()).getScreenshotAs(OutputType.BYTES);
    }
}
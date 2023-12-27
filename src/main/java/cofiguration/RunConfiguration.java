package cofiguration;

import static cofiguration.RunConfiguration.Browser.CHROME;
import static cofiguration.RunConfiguration.RunType.LOCAL;

public class RunConfiguration {
    public static final Browser browser = CHROME;
    public static final RunType runType = LOCAL;

    enum Browser {
        CHROME, FIREFOX;
    }

    enum RunType {
        LOCAL, SELENIUM_GRID, SAUCE_LABS;
    }
}

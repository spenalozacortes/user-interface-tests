package tests;

import config.EnvironmentConfig;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.isBrowserStarted;

public abstract class BaseTest {

    String url;

    @BeforeMethod
    public void setup() {
        url = EnvironmentConfig.getUrl();
        getBrowser().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}

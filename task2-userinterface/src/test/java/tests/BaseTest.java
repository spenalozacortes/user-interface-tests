package tests;

import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import config.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static aquality.selenium.browser.AqualityServices.isBrowserStarted;

public abstract class BaseTest {
    String url;
    ISettingsFile testData = new JsonSettingsFile("testData.json");

    @BeforeMethod
    public void setup() {
        url = Configuration.getUrl();
        getBrowser().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (isBrowserStarted()) {
            getBrowser().quit();
        }
    }
}

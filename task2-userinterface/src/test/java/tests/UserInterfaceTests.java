package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.configuration.Configuration;
import org.testng.annotations.Test;

public class UserInterfaceTests {

    @Test
    public void test() {
        Browser browser = AqualityServices.getBrowser();
        String url = Configuration.getUrl();

        browser.maximize();
        browser.goTo(url);
        browser.waitForPageToLoad();

        browser.quit();
    }
}

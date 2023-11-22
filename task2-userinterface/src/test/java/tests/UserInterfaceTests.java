package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import org.testng.annotations.Test;

public class UserInterfaceTests {

    @Test
    public void test() {
        Browser browser = AqualityServices.getBrowser();

        browser.maximize();
        browser.goTo("https://wikipedia.org");
        browser.waitForPageToLoad();

        browser.quit();
    }
}

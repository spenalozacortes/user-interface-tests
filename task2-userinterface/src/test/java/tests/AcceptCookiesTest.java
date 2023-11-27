package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CookiesForm;
import pages.HomePageForm;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static config.EnvironmentConfig.getUrl;

public class AcceptCookiesTest extends BaseTest {

    private HomePageForm homePage;
    private CookiesForm cookiesForm;

    @Test
    public void acceptCookiesTest() {
        getBrowser().goTo(getUrl());
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        cookiesForm = new CookiesForm();
        cookiesForm.clickAcceptCookiesBtn();
        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), "Cookies form is not closed");
    }
}

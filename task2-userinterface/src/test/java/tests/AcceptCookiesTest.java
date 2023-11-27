package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CookiesForm;
import pages.HomePageForm;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class AcceptCookiesTest extends BaseTest {

    HomePageForm homePage;
    CookiesForm cookiesForm;

    @Test
    public void acceptCookiesTest() {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        cookiesForm = new CookiesForm();
        cookiesForm.clickAcceptCookiesBtn();
        Assert.assertTrue(cookiesForm.state().waitForNotDisplayed(), "Cookies form is not closed");
    }
}

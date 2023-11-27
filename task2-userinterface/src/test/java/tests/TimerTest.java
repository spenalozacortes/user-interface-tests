package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageForm;
import pages.LoginForm;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TimerTest extends BaseTest {

    private HomePageForm homePage;
    private LoginForm loginForm;
    private static final String TIMER = "00:00:00";

    @Test
    public void timerTest() {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        loginForm = new LoginForm();
        String actualTimer = loginForm.getTimerText();
        Assert.assertEquals(actualTimer, TIMER, String.format("Timer starts at %s instead of %s", actualTimer, TIMER));
    }
}

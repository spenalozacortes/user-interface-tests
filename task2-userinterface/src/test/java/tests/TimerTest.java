package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.HomePage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static config.EnvironmentConfig.getUrl;

public class TimerTest extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;
    private static final String TIMER = "00:00:00";

    @Test
    public void timerTest() {
        getBrowser().goTo(getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        gamePage = new GamePage();
        String actualTimer = gamePage.loginForm().getTimerText();
        Assert.assertEquals(actualTimer, TIMER, String.format("Timer starts at %s instead of %s", actualTimer, TIMER));
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageForm;
import pages.LoginForm;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class TimerTest extends BaseTest {

    HomePageForm homePage;
    LoginForm loginForm;

    @Test
    public void timerTest() {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        loginForm = new LoginForm();

        String expectedTimer = testData.getValue("/timer").toString();

        Assert.assertEquals(loginForm.getTimerText(), expectedTimer, "Timer doesn't start at expected value");
    }
}

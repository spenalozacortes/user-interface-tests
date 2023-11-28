package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.HomePage;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static config.EnvironmentConfig.getUrl;

public class HideHelpTest extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;

    @Test
    public void hideHelpTest() {
        getBrowser().goTo(getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        gamePage = new GamePage();
        gamePage.helpForm().clickHideHelpBtn();
        Assert.assertTrue(gamePage.helpForm().state().waitForNotDisplayed(), "Help form is not hidden");
    }
}

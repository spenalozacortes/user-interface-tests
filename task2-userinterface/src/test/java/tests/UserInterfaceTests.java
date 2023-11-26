package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import config.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.HomePage;
import utils.RandomUtils;

import java.awt.*;

public class UserInterfaceTests {

    Browser browser;
    String url;
    ISettingsFile testData = new JsonSettingsFile("testData.json");

    @BeforeMethod
    public void setup() {
        browser = AqualityServices.getBrowser();
        url = Configuration.getUrl();

        browser.maximize();
        browser.goTo(url);
        browser.waitForPageToLoad();
    }

    @AfterMethod
    public void tearDown() {
        browser.quit();
    }

    @Test
    public void test1() throws AWTException {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        Assert.assertTrue(gamePage.isPageIndicatorDisplayed("1"), "Card '1' is not open");

        String email = RandomUtils.generateRandomEmail();
        String password = RandomUtils.generateRandomPassword(email);
        String domain = testData.getValue("/domain").toString();
        String suffix = testData.getValue("/suffix").toString();

        gamePage.setPassword(password);
        gamePage.setEmail(email);
        gamePage.setDomain(domain);
        gamePage.clickBtnDropdown();
        gamePage.selectSuffix(suffix);
        gamePage.checkChbTerms();
        gamePage.clickBtnNext1();
        Assert.assertTrue(gamePage.isPageIndicatorDisplayed("2"), "Card '2' is not open");

        String imagePath = testData.getValue("/image").toString();
        int numberOfInterests = (int) testData.getValue("/interests");

        gamePage.uploadPicture(imagePath);
        gamePage.checkChbUnselectAll();
        gamePage.selectInterests(numberOfInterests);
        gamePage.clickBtnNext2();
        Assert.assertTrue(gamePage.isPageIndicatorDisplayed("3"), "Card '3' is not open");
    }

    @Test
    public void test2() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        gamePage.help.clickBtnHideHelp();
        Assert.assertTrue(gamePage.help.isHelpHidden(), "Help form is not hidden");
    }

    @Test
    public void test3() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        gamePage.cookies.clickBtnAcceptCookies();
        Assert.assertFalse(gamePage.cookies.state().isDisplayed(), "Cookies form is not closed");
    }

    @Test
    public void test4() {
        HomePage homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();

        String expectedTimer = testData.getValue("/timer").toString();

        Assert.assertEquals(gamePage.getTimerText(), expectedTimer, "Timer doesn't start at expected value");
    }
}

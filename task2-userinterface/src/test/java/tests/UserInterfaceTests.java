package tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import aquality.selenium.configuration.Configuration;
import aquality.selenium.forms.GamePage;
import aquality.selenium.forms.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class UserInterfaceTests {

    Browser browser;
    String url;

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

        // TODO: data provider
        gamePage.setTxbPassword("Abcde12345"); // TODO: random password
        gamePage.setTxbEmail("abcde");
        gamePage.setTxbDomain("mail");
        gamePage.clickBtnDropdown();
        gamePage.selectDropdownByText(".com");
        gamePage.checkChbTerms();
        gamePage.clickBtnNext1();
        Assert.assertTrue(gamePage.isPageIndicatorDisplayed("2"), "Card '2' is not open");

        gamePage.uploadPicture("src/test/resources/java-collections.png");
        gamePage.checkChbUnselectAll();
        // TODO: random interests
        gamePage.selectInterest(0);
        gamePage.selectInterest(1);
        gamePage.selectInterest(2);
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
        Assert.assertFalse(gamePage.cookies.state().isDisplayed(), "Cookies form not closed");
    }

    @Test
    public void test4() {
        HomePage homePage = new HomePage();
//        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        Assert.assertEquals(gamePage.getTimerText(), "00:00:00");
    }
}

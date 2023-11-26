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
import pages.*;
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
        HomePageForm homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        LoginForm loginForm = new LoginForm();
        Assert.assertTrue(loginForm.state().waitForDisplayed(), "Card '1' is not open");

        String email = RandomUtils.generateRandomEmail();
        String password = RandomUtils.generateRandomPassword(email);
        String domain = testData.getValue("/domain").toString();
        String suffix = testData.getValue("/suffix").toString();

        loginForm.setPassword(password);
        loginForm.setEmail(email);
        loginForm.setDomain(domain);
        loginForm.clickBtnDropdown();
        loginForm.selectSuffix(suffix);
        loginForm.checkChbTerms();
        loginForm.clickBtnNext();
        InterestsForm interestsForm = new InterestsForm();
        Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Card '2' is not open");

        String imagePath = testData.getValue("/image").toString();
        int numberOfInterests = (int) testData.getValue("/interests");

        interestsForm.uploadPicture(imagePath);
        interestsForm.checkChbUnselectAll();
        interestsForm.selectInterests(numberOfInterests);
        interestsForm.clickBtnNext();
        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Card '3' is not open");
    }

    @Test
    public void test2() {
        HomePageForm homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        gamePage.help.clickBtnHideHelp();
        Assert.assertTrue(gamePage.help.isHelpHidden(), "Help form is not hidden");
    }

    @Test
    public void test3() {
        HomePageForm homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        GamePage gamePage = new GamePage();
        gamePage.cookies.clickBtnAcceptCookies();
        Assert.assertFalse(gamePage.cookies.state().isDisplayed(), "Cookies form is not closed");
    }

    @Test
    public void test4() {
        HomePageForm homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        LoginForm loginForm = new LoginForm();

        String expectedTimer = testData.getValue("/timer").toString();

        Assert.assertEquals(loginForm.getTimerText(), expectedTimer, "Timer doesn't start at expected value");
    }
}

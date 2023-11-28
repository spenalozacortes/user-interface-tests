package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GamePage;
import pages.HomePage;
import utils.RandomUtils;

import static aquality.selenium.browser.AqualityServices.getBrowser;
import static config.EnvironmentConfig.getUrl;

public class LoginTest extends BaseTest {

    private HomePage homePage;
    private GamePage gamePage;
    private static final int EMAIL_LENGTH = 8;
    private static final int PASSWORD_LENGTH = 10;
    private static final int DOMAIN_LENGTH = 5;
    private static final int INTERESTS = 3;
    private static final String IMAGE_PATH = "src/test/resources/java-collections.png";

    @Test
    public void loginTest() {
        getBrowser().goTo(getUrl());
        homePage = new HomePage();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        gamePage = new GamePage();
        Assert.assertTrue(gamePage.loginForm().state().waitForDisplayed(), "Login form should be displayed");

        String email = RandomUtils.generateRandomString(EMAIL_LENGTH);
        String password = RandomUtils.generateRandomPassword(PASSWORD_LENGTH, email);
        String domain = RandomUtils.generateRandomString(DOMAIN_LENGTH);

        gamePage.loginForm().setPassword(password);
        gamePage.loginForm().setEmail(email);
        gamePage.loginForm().setDomain(domain);
        gamePage.loginForm().clickDropdownBtn();
        gamePage.loginForm().selectRandomSuffix();
        gamePage.loginForm().checkTermsCb();
        gamePage.loginForm().clickNextBtn();
        Assert.assertTrue(gamePage.interestsForm().state().waitForDisplayed(), "Interests form should be displayed");

        gamePage.interestsForm().uploadPicture(IMAGE_PATH);
        gamePage.interestsForm().checkUnselectAllCb();
        gamePage.interestsForm().selectRandomInterests(INTERESTS);
        gamePage.interestsForm().clickNextBtn();
        Assert.assertTrue(gamePage.personalDetailsForm().state().waitForDisplayed(), "Personal details form should be displayed");
    }
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageForm;
import pages.InterestsForm;
import pages.LoginForm;
import pages.PersonalDetailsForm;
import utils.RandomUtils;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class LoginTest extends BaseTest {

    private HomePageForm homePage;
    private LoginForm loginForm;
    private InterestsForm interestsForm;
    private static final int EMAIL_LENGTH = 8;
    private static final int PASSWORD_LENGTH = 10;
    private static final int DOMAIN_LENGTH = 5;
    private static final int INTERESTS = 3;
    private static final String IMAGE_PATH = "src/test/resources/java-collections.png";

    @Test
    public void loginTest() {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        loginForm = new LoginForm();
        Assert.assertTrue(loginForm.state().waitForDisplayed(), "Card '1' is not open");

        String email = RandomUtils.generateRandomString(EMAIL_LENGTH);
        String password = RandomUtils.generateRandomPassword(PASSWORD_LENGTH, email);
        String domain = RandomUtils.generateRandomString(DOMAIN_LENGTH);

        loginForm.setPassword(password);
        loginForm.setEmail(email);
        loginForm.setDomain(domain);
        loginForm.clickDropdownBtn();
        loginForm.selectRandomSuffix();
        loginForm.checkTermsCb();
        loginForm.clickNextBtn();
        interestsForm = new InterestsForm();
        Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Card '2' is not open");

        interestsForm.uploadPicture(IMAGE_PATH);
        interestsForm.checkUnselectAllCb();
        interestsForm.selectRandomInterests(INTERESTS);
        interestsForm.clickNextBtn();
        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Card '3' is not open");
    }
}

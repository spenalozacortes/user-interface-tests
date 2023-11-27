package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePageForm;
import pages.InterestsForm;
import pages.LoginForm;
import pages.PersonalDetailsForm;
import utils.RandomUtils;

import java.awt.*;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class LoginTest extends BaseTest {

    HomePageForm homePage;
    LoginForm loginForm;
    InterestsForm interestsForm;

    final static int INTERESTS = 3;
    final static String IMAGE_PATH = "src/test/resources/java-collections.png";

    @Test
    public void loginTest() throws AWTException {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickLinkNext();
        loginForm = new LoginForm();
        Assert.assertTrue(loginForm.state().waitForDisplayed(), "Card '1' is not open");

        String email = RandomUtils.generateRandomEmail();
        String password = RandomUtils.generateRandomPassword(email);

        loginForm.setPassword(password);
        loginForm.setEmail(email);
        loginForm.setDomain("mail");
        loginForm.clickBtnDropdown();
        loginForm.selectSuffix(".com");
        loginForm.checkChbTerms();
        loginForm.clickBtnNext();
        interestsForm = new InterestsForm();
        Assert.assertTrue(interestsForm.state().waitForDisplayed(), "Card '2' is not open");

        interestsForm.uploadPicture(IMAGE_PATH);
        interestsForm.checkChbUnselectAll();
        interestsForm.selectInterests(INTERESTS);
        interestsForm.clickBtnNext();
        PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();
        Assert.assertTrue(personalDetailsForm.state().waitForDisplayed(), "Card '3' is not open");
    }
}

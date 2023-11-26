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
        String domain = testData.getValue("/domain").toString();
        String suffix = testData.getValue("/suffix").toString();

        loginForm.setPassword(password);
        loginForm.setEmail(email);
        loginForm.setDomain(domain);
        loginForm.clickBtnDropdown();
        loginForm.selectSuffix(suffix);
        loginForm.checkChbTerms();
        loginForm.clickBtnNext();
        interestsForm = new InterestsForm();
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
}

package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HelpForm;
import pages.HomePageForm;

import static aquality.selenium.browser.AqualityServices.getBrowser;

public class HideHelpTest extends BaseTest {

    private HomePageForm homePage;
    private HelpForm helpForm;

    @Test
    public void hideHelpTest() {
        getBrowser().goTo(url);
        homePage = new HomePageForm();
        Assert.assertTrue(homePage.state().waitForDisplayed(), "Welcome page is not open");

        homePage.clickNextLink();
        helpForm = new HelpForm();
        helpForm.clickHideHelpBtn();
        Assert.assertTrue(helpForm.state().waitForNotDisplayed(), "Help form is not hidden");
    }
}

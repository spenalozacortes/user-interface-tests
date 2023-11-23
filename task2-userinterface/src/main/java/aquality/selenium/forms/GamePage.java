package aquality.selenium.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.utils.FileUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class GamePage extends Form {

    private final ILabel pageIndicator = getElementFactory().getLabel(By.className("page-indicator"), "Page indicator");
    private final ITextBox txbPassword = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Choose Password']"), "Password text box");
    private final ITextBox txbEmail = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Your email']"), "Password");
    private final ITextBox txbDomain = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Domain']"), "Domain");
    private final IButton btnDropdown = getElementFactory().getButton(By.className("dropdown__opener"), "Dropdown");
    private final ICheckBox chbTerms = getElementFactory().getCheckBox(By.xpath("//*[contains(@class, 'icon-check')]"), "Terms and conditions");
    private final IButton btnNext1 = getElementFactory().getButton(By.xpath("//*[@class='button--secondary']"), "Next");
    private final ICheckBox chbUnselectAll = getElementFactory().getCheckBox(By.xpath("//*[@for='interest_unselectall']"), "Unselect all");
    private final ILink linkUploadPicture = getElementFactory().getLink(By.xpath("//a[contains(@class,'upload-button')]"), "Upload link");
    private final IButton btnNext2 = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next button");
    private final IButton btnHideHelp = getElementFactory().getButton(By.xpath("//button[contains(@class, 'send-to-bottom')]"), "Hide help form");
    private final ILabel labelHelpTitle = getElementFactory().getLabel(By.className("help-form__title"), "Help form title");

    public GamePage() {
        super(By.xpath("//*[@class='game view']"), "Game Page");
    }

    public boolean isPageIndicatorDisplayed(String number) {
        return AqualityServices.getConditionalWait().waitFor(() -> pageIndicator.getText().contains(number + " /"),
                Duration.ofSeconds(10));
    }

    public void setTxbPassword(String password) {
        txbPassword.clearAndType(password);
    }

    public void setTxbEmail(String email) {
        txbEmail.clearAndType(email);
    }

    public void setTxbDomain(String domain) {
        txbDomain.clearAndType(domain);
    }

    public void clickBtnDropdown() {
        btnDropdown.click();
    }

    public void selectDropdownByText(String text) {
        List<ILabel> dropdownOptions = getElementFactory().findElements(By.xpath("//*[@class='dropdown__list-item']"), ElementType.LABEL);
        for (ILabel option: dropdownOptions) {
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    public void checkChbTerms() {
        chbTerms.check();
    }

    public void clickBtnNext1() {
        btnNext1.click();
    }

    public void checkChbUnselectAll() {
        chbUnselectAll.check();
    }

    public void selectInterest(int index) {
        List<ICheckBox> interests = getElementFactory().findElements(By.xpath("//*[contains(@for,'interest')]"), ElementType.CHECKBOX);
        interests.get(index).check();
    }

    public void uploadPicture(String path) throws AWTException {
        linkUploadPicture.click();
        FileUtils.handleFileDialog(path);
    }

    public void clickBtnNext2() {
        btnNext2.click();
    }

    public void clickBtnHideHelp() {
        btnHideHelp.click();
    }

    public boolean isHelpHidden() {
        return labelHelpTitle.state().waitForNotDisplayed();
    }
}

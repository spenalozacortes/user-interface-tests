package aquality.selenium.forms;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.*;
import aquality.selenium.utils.FileUtils;
import aquality.selenium.utils.RandomUtils;
import org.openqa.selenium.By;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
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
    private final ILabel labelTimer = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'timer')]"), "Timer");

    public Cookies cookies = new Cookies();
    public Help help = new Help();

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

    public void selectInterests(int numberOfInterests) {
        List<ICheckBox> options = getElementFactory().findElements(By.xpath("//*[contains(@for, 'interest') and not(contains(@for, 'selectall'))]"), ElementType.CHECKBOX);
        List<Integer> randomIndices = new ArrayList<>();

        for (int i = 0; i < numberOfInterests; i++) {
            int index = RandomUtils.getRandomInt(options.size());
            if (!randomIndices.contains(index)) {
                randomIndices.add(index);
            }
        }

        for (int index : randomIndices) {
            options.get(index).check();
        }
    }

    public void uploadPicture(String path) throws AWTException {
        linkUploadPicture.click();
        FileUtils.handleFileDialog(path);
    }

    public void clickBtnNext2() {
        btnNext2.click();
    }

    public String getTimerText() {
        return labelTimer.getText();
    }
}

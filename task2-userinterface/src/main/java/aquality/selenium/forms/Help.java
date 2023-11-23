package aquality.selenium.forms;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import org.openqa.selenium.By;

public class Help extends Form {

    private final IButton btnHideHelp = getElementFactory().getButton(By.xpath("//button[contains(@class, 'send-to-bottom')]"), "Hide help form");
    private final ILabel labelHelpTitle = getElementFactory().getLabel(By.className("help-form__title"), "Help form title");
    public Help() {
        super(By.xpath("//a[contains(@class, 'help-button')]"), "Help form");
    }

    public void clickBtnHideHelp() {
        btnHideHelp.click();
    }

    public boolean isHelpHidden() {
        return labelHelpTitle.state().waitForNotDisplayed();
    }
}

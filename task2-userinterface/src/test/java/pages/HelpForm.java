package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final IButton hideHelpBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'send-to-bottom')]"), "Hide help form");
    private final ILabel helpTitleLbl = getElementFactory().getLabel(By.className("help-form__title"), "Help form title");

    public HelpForm() {
        super(By.xpath("//a[contains(@class, 'help-button')]"), "Help form");
    }

    public void clickBtnHideHelp() {
        hideHelpBtn.click();
    }

    public boolean isHelpHidden() {
        return helpTitleLbl.state().waitForNotDisplayed();
    }
}

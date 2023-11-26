package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HelpForm extends Form {

    private final IButton hideHelpBtn = getElementFactory().getButton(By.xpath("//button[contains(@class, 'send-to-bottom')]"), "Hide help form");

    public HelpForm() {
        super(By.className("help-form__title"), "Help form");
    }

    public void clickHideHelpBtn() {
        hideHelpBtn.click();
    }
}

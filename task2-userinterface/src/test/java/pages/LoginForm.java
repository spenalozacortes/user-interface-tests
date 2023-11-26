package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

import java.util.List;

public class LoginForm extends Form {

    private final ITextBox passwordTxb = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Choose Password']"), "Password text box");
    private final ITextBox emailTxb = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Your email']"), "Password");
    private final ITextBox domainTxb = getElementFactory().getTextBox(By.xpath("//*[@placeholder='Domain']"), "Domain");
    private final IButton dropdownBtn = getElementFactory().getButton(By.className("dropdown__opener"), "Dropdown");
    private final ICheckBox termsCb = getElementFactory().getCheckBox(By.xpath("//*[contains(@class, 'icon-check')]"), "Terms and conditions");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//*[@class='button--secondary']"), "Next");
    private final ILabel timerLbl = getElementFactory().getLabel(By.xpath("//*[contains(@class, 'timer')]"), "Timer");

    private final By dropdownBy = By.xpath("//*[@class='dropdown__list-item']");

    public LoginForm() {
        super(By.xpath("//*[@class='page-indicator' and text()='1 / 4']"), "Card 1");
    }

    public void setPassword(String password) {
        passwordTxb.clearAndType(password);
    }

    public void setEmail(String email) {
        emailTxb.clearAndType(email);
    }

    public void setDomain(String domain) {
        domainTxb.clearAndType(domain);
    }

    public void clickBtnDropdown() {
        dropdownBtn.click();
    }

    public void selectSuffix(String text) {
        List<ILabel> dropdownOptions = getElementFactory().findElements(dropdownBy, ElementType.LABEL);
        for (ILabel option: dropdownOptions) {
            if(option.getText().equals(text)) {
                option.click();
                break;
            }
        }
    }

    public void checkChbTerms() {
        termsCb.check();
    }

    public void clickBtnNext() {
        nextBtn.click();
    }

    public String getTimerText() {
        return timerLbl.getText();
    }
}

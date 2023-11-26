package pages;

import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class CookiesForm extends Form {

    private final IButton acceptCookiesBtn = getElementFactory().getButton(By.xpath("//button[text()='Not really, no']"), "Accept cookies");

    public CookiesForm() {
        super(By.className("cookies"), "Cookies");
    }

    public void clickBtnAcceptCookies() {
        acceptCookiesBtn.click();
    }
}

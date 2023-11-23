package aquality.selenium.forms;

import aquality.selenium.elements.interfaces.IButton;
import org.openqa.selenium.By;

public class Cookies extends Form {

    private final IButton btnAcceptCookies = getElementFactory().getButton(By.xpath("//button[text()='Not really, no']"), "Accept cookies");
    public Cookies() {
        super(By.className("cookies"), "Cookies");
    }

    public void clickBtnAcceptCookies() {
        btnAcceptCookies.click();
    }
}

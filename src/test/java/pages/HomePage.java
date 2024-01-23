package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ILink nextLink = getElementFactory().getLink(By.className("start__link"), "Next");

    public HomePage() {
        super(By.className("start__button"), "Home Page");
    }

    public void clickNextLink() {
        nextLink.click();
    }
}

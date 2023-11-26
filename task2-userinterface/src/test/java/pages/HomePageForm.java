package pages;

import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePageForm extends Form {

    private final ILink nextLink = getElementFactory().getLink(By.className("start__link"), "Next");

    public HomePageForm() {
        super(By.className("start__button"), "Home Page");
    }

    public void clickLinkNext() {
        nextLink.click();
    }
}

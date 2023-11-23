package aquality.selenium.forms;

import aquality.selenium.elements.interfaces.ILink;
import org.openqa.selenium.By;

public class HomePage extends Form {

    private final ILink linkNext = getElementFactory().getLink(By.className("start__link"), "Next");
    public HomePage() {
        super(By.className("start__button"), "Home Page");
    }

    public void clickLinkNext() {
        linkNext.click();
    }
}

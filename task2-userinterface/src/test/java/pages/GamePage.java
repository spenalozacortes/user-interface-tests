package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class GamePage extends Form {

    public CookiesForm cookies = new CookiesForm();
    public HelpForm help = new HelpForm();

    public GamePage() {
        super(By.xpath("//*[@class='game view']"), "Game Page");
    }
}

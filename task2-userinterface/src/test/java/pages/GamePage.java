package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import pages.forms.*;

public class GamePage extends Form {

    private final CookiesForm cookiesForm = new CookiesForm();
    private final HelpForm helpForm = new HelpForm();
    private final LoginForm loginForm = new LoginForm();
    private final InterestsForm interestsForm = new InterestsForm();
    private final PersonalDetailsForm personalDetailsForm = new PersonalDetailsForm();

    public GamePage() {
        super(By.xpath("//*[@class='game view']"), "Game Page");
    }

    public CookiesForm cookiesForm() {
        return this.cookiesForm;
    }

    public HelpForm helpForm() {
        return this.helpForm;
    }

    public LoginForm loginForm() {
        return this.loginForm;
    }

    public InterestsForm interestsForm() {
        return this.interestsForm;
    }

    public PersonalDetailsForm personalDetailsForm() {
        return this.personalDetailsForm;
    }
}

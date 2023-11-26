package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    public PersonalDetailsForm() {
        super(By.xpath("//*[@class='page-indicator' and text()='3 / 4']"), "Card 3");
    }
}

package pages;

import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class PersonalDetailsForm extends Form {

    public PersonalDetailsForm() {
        super(By.className("personal-details"), "Personal details form");
    }
}

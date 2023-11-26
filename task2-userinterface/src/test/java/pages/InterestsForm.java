package pages;

import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILink;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.FileUtils;
import utils.RandomUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class InterestsForm extends Form {

    private final ICheckBox unselectAllCb = getElementFactory().getCheckBox(By.xpath("//*[@for='interest_unselectall']"), "Unselect all");
    private final ILink uploadPictureLink = getElementFactory().getLink(By.xpath("//a[contains(@class,'upload-button')]"), "Upload link");
    private final IButton nextBtn = getElementFactory().getButton(By.xpath("//button[text()='Next']"), "Next button");

    private final By optionsBy = By.xpath("//*[contains(@for, 'interest') and not(contains(@for, 'selectall'))]");

    public InterestsForm() {
        super(By.xpath("//*[@class='page-indicator' and text()='2 / 4']"), "Card 2");
    }

    public void checkChbUnselectAll() {
        unselectAllCb.check();
    }

    public void selectInterests(int numberOfInterests) {
        List<ICheckBox> options = getElementFactory().findElements(optionsBy, ElementType.CHECKBOX);
        List<Integer> randomIndices = new ArrayList<>();

        for (int i = 0; i < numberOfInterests; i++) {
            int index = RandomUtils.getRandomInt(options.size());
            if (!randomIndices.contains(index)) {
                randomIndices.add(index);
            }
        }

        for (int index : randomIndices) {
            options.get(index).check();
        }
    }

    public void uploadPicture(String path) throws AWTException {
        uploadPictureLink.click();
        FileUtils.handleFileDialog(path);
    }

    public void clickBtnNext() {
        nextBtn.click();
    }
}

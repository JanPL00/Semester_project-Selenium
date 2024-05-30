package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralMethods {

    public void clickCheckbox(WebElement webElement, Boolean check) {
        if ((check && !webElement.isSelected()) || (!check && webElement.isSelected())) {
            webElement.click();
        }
    }
    public  void fillFormField(String text, By xpath) {

    }
}

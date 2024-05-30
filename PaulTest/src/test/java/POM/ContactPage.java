package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/form/div[2]/span/input")
    private WebElement fullName;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/form/div[3]/span/input")
    private WebElement mail;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div/div/form/div[4]/span/textarea")
    private WebElement message;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void fillFullName(String name, String surname) {
        fullName.sendKeys(name.trim() + " " + surname.trim());
    }
    public void fillEmail(String email) {
        mail.sendKeys(email);
    }
    public void fillMessage(String msg) {
        message.sendKeys(msg);
    }


}

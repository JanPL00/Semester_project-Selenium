package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccesfullySentPage {

    private final WebDriver driver;

    public SuccesfullySentPage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.paul-cz.com/uspesne-odeslano/");
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/header[2]/h1")
    private WebElement thankYouMsg;

    public String getThankYouMsg() {
        return thankYouMsg.getText();
    }

}

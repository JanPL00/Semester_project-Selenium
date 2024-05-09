import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactPage {

    private final WebDriver driver;

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/kontakt/");
    }

    public void fillFullName(String name, String surname) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/form/div[2]/span/input"));
        webElement.sendKeys(name.trim() + " " + surname.trim());
    }
    public void fillEmail(String email) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/form/div[3]/span/input"));
        webElement.sendKeys(email);
    }
    public void fillMessage(String msg) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div/form/div[4]/span/textarea"));
        webElement.sendKeys(msg);
    }


}

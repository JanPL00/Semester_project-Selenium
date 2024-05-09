import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/objednavka/");
    }
    public void fillName(String name) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[1]/span/input"));
        webElement.sendKeys(name);
    }
    public void fillSurname(String surname) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[2]/span/input"));
        webElement.sendKeys(surname);
    }
    public void  fillCompanyName(String companyName) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[3]/span/input"));
        webElement.sendKeys(companyName);
    }
}

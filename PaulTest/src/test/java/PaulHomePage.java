import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PaulHomePage {

    private final WebDriver driver;

    public PaulHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/");
    }

    public void testProductSearch(String product) {
        WebElement searchBox = driver.findElement(By.xpath("/html/body/header[1]/div/div/div[1]/form/input[1]"));
        searchBox.sendKeys(product);
        searchBox.sendKeys(Keys.RETURN);
    }
}

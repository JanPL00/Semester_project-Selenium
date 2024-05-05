import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PaulHomePage {

    private final WebDriver driver;

    public PaulHomePage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/");
    }
}

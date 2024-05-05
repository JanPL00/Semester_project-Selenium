import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    WebDriver driver;
    PaulHomePage paulHomePage;


    @BeforeEach
    public void setup() {
        this.driver = new ChromeDriver();
    }
    @AfterEach
    public void finish () {
        driver.quit();
    }

   // flightOrderPage = new FlightOrderPage(driver); pred


}

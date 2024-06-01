package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.InitClass;

import java.time.Duration;

public class PaulHomePage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "/html/body/header/div/div/div[1]/form/input[1]")
    private WebElement searchBox;

    @FindBy(xpath = "/html/body/header/div/div/div[1]/form/button")
    private WebElement searchBtn;

    public PaulHomePage(WebDriver driver) {
        this.driver = driver;
        driver.get("https://www.paul-cz.com/");
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
        InitClass.wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        searchBox.sendKeys(product);
        InitClass.wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
        searchBtn.click();
    }

//    public void testProductSearch(String product) {
//        WebElement searchBox = driver.findElement(By.xpath("/html/body/header[1]/div/div/div[1]/form/input[1]"));
//        searchBox.sendKeys(product);
//        searchBox.sendKeys(Keys.RETURN);
//    }
}

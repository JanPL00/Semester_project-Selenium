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

    @FindBy(xpath = "/html/body/div[2]/div/div/div[1]/div[1]/div[2]/a")
    private WebElement shopBtn;
    @FindBy(xpath = "/html/body/header/div/div/a[2]")
    private WebElement cartBtn;

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

    public void clickShopBtn() {shopBtn.click();}
    public void clickCartBtn() {cartBtn.click();}

}

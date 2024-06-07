package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[3]/a")
    private WebElement productName;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[1]/td[5]/div/input")
    private WebElement productQuantity;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td/a[2]")
    private WebElement emptyCartBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div")
    private WebElement emptyCartMsg;
    @FindBy(xpath = "/html/body/div[2]/div/form/table/tbody/tr[3]/td/input[1]")
    private WebElement refreshCartBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div/a")
    private WebElement checkOutBtn;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {return productName.getText();}
    public String getProductQuantity() {return productQuantity.getAttribute("value");}
    public String getEmptyCartMsg() {return emptyCartMsg.getText();}
    public void emptyCart() {emptyCartBtn.click();}
    public void changeQuantity(String quantity) {
        productQuantity.clear();
        productQuantity.sendKeys(quantity);
        refreshCartBtn.click();
    }
    public OrderPage checkOut() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutBtn));
        checkOutBtn.click();
        return new OrderPage(driver);
    }
}

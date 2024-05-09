import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountPage {

    private final WebDriver driver;
    private final GeneralMethods gm;
    public AccountPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/ucet/");
        this.gm = new GeneralMethods();
    }
    public void fillLoginUsernameOrEmail(String userInfo) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/p[1]/input"));
        webElement.sendKeys(userInfo);
    }
    public void fillLoginPassword(String pwd) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/p[2]/span/input"));
        webElement.sendKeys(pwd);
    }
    public void checkLoginRemeberMe(Boolean check) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/form/p[3]/label/input"));
        gm.clickCheckbox(webElement, check);
    }

    public void fillSignUpEmail(String email) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/form/p[1]/input"));
        webElement.sendKeys(email);
    }
    public void fillSignUpPassword(String pwd) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/form/p[2]/span/input"));
        webElement.sendKeys(pwd);
    }
    public void checkSignUpAgreement1(Boolean check) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/form/p[3]/label/input"));
        gm.clickCheckbox(webElement, check);
    }
    public void checkSignUpAgreement2(Boolean check) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[2]/form/p[4]/label/input"));
        gm.clickCheckbox(webElement, check);
    }
}

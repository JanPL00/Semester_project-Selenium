import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    private final WebDriver driver;
    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/objednavka/");
    }

    public void pickFreeMacaron(String flavour) {
        WebElement webElement;
        switch (flavour) {
            case "Vanilla":
                webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[1]/input"));
                webElement.click();
            case "Chockolate":
                webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[3]/input"));
                webElement.click();
            case "Rasberry":
                webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[2]/input"));
                webElement.click();
        }
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
    public void fillICO(String ico) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[4]/span/input"));
        webElement.sendKeys(ico);
    }
    public void fillDIC(String dic) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[5]/span/input"));
        webElement.sendKeys(dic);
    }
    public void fillAdressStreetNameAndNumber(String street) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[7]/span/input"));
        webElement.sendKeys(street);
    }
    public void fillAdressAdditional(String info) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[8]/span/input"));
        webElement.sendKeys(info);
    }
    public void fillAdressCity(String city) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[9]/span/input"));
        webElement.sendKeys(city);
    }
    public void fillAdressPSC(String psc) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[11]/span/input"));
        webElement.sendKeys(psc);
    }
    public void fillPhoneNumber(String num) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[12]/span/input"));
        webElement.sendKeys(num);
    }
    public void fillEmail(String email) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[13]/span/input"));
        webElement.sendKeys(email);
    }
    public void fillPassword(String pwd) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[1]/div[3]/div/p/span/input"));
        webElement.sendKeys(pwd);
    }
    public void clickDeliveryBtn() {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[2]/div[1]/input[1]"));
        webElement.click();
    }
    public void clickPickUpBtn() {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[2]/div[1]/input[2]"));
        webElement.click();
    }

    // TODO date and time of delivery

    public void fillMerciCardNumber(String num) {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[2]/div[2]/div[2]/p/span/input"));
        webElement.sendKeys(num);
    }
    public String getAllProductsCost() {
        WebElement webElement = driver.findElement(By.xpath("/html/body/div[2]/div/form[2]/div[3]/table/tbody/tr/td[2]/span/bdi"));
        return webElement.getText();
    }
}

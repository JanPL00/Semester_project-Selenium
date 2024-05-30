package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPage {

    private final WebDriver driver;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[1]/input")
    private WebElement freeVanillaMacron;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[3]/input")
    private WebElement freeChockolateMacron;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[1]/p[2]/span/div[2]/input")
    private WebElement freeRasberryMacron;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[1]/span/input")
    private WebElement nameForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[2]/span/input")
    private WebElement surnameForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[3]/span/input")
    private WebElement companyNameForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[4]/span/input")
    private WebElement icoForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[5]/span/input")
    private WebElement dicForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[7]/span/input")
    private WebElement adressStreetNameAndNumberForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[8]/span/input")
    private WebElement adressAdditionalForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[9]/span/input")
    private WebElement adressCityForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[11]/span/input")
    private WebElement adressPSCForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[12]/span/input")
    private WebElement phoneNumberForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[1]/p[13]/span/input")
    private WebElement emailForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[1]/div[3]/div/p/span/input")
    private WebElement passwordForm;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[2]/div[1]/input[1]")
    private WebElement deliveryBtn;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[2]/div[1]/input[2]")
    private WebElement pickUpBtn;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[2]/div[2]/div[2]/p/span/input")
    private WebElement merciCardNumber;

    @FindBy(xpath = "/html/body/div[2]/div/form[2]/div[3]/table/tbody/tr/td[2]/span/bdi")
    private WebElement getAllProductsCost;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        this.driver.get("https://www.paul-cz.com/objednavka/");
        PageFactory.initElements(driver, this);

    }

    public void pickFreeMacaron(String flavour) {
        switch (flavour) {
            case "Vanilla":
                freeVanillaMacron.click();
            case "Chockolate":
                freeChockolateMacron.click();
            case "Rasberry":
                freeRasberryMacron.click();
        }
    }

    public void fillName(String name) {
        nameForm.sendKeys(name);
    }

    public void fillSurname(String surname) {
        surnameForm.sendKeys(surname);
    }

    public void  fillCompanyName(String companyName) {
        companyNameForm.sendKeys(companyName);
    }

    public void fillICO(String ico) {
        icoForm.sendKeys(ico);
    }

    public void fillDIC(String dic) {
        dicForm.sendKeys(dic);
    }

    public void fillAdressStreetNameAndNumber(String street) {
        adressStreetNameAndNumberForm.sendKeys(street);
    }

    public void fillAdressAdditional(String info) {
        adressAdditionalForm.sendKeys(info);
    }

    public void fillAdressCity(String city) {
        adressCityForm.sendKeys(city);
    }

    public void fillAdressPSC(String psc) {
        adressPSCForm.sendKeys(psc);
    }

    public void fillPhoneNumber(String num) {
        phoneNumberForm.sendKeys(num);
    }

    public void fillEmail(String email) {
        emailForm.sendKeys(email);
    }

    public void fillPassword(String pwd) {
        passwordForm.sendKeys(pwd);
    }

    public void clickDeliveryBtn() {
        deliveryBtn.click();
    }

    public void clickPickUpBtn() {
        pickUpBtn.click();
    }

    // TODO date and time of delivery

    public void fillMerciCardNumber(String num) {
        merciCardNumber.sendKeys(num);
    }
    public String getAllProductsCost() {
        return getAllProductsCost.getText();
    }
}

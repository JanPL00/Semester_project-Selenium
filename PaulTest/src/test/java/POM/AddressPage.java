package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressPage {

    private final WebDriver driver;
    private final GeneralMethods gm;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/header/a")
    private WebElement AddAndEditMailingAddressBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/header/a")
    private WebElement AddAndEditBillingAddressBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[1]/span/input")
    private WebElement AddressSurnameForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[2]/span/input")
    private WebElement AddressLastnameForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[5]/span/input")
    private WebElement AddressStreetNameForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[7]/span/input")
    private WebElement AddressCityNameForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[9]/span/input")
    private WebElement AddressPscForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[10]/span/input")
    private WebElement AddressTelephoneForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div/p[11]/span/input")
    private WebElement AddressEmailForm;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/p[3]/button")
    private WebElement AddressSaveBtn;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/address/text()[1]")
    private WebElement AddressNameAndSurname;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/address/text()[2]")
    private WebElement AddressStreet;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[2]/address/text()[3]")
    private WebElement AddressPscAndCity;


    public AddressPage(WebDriver driver) {

        this.driver = driver;
        driver.get("https://www.paul-cz.com/ucet/upravit-adresu/");
        this.gm = new GeneralMethods();
        PageFactory.initElements(driver, this);

    }

    public void addBillingAddress(String surname, String lastname,String street, String city, String psc, int telephone, String email) {
        AddAndEditBillingAddressBtn.click();
        AddressSurnameForm.sendKeys(surname);
        AddressLastnameForm.sendKeys(lastname);
        AddressStreetNameForm.sendKeys(street);
        AddressCityNameForm.sendKeys(city);
        AddressPscForm.sendKeys(psc);
        AddressTelephoneForm.sendKeys(String.valueOf(telephone));
        AddressEmailForm.sendKeys(email);
        AddressSaveBtn.click();
    }

    public void editBillingAddress(String surname, String lastname,String street, String city, String psc, int telephone, String email) {
        AddAndEditBillingAddressBtn.click();

        AddressSurnameForm.clear();
        AddressSurnameForm.sendKeys(surname);

        AddressLastnameForm.clear();
        AddressLastnameForm.sendKeys(lastname);

        AddressStreetNameForm.clear();
        AddressStreetNameForm.sendKeys(street);

        AddressCityNameForm.clear();
        AddressCityNameForm.sendKeys(city);

        AddressPscForm.clear();
        AddressPscForm.sendKeys(psc);

        AddressTelephoneForm.clear();
        AddressTelephoneForm.sendKeys(String.valueOf(telephone));

        AddressEmailForm.clear();
        AddressEmailForm.sendKeys(email);

        AddressSaveBtn.click();
    }

    public void addMailingAddress(String surname, String lastname,String street, String city, String psc) {
        AddAndEditMailingAddressBtn.click();
        AddressSurnameForm.sendKeys(surname);
        AddressLastnameForm.sendKeys(lastname);
        AddressStreetNameForm.sendKeys(street);
        AddressCityNameForm.sendKeys(city);
        AddressPscForm.sendKeys(psc);
        AddressSaveBtn.click();
    }

    public void editMailingAddress(String surname, String lastname,String street, String city, String psc) {
        AddAndEditMailingAddressBtn.click();

        AddressSurnameForm.clear();
        AddressSurnameForm.sendKeys(surname);

        AddressLastnameForm.clear();
        AddressLastnameForm.sendKeys(lastname);

        AddressStreetNameForm.clear();
        AddressStreetNameForm.sendKeys(street);

        AddressCityNameForm.clear();
        AddressCityNameForm.sendKeys(city);

        AddressPscForm.clear();
        AddressPscForm.sendKeys(psc);

        AddressSaveBtn.click();
    }


    public void checkEditedInfo() {
        checkEditedNameAndSurname();
        checkEditedStreet();
        checkEditedPscAndCity();

    }

    private void checkEditedPscAndCity(String actualCity, String actualPsc) {

        String pscAndCity = AddressPscAndCity.getText();
        String[] pscAndCityArray = pscAndCity.split(" ");
        String psc = pscAndCityArray[0];
        String city = pscAndCityArray[1];
        assert psc.equals(actualPsc);
        assert city.equals(actualCity);
    }

    private void checkEditedStreet(String street) {
        String streetName = AddressStreet.getText();
        assert streetName.equals(street);
    }

    private void checkEditedNameAndSurname(String actualSurname, String actualLastname) {

        String nameAndSurname = AddressNameAndSurname.getText();
        String[] nameAndSurnameArray = nameAndSurname.split(" ");
        String name = nameAndSurnameArray[0];
        String surname = nameAndSurnameArray[1];
        assert name.equals(actualSurname);
        assert surname.equals(actualLastname);
    }




}

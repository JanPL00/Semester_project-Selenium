package tests;

import POM.AccountPage;
import POM.AddressPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.InitClass;

import static setup.InitClass.driver;

public class EditMailingAdressTest {

    AddressPage addressPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
        addressPage = new AddressPage(driver);
    }

    @AfterEach
    public void finish() {
        InitClass.tearDown();
    }

    @Test
    public void testEditMailingAddress() {

        AccountPage accountPage = new AccountPage(driver);

        accountPage.fillLoginUsernameOrEmail("nejakydalsiemail@gmail.com");
        accountPage.fillLoginPassword("nejakeheslo");
        accountPage.logIn();

        accountPage.clickAdresses();

        addressPage.editMailingAddress("Surname3", "Lastname3", "Street3", "City3", "123 45");
        addressPage.checkIfEditedMailingAddressTextContains("Surname3", "Lastname3", "Street3", "City3", "123 45");

    }
}

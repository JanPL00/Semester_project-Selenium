package tests;

import POM.AccountPage;
import POM.AddressPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import setup.InitClass;

import static setup.InitClass.driver;

public class AddBillingAdressTest {

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

    @ParameterizedTest
    @CsvSource({
            "Name1, Surname1, Street1, City1, 123 45, 123456789",
            "Name2, Surname2, Street2, City2, 543 21, 987654321"
    })
    public void testAddBillingAddress(String name, String surname, String street, String city, String psc, int phone) {

        // Generate random email and password using Faker
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        AccountPage accountPage = new AccountPage(driver);

        // For adding a new address, the user needs to have a new account with a blank Mailing address
        accountPage.fillSignUpEmail(email);
        accountPage.fillSignUpPassword(password);
        accountPage.signUp();

        accountPage.clickAdresses();

        addressPage.addBillingAddress(name, surname, street, city, psc, phone);
        addressPage.checkIfEditedBillingAddressTextContains(name, surname, street, city, psc);
    }



}

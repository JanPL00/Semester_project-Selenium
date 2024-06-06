package tests;

import POM.AccountPage;
import POM.AddressPage;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.InitClass;

import static setup.InitClass.driver;

public class AddMailingAdressTest {

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
    public void testAddMailingAddress() {

        AccountPage accountPage = new AccountPage(driver);

        // Generate random email and password using Faker
        Faker faker = new Faker();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        //For adding new address user needs to have new account with blank Mailing address
        accountPage.fillSignUpEmail(email);
        accountPage.fillSignUpPassword(password);
        accountPage.signUp();

        accountPage.clickAdresses();

        addressPage.addBillingAddress("Name", "Surname", "Street", "City", "123456789", 123456789, "randommailHEHE@gmail.com");
    }

    @Test
    public void testAddMailingAddress2() {

        AccountPage accountPage = new AccountPage(driver);

        String email = "nejakydalsiemail@gmail.com";
        accountPage.fillLoginUsernameOrEmail(email);
        accountPage.fillLoginPassword("nejakeheslo");
        accountPage.logIn();

        accountPage.clickAdresses();

        addressPage.addBillingAddress("Surname2", "Lastname2","Street2", "City2", "33333", 113456789, "Country2");
    }


}

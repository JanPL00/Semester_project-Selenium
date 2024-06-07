package tests;

import POM.AccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import setup.InitClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static setup.InitClass.driver;

public class AccountTest {

    AccountPage accountPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
        accountPage = new AccountPage(driver);
    }

    @AfterEach
    public void finish() {InitClass.tearDown();}

    @ParameterizedTest
    @CsvFileSource(resources = "/registration_dataset.csv", numLinesToSkip = 1)
    public void testRegistration(String email, String password) {

        accountPage.fillSignUpEmail(email);
        accountPage.fillSignUpPassword(password);
        accountPage.signUp();

        testUser(email);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/login_dataset.csv", numLinesToSkip = 1)
    public void testLogin(String email, String password) {

        accountPage.fillLoginUsernameOrEmail(email);
        accountPage.fillLoginPassword(password);
        accountPage.logIn();

        testUser(email);
    }

    @Test
    public void testXSSAttack() {
        logInUser();
        accountPage.clickDetails();
        accountPage.fillName("(1)\t<script type=\"text/javascript\"> window.alert(\"This is an alert message!\");</script>");
        accountPage.fillSurname("Surname");
        accountPage.saveDetails();

        assertEquals("403 Forbidden", driver.getTitle(), "Inserting a script into the form field should lead to 403 error.");
    }

    //Shortcut method
    private String logInUser() {
        String email = "nejakydalsiemail@gmail.com";
        accountPage.fillLoginUsernameOrEmail(email);
        accountPage.fillLoginPassword("nejakeheslo");
        accountPage.logIn();
        return email;
    }

    private void testUser(String email) {
        try {
            String welcomeMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[1]/strong[1]")).getText();
            assertEquals( welcomeMsg, email);
        } catch (NoSuchElementException e) {
            fail("Registration failed.");
        }
    }
}

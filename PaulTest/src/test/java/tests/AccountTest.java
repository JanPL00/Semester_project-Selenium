package tests;

import POM.AccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

    @Test
    public void testRegistration() {
        String email = "randomemail@gmail.com";
        accountPage.fillSignUpEmail(email);
        accountPage.fillSignUpPassword("randompwd");
        accountPage.signUp();

        testUser(email);
    }

    @Test
    public void testLogin() {
        testUser(logInUser());
    }

    @Test
    public void testPwdChnage() { // tohle nefunguje kvuli erroru na strankach, nevim jak overit ze se to podarilo
        logInUser();
        accountPage.clickDetails();
        accountPage.fillName("Name");
        accountPage.fillSurname("Surname");
        accountPage.changePwd("nejakeheslo", "nejakenoveheslo");
        accountPage.saveDetails();
    }
    @Test
    public void testXSSAttack() { // TODO jeste neni hotova
        logInUser();
        accountPage.clickDetails();
    }

    private String logInUser() {
        String email = "nejakydalsiemail@gmail.com";
        accountPage.fillLoginUsernameOrEmail(email);
        accountPage.fillLoginPassword("nejakeheslo");
        accountPage.logIn();
        return email;
    }
    private void testUser(String email) {
        try {
            String wecomeMsg = driver.findElement(By.xpath("/html/body/div[2]/div/div/p[1]/strong[1]")).getText();
            assertEquals( wecomeMsg, email, "Registration failed.");
        } catch (NoSuchElementException e) {
            fail("Registration failed.");
        }
    }
}

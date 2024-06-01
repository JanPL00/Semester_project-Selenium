package tests;

import POM.AccountPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import setup.InitClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static setup.InitClass.driver;

public class ResgistrationTest {

    AccountPage accountPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
        accountPage = new AccountPage(driver);
    }

    @AfterEach
    public void finish() {
        InitClass.tearDown();
    }

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
    public void testPwdChnage() {
        logInUser();
        accountPage.clickDetails();
        accountPage.changePwd("nejakeheslo", "nejakenoveheslo");
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
            assertEquals( wecomeMsg, email, "Registration was successful");
        } catch (NoSuchElementException e) {
            fail("Registration failed.");
        }
    }

}

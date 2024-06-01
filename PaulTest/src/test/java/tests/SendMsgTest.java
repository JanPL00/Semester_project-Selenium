package tests;

import POM.ContactPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.InitClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static setup.InitClass.driver;
import static setup.InitClass.wait;

public class SendMsgTest {

    ContactPage contactPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
        contactPage = new ContactPage(driver);
    }

    @AfterEach
    public void finish() {InitClass.tearDown();}

    @Test
    public void testSendMsg() { // zablokovali me aaa!
        contactPage.fillFullName("TestName", "TestSurname");
        contactPage.fillEmail("mellevi.karin@gmail.com");
        contactPage.fillMessage("This is a test message.");
        contactPage.submitMsg();

        try {
            assertEquals("Děkujeme, zpráva byla úspěšně odeslána — PAUL", driver.getTitle(), "Message submit failed.");
        } catch (NoSuchElementException e) {
            fail("Message submit failed.");
        }
    }

}

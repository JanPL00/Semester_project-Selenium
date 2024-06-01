package tests;

import POM.ContactPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import setup.InitClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static setup.InitClass.driver;

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
    public void testSendMsg() {
        contactPage.fillFullName("TestName", "TestSurname");
        contactPage.fillEmail("mellevi.karin@gmail.com");
        contactPage.fillMessage("This is a test message.");
        contactPage.submitMsg();

        try {
            String thankYouMsg = driver.findElement(By.xpath("/html/body/header[2]/h1")).getText();
            assertEquals("Děkujeme, zpráva byla úspěšně odeslána", thankYouMsg, "Message submit was successful.");
        } catch (NoSuchElementException e) {
            fail("Message submit failed.");
        }
    }

}

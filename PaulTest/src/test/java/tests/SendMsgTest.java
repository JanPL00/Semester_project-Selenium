package tests;

import POM.ContactPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import setup.InitClass;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SendMsgTest {

    private ContactPage contactPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
        contactPage = new ContactPage(InitClass.getDriver());
    }

    @AfterEach
    public void finish() {
        InitClass.tearDown();}

    @Test
    public void testSendMsg() { // zablokovali me aaa!


        InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getFullName()));
        contactPage.fillFullName("TestName", "TestSurname");
        InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getMail()));
        contactPage.fillEmail("mellevi.karin@gmail.com");
        InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getMessage()));
        contactPage.fillMessage("This is a test message.");
        InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getSubmitBtn()));
        contactPage.submitMsg();

        contactPage.navigateToConfirmationPage();


        try {
            assertEquals("Děkujeme, zpráva byla úspěšně odeslána", contactPage.getThankYouMsg());
        } catch (NoSuchElementException e) {
            fail("Message submit failed.");
        }
    }
}

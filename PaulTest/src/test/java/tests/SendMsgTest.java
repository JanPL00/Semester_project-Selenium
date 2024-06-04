package tests;

import POM.ContactPage;
import POM.SuccesfullySentPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.InitClass;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static setup.InitClass.driver;

public class SendMsgTest {

    //private WebDriver driver;
    private WebDriverWait wait;
    private ContactPage contactPage;
    private SuccesfullySentPage successfullySentPage;

    @BeforeEach
    public void setup() {
        InitClass.initialization();
//        this.driver = InitClass.getDriver();
//        this.wait = new WebDriverWait(driver, Duration.of(20, ChronoUnit.SECONDS));
        contactPage = new ContactPage(driver);
        //successfullySentPage = new SuccesfullySentPage(driver);
    }

    @AfterEach
    public void finish() {
        InitClass.tearDown();
    }

    @Test
    public void testSendMsg() {
        //driver.get("https://www.paul-cz.com/kontakt/");

        try {

            InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getFullName()));
            contactPage.fillFullName("TestName", "TestSurname");

            InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getMail()));
            contactPage.fillEmail("mellevi.karin@gmail.com");

            InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getMessage()));
            contactPage.fillMessage("This is a test message.");

            InitClass.getWait().until(ExpectedConditions.visibilityOf(contactPage.getSubmitBtn()));
            contactPage.submitMsg();

            //driver.get("https://www.paul-cz.com/uspesne-odeslano/");

            InitClass.getWait().until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(), 'Děkujeme ')]")));

            String expectedMessage = "Děkujeme, zpráva byla úspěšně odeslána";
            String actualMessage = successfullySentPage.getThankYouMsg();

            assertEquals(expectedMessage, actualMessage, "The thank you message did not match.");

        } catch (Exception e) {
            fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }
}

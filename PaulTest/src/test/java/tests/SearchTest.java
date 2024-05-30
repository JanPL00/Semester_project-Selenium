package tests;

import POM.PaulHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import setup.InitClass;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static setup.InitClass.driver;

public class SearchTest {

    @BeforeEach
    public void setup() {
        InitClass.initialization();
    }

    @AfterEach
    public void finish() {
        InitClass.tearDown();
    }


    @Test
    public void testSearch() throws InterruptedException {

        PaulHomePage paulHomePage = new PaulHomePage(driver);
        paulHomePage.searchProduct("bageta");

        //Validate the search results
        WebElement searchResults = driver.findElement(By.xpath("/html/body/div[3]/div/main/ul"));
        List<WebElement> resultItems = searchResults.findElements(By.tagName("li"));

        // Assert that there are results
        assertFalse(resultItems.isEmpty(), "The search results should not be empty.");

    }
}

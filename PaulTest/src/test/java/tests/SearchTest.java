package tests;

import POM.PaulHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import setup.InitClass;

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

        PaulHomePage paulHomePage = new PaulHomePage(InitClass.driver);
        paulHomePage.searchProduct("bageta");

    }
}

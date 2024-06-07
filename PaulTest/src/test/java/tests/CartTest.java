package tests;

import POM.AccountPage;
import POM.CartPage;
import POM.PaulHomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import setup.InitClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static setup.InitClass.driver;

public class CartTest {

    private PaulHomePage paulHomePage;
    private CartPage cartPage;
    private WebDriverWait wait;


    @BeforeEach
    public void setup() {

        InitClass.initialization();
        paulHomePage = new PaulHomePage(driver);
    }

    @AfterEach
    public void finish() {InitClass.tearDown();}


    @Test
    public void testAddAndRemoveProduct() {
        addBagetatoCart();

        assertEquals("Sezamová bageta s uzeným lososem", cartPage.getProductName(), "Product is not in cart.");
        assertEquals("1", cartPage.getProductQuantity(), "Product quantity is not correct.");

        cartPage.emptyCart();

        assertEquals("Váš košík je prázdný.", cartPage.getEmptyCartMsg(), "Cart should be empty");
    }

    @Test
    public void testOrderLimit() {
        addBagetatoCart();
        cartPage.changeQuantity("100");
        cartPage.checkOut();

        assertEquals("Nákupní košík — PAUL", driver.getTitle());
    }



    private void addBagetatoCart() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        paulHomePage.clickShopBtn();

        WebElement category = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/main/ul/li[5]/a")));
        category.click();
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]/div/main/ul/li[10]/a[2]")));
        product.click();
        WebElement cartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/header/div/div/a[2]")));
        cartButton.click();

        driver.navigate().refresh();
        cartPage = new CartPage(driver);
    }
}



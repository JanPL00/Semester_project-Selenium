package tests;

import POM.AccountPage;
import POM.CartPage;
import POM.OrderPage;
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
    private OrderPage orderPage;


    @BeforeEach
    public void setup() {

        InitClass.initialization();
        paulHomePage = new PaulHomePage(driver);
    }

//    @AfterEach
//    public void finish() {InitClass.tearDown();}
//

    @Test
    public void testAddAndRemoveProduct() {
        addBagetatoCart();

        assertEquals("Bageta s tuňákem", cartPage.getProductName(), "Product is not in cart.");
        assertEquals("1", cartPage.getProductQuantity(), "Product quantity is not correct.");

        cartPage.emptyCart();

        assertEquals("Váš košík je prázdný.", cartPage.getEmptyCartMsg(), "Cart should be empty");
    }

    @Test
    public void testOrderLimit() {
        addBagetatoCart();
        cartPage.changeQuantity("150");
        cartPage.checkOut();

        assertEquals("Nákupní košík — PAUL", driver.getTitle());
    }

     @Test
     public void testOrderCheckOut() throws InterruptedException {
         addBagetatoCart();
         cartPage.changeQuantity("10");
         orderPage = cartPage.checkOut();

         Thread.sleep(2000);

         assertEquals("Objednávka — PAUL", driver.getTitle(), "You should be on the checkout page.");
         assertEquals("1 490,00 Kč", orderPage.getAllProductsCost(), "The product cost is not correct.");

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



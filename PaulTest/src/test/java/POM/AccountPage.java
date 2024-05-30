package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    private final WebDriver driver;
    private final GeneralMethods gm;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/form/p[1]/input")
    private WebElement loginUsernameOrEmail;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/form/p[2]/span/input")
    private WebElement loginPassword;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/form/p[1]/input")
    private WebElement signUpEmail;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/form/p[3]/label/input")
    private WebElement checkLoginRemeberMe;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/form/p[2]/span/input")
    private WebElement signUpPassword;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/form/p[3]/label/input")
    private WebElement checkSignUpAgreement1;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/form/p[4]/label/input")
    private WebElement checkSignUpAgreement2;


    public AccountPage(WebDriver driver) {

        this.driver = driver;
        this.gm = new GeneralMethods();
        PageFactory.initElements(driver, this);


    }

    public void fillLoginUsernameOrEmail(String userInfo) {
        loginUsernameOrEmail.sendKeys(userInfo);
    }

    public void fillLoginPassword(String pwd) {
        loginPassword.sendKeys(pwd);
    }

    public void checkLoginRemeberMe(Boolean check) {
        gm.clickCheckbox(checkLoginRemeberMe, check);
    }

    public void fillSignUpEmail(String email) {
        signUpEmail.sendKeys(email);
    }

    public void fillSignUpPassword(String pwd) {
        signUpPassword.sendKeys(pwd);
    }

    public void checkSignUpAgreement1(Boolean check) {
        gm.clickCheckbox(checkSignUpAgreement1, check);
    }

    public void checkSignUpAgreement2(Boolean check) {
        gm.clickCheckbox(checkSignUpAgreement2, check);
    }

}

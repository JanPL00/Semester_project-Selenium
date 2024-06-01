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
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[1]/form/p[3]/button")
    private WebElement logInBtn;
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
    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/form/p[5]/button")
    private WebElement signUpBtn;
    @FindBy(xpath = "/html/body/div[2]/div/nav/ul/li[4]/a")
    private WebElement detailsBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/p[5]/button")
    private WebElement saveDetailsBtn;
    @FindBy(xpath = "/html/body/div[2]/div/nav/ul/li[5]/a")
    private WebElement logOutBtn;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/p[1]/input")
    private WebElement name;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/p[2]/input")
    private WebElement surname;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/p[1]/span/input")
    private WebElement currentPwd;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/p[2]/span/input")
    private WebElement newPwd;
    @FindBy(xpath = "/html/body/div[2]/div/div/form/fieldset/p[3]/span/input")
    private  WebElement newPwdCheck;

    public AccountPage(WebDriver driver) {

        this.driver = driver;
        driver.get("https://www.paul-cz.com/ucet/");
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

    public void logIn() { logInBtn.click(); }

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
    public void signUp() { signUpBtn.click(); }

    public void clickDetails() { detailsBtn.click(); }

    public void logOut() { logInBtn.click(); }

    public void fillName(String name) { this.name.sendKeys(name);}

    public void fillSurname(String surname) { this.surname.sendKeys(surname);}
    public void changePwd(String currentPwd, String newPwd) {
        this.currentPwd.sendKeys(currentPwd);
        this.newPwd.sendKeys(newPwd);
        newPwdCheck.sendKeys(newPwd);
    }

    public void saveDetails() {saveDetailsBtn.click();}


}

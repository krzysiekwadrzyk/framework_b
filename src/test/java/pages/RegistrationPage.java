package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage {

    @FindBy(xpath = "//a[text()='Sign up']")
    private WebElement signUpLink;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;

    @FindBy(xpath = "//li[@class='nav-item'][4]//a")
    private WebElement loggedUser;

    private WebDriver driver;
    private WebDriverWait wait;

    public RegistrationPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void registerAs(String username, String email, String password){

        signUpLink.click();

        usernameField.sendKeys(username);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        signInButton.click();

    }

    public String getLoggedUserName(){

        wait.until(ExpectedConditions.visibilityOf(loggedUser));

        return loggedUser.getText();

    }
}

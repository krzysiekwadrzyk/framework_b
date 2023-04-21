package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//a[text()='Sign in']")
    private WebElement signInLink;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Sign in']")
    private WebElement signInButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void logIn(String email, String password){

        signInLink.click();

        emailField.sendKeys(email);
        passwordField.sendKeys(password);

        signInButton.click();

    }

}

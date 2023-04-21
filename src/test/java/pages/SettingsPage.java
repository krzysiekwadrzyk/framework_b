package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage {

    @FindBy(xpath = "//a[@href='#settings']")
    private WebElement settingsLink;

    @FindBy(xpath = "//button[text()='Or click here to logout.']")
    private WebElement logoutButton;

    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement usernameField;

    @FindBy(xpath = "//textarea[@placeholder='Short bio about you']")
    private WebElement bioTextarea;

    @FindBy(xpath = "//input[@placeholder='Email']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@placeholder='New Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Update Settings']")
    private WebElement updateSettingsButton;

    private WebDriver driver;
    private WebDriverWait wait;

    public SettingsPage(WebDriver driver){

        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void openSettings(){

        wait.until(ExpectedConditions.visibilityOf(settingsLink));
        settingsLink.click();

    }

    public void logoutUser(){

        logoutButton.click();

    }

    public void editEmail(String email){

        emailField.clear();
        emailField.sendKeys(email);

    }

    public void editPassword(String password){

        passwordField.clear();
        passwordField.sendKeys(password);

    }

    public void fillBio(String bio){

        bioTextarea.sendKeys(bio);

    }

    public void clickUpdateSettingsButton(){

        updateSettingsButton.click();

    }

    public void editExistingUser(String bio, String email, String password){

        openSettings();

        wait.until(ExpectedConditions.visibilityOf(bioTextarea));
        fillBio(bio);
        editEmail(email);
        editPassword(password);

        clickUpdateSettingsButton();
    }


}

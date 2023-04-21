package tests;

import base.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParametrizeTests extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv" )
    void logInTest(String username, String password, String message){

        driver.get("https://the-internet.herokuapp.com/login");

        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.id("flash"));
        assertEquals(message, errorMessage.getText().substring(0, errorMessage.getText().indexOf("!")+1));

    }

}

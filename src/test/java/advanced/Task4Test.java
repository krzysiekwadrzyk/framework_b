package advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task4Test {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown(){

        driver.quit();

    }

    @Test
    void basicAjaxTest(){

        driver.get("https://testpages.herokuapp.com/styled/dynamic-buttons-disabled.html");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='button00']")));
        WebElement startButton = driver.findElement(By.xpath("//button[@id='button00']"));
        WebElement oneButton = driver.findElement(By.id("button01"));
        WebElement twoButton = driver.findElement(By.id("button02"));
        WebElement threeButton = driver.findElement(By.id("button03"));

        startButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(oneButton));
        oneButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(twoButton));
        twoButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(threeButton));
        threeButton.click();

        WebElement messageWindow = driver.findElement(By.id("buttonmessage"));
        Assertions.assertEquals("All Buttons Clicked", messageWindow.getText());
    }
}

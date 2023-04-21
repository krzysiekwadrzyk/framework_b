package advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task3Test {

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

        driver.get("https://testpages.herokuapp.com/styled/expandingdiv.html");

        WebElement expand = driver.findElement(By.className("expand"));
        Actions action = new Actions(driver);
        action.moveToElement(expand);
        action.perform();

        WebElement link = driver.findElement(By.xpath("//a[text()='This link']"));
        wait.until(ExpectedConditions.elementToBeClickable(link));
        link.click();
        WebElement link2 = driver.findElement(By.xpath("//a[text()='this link']"));
        wait.until(ExpectedConditions.elementToBeClickable(link2));
        link2.click();

    }
}

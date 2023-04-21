package advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task5Test {

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
    void basicAjaxTest() {

        driver.get("https://testpages.herokuapp.com/styled/file-upload-test.html");

        WebElement fileInput = driver.findElement(By.id("fileinput"));
        WebElement imageRadioButton = driver.findElement(By.id("itsanimage"));
        WebElement uploadButton = driver.findElement(By.name("upload"));
        String pathToFile = "C:\\Users\\krzysztof.wadrzyk\\Szkolenia\\Budowanie frameworków testowych - Selenium\\joker.jpg";

        fileInput.sendKeys(pathToFile);
        imageRadioButton.click();
        uploadButton.click();

        WebElement uploadedFilename = driver.findElement(By.id("uploadedfilename"));
        Assertions.assertEquals("joker.jpg", uploadedFilename.getText());

    }
}

package advanced;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;
import java.util.HashMap;

public class Task6Test {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeEach
    void setUp(){

        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs .put("profile.default_content_settings.popups" , 0);
        chromePrefs .put("download.default_directory" , "C:\\Users\\krzysztof.wadrzyk\\Szkolenia\\Downloads\\");

        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption( "prefs", chromePrefs );

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterEach
    void tearDown() {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();

    }

    @Test
    void simpleAjaxTest(){

        driver.get("https://testpages.herokuapp.com/styled/download/download.html");

        WebElement downloadButton = driver.findElement(By.xpath("//button[@id='direct-download']"));
        downloadButton.click();

    }
}

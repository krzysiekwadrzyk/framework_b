package base;

import config.DriveFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    void setupDriver(){

        driver = DriveFactory.CHROME.getDriverManager().getDriver();
//        driver = DriveFactory.FIREFOX.getDriverManager().getDriver();

    }

    @AfterEach
    void tearDown(){

        driver.quit();

    }

}

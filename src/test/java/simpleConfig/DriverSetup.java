package simpleConfig;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class DriverSetup {

    private static BrowserConfig config = new BrowserConfig();

    public static WebDriver getDriver(){

        switch (config.getBrowserName()){

            case "chrome":

                WebDriver driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().window().maximize();

                return driver;

        }

        return new ChromeDriver();

    }
}

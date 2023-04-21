package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager{
    @Override
    protected WebDriver createDriver() {

        return new FirefoxDriver();

    }

    private FirefoxOptions getFirefoxOptions(){

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");

        return options;
    }

}

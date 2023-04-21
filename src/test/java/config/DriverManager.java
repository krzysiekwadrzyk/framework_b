package config;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected abstract WebDriver createDriver();

    public WebDriver getDriver(){

        if(null == driver.get()){

            driver.set(this.createDriver());

        }

        return driver.get();

    }

    public void quitDriver(){

        if(null != driver.get()){

            driver.get().quit();
            driver.remove();

        }
    }
}

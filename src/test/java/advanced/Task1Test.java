package advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task1Test {

    static WebDriver driver;
    static WebDriverWait wait;

    @BeforeEach
    void setUp(){

        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    void basicAjaxTest(){

        WebElement idField = driver.findElement(By.id("_valueid"));
        WebElement languageIdField = driver.findElement(By.id("_valuelanguage_id"));
        WebElement goBackButton = driver.findElement(By.id("back_to_form"));

        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        selectLanguage("Web", "Javascript");
        Assertions.assertEquals(idField.getText(), "1");
        Assertions.assertEquals(languageIdField.getText(), "0");
        goBackButton.click();

    }

    public static void selectLanguage(String category, String language){

        WebElement categoryField = driver.findElement(By.id("combo1"));
        WebElement languageField = driver.findElement(By.id("combo2"));
        WebElement loading = driver.findElement(By.id("ajaxBusy"));
        WebElement codeInItButton = driver.findElement(By.name("submitbutton"));

        Select categorySelector = new Select(categoryField);
        Select languageSelector = new Select(languageField);

        categorySelector.selectByVisibleText(category);
        wait.until(ExpectedConditions.invisibilityOf(loading));
        languageSelector.selectByVisibleText(language);
        codeInItButton.click();

    }

}

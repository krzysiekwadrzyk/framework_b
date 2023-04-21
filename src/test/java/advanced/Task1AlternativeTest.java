package advanced;

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
import java.util.List;
import java.util.Objects;

public class Task1AlternativeTest {

    WebDriver driver;

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }

    @Test
    void basicAjaxTest(){
        driver.get("https://testpages.herokuapp.com/styled/basic-ajax-test.html");

        String Category = "Web";
        String Language = "Javascript";
        String TestValueId = "1";
        String TestValueLanguage = "1";

        /*
        String Category = "Driver";
        String Language = "C";
        String TestValueId = "2";
        String TestValueLanguage = "12";
        */

        /*
        String Category = "Server";
        String Language = "Java";
        String TestValueId = "3";
        String TestValueLanguage = "23";
        */

        WebElement selectElementCategory = driver.findElement(By.id("combo1"));
        Select selectCategory = new Select(selectElementCategory);
        List<WebElement> optionListCategory = selectCategory.getOptions();
        List<WebElement> selectedOptionListCategory = selectCategory.getAllSelectedOptions();

        selectCategory.selectByVisibleText(Category);

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(driver -> driver.findElement(By.xpath("//span[@style='display: none;']")));

        WebElement selectElementLanguage = driver.findElement(By.id("combo2"));
        Select select = new Select(selectElementLanguage);
        List<WebElement> optionListLanguage = select.getOptions();
        List<WebElement> selectedOptionListLanguage = select.getAllSelectedOptions();

        select.selectByVisibleText(Language);

        WebElement buttonCode = driver.findElement(By.xpath("//input[@class='styled-click-button']"));
        buttonCode.click();

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Submitted Values']")));

        WebElement selectIdValue = driver.findElement(By.xpath("//li[@id='_valueid']"));
        String valueText = selectIdValue.getText();
        if (Objects.equals(valueText, TestValueId)){
            System.out.println("Wartość poprawna " + valueText);
        }else {
            System.out.println("Wartość błędna " + valueText);
        }

        WebElement selectlanguage_idValue = driver.findElement(By.xpath("//li[@id='_valuelanguage_id']"));
        String valueLanguageText = selectlanguage_idValue.getText();
        if (Objects.equals(valueLanguageText, TestValueLanguage)){
            System.out.println("Wartość poprawna " + valueLanguageText);
        }else {
            System.out.println("Wartość błędna " + valueLanguageText);
        }

    }

}

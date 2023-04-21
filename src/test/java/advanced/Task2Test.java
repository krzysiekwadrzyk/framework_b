package advanced;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Task2Test extends BaseTest {
    static WebDriverWait wait;

    @BeforeEach
    void setUp(){

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @Test
    void basicAjaxTest(){

        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        WebElement tableData = driver.findElement(By.tagName("summary"));
        tableData.click();
        WebElement textarea = driver.findElement(By.id("jsondata"));
        textarea.clear();
        textarea.sendKeys("[{\"imię\": \"Bob\", \"wiek\" : 20}, {\"imię\": \"George\", \"wiek\" : 42}, {\"imię\": \"Jan\", \"wiek\" : 7} ]");
        WebElement refreshButton = driver.findElement(By.id("refreshtable"));
        refreshButton.click();

        WebElement dynamicTable = driver.findElement(By.id("dynamictable"));
        Assertions.assertTrue(dynamicTable.getText().contains("Jan"));
    }

}

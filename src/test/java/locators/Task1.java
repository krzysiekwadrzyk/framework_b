package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task1 {
    static WebDriver driver;

    public static void main(String[] args) {

        String url = "https://the-internet.herokuapp.com/challenging_dom";

        driver = new ChromeDriver();
        driver.get(url);

        WebElement scriptForCanvas = driver.findElement(By.xpath("//script[contains(text(), 'Answer')]"));
        String scriptText = scriptForCanvas.getAttribute("innerHTML");

        String patternString = "Answer: (\\d+)";

        Pattern pattern = Pattern.compile(patternString);
        Matcher matcher = pattern.matcher(scriptText);

        if (matcher.find()) {
            System.out.println(matcher.group(0));
        }

        List<String> expectedHeaders = List.of("Lorem", "Ipsum", "Dolor", "Sit", "Amet", "Diceret", "Action");
        boolean areHeadersEqual = validateHeaders(expectedHeaders);
        System.out.println(areHeadersEqual);

        System.out.println(getTextFromTable(1,"Ipsum"));

        WebElement blueButton = driver.findElement(By.xpath("//a[@class='button']"));
        WebElement redButton = driver.findElement(By.xpath("//a[@class='button alert']"));
        WebElement greenButton = driver.findElement(By.xpath("//a[@class='button success']"));

        driver.quit();

    }

    public static boolean validateHeaders(List<String> expectedHeaders) {
        List<WebElement> actualHeaders = driver.findElements(By.xpath("//th"));
        List<String> headersText = actualHeaders
                .stream()
                .map(WebElement::getText)
                .toList();

        System.out.println(headersText);

        for (int i=0; i<expectedHeaders.size(); i++) {
            if (!headersText.get(i).equals(expectedHeaders.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static String getTextFromTable(int row, String columnName) {
        List<WebElement> tableHeaders = driver.findElements(By.xpath("//th"));
        List<String> headersText = tableHeaders
                .stream()
                .map(WebElement::getText)
                .toList();

        int columnIndex = headersText.indexOf(columnName);

        String locatorForSpecificCell = "//tbody/tr[" + row + "]/td[" + columnIndex + "]";
        WebElement cell = driver.findElement(By.xpath(locatorForSpecificCell));
        return cell.getText();
    }

}

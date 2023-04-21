package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v109.emulation.Emulation;
import org.openqa.selenium.devtools.v109.performance.Performance;
import org.openqa.selenium.devtools.v109.performance.model.Metric;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class Task2Test extends BaseTest {

    private List<Metric> metricList;
    private final List<JavascriptException> jsExceptionsList = new ArrayList<>();

    @Test
    void httpAuthTest(){

        var url = "https://authenticationtest.com/HTTPAuth/";
        var username = "user";
        var password = "pass";

        Predicate<URI> uriPredicate = uri -> uri.getHost().contains("authenticationtest.com");
        ((HasAuthentication) driver).register(uriPredicate, UsernameAndPassword.of(username, password));

        driver.get(url);

        WebElement header = driver.findElement(By.tagName("h1"));
        assertEquals("Login Success", header.getText());

    }

    @Test
    void performanceMetrics(){

        driver.get("https://react-redux.realworld.io");

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.empty()));
        metricList = devTools.send(Performance.getMetrics());

        WebElement homeLink = driver.findElement(By.xpath("//a[text()='Home']"));

        homeLink.click();

        metricList.forEach(System.out::println);
    }

    @Test
    void exceptionTest(){

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.getDomains().events().addJavascriptExceptionListener(jsExceptionsList::add);

        driver.get("http://the-internet.herokuapp.com/javascript_error");

        jsExceptionsList.forEach(System.out::println);
        System.out.println(jsExceptionsList);

    }

    @Test
    void geolocationTest(){

        double latitudeLondon = 51.50853;
        double longitudeLondon = -0.12574;

        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(Optional.of(latitudeLondon),
                Optional.of(longitudeLondon),
                Optional.of(1)));
        driver.get("https://my-location.org/");

        WebElement latitude = driver.findElement(By.id("latitude"));
        WebElement longitude = driver.findElement(By.id("longitude"));

        assertEquals(Double.toString(latitudeLondon), latitude.getText());
        assertEquals(Double.toString(longitudeLondon), longitude.getText());

    }

}

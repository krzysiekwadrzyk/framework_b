package tests;

import base.BaseTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.RegistrationPage;
import pages.SettingsPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.sql.Timestamp;

public class Task1Test extends BaseTest {

    @BeforeEach
    void setUp(){

        driver.get("https://react-redux.realworld.io");

    }

    @Test
    void newUserRegistrationTest(){

        RegistrationPage registrationPage = new RegistrationPage(driver);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomValue = timestamp.getTime();

        String testUsername = "Krzysiek"+randomValue;
        String testEmail = "krzysiekwad"+randomValue+"@gmail.com";
        String testPassword = "qwerty1234";

        registrationPage.registerAs(testUsername, testEmail, testPassword);

        assertEquals(testUsername, registrationPage.getLoggedUserName());

    }

    @Test
    void logInTest(){

        RegistrationPage registrationPage = new RegistrationPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomValue = timestamp.getTime();

        String testUsername = "Krzysiek"+randomValue;
        String testEmail = "krzysiek"+randomValue+"@gmail.com";
        String testPassword = "qwerty1234";

        registrationPage.registerAs(testUsername, testEmail, testPassword);

        settingsPage.openSettings();
        settingsPage.logoutUser();

        loginPage.logIn(testEmail, testPassword);

        assertEquals(testUsername, registrationPage.getLoggedUserName());
    }

    @Test
    void changeSettings(){

        RegistrationPage registrationPage = new RegistrationPage(driver);
        SettingsPage settingsPage = new SettingsPage(driver);

        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        long randomValue = timestamp.getTime();

        String testUsername = "Krzysiek"+randomValue;
        String testEmail = "krzysiek"+randomValue+"@gmail.com";
        String testPassword = "qwerty1234";
        String bio = "Hello World";
        String newEmail = "krzysiek"+randomValue+"@onet.com";
        String newPassword = "rety12345";

        registrationPage.registerAs(testUsername, testEmail, testPassword);

        settingsPage.editExistingUser(bio, newEmail, newPassword);
        settingsPage.logoutUser();

    }

}

package simpleConfig;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BrowserConfig {

    Properties properties = new Properties();

    private String browserName;
    private String width;
    private String height;

    public BrowserConfig(){

        String confFile = Thread.currentThread().getContextClassLoader().getResource("app.properties").getPath();

        try {

            properties.load(new FileInputStream(confFile));

        } catch (IOException e) {

            e.printStackTrace();

        }

        this.browserName = properties.getProperty("browser");
        this.width = properties.getProperty("width");
        this.height = properties.getProperty("height");

    }

    public String getBrowserName() {
        return browserName.toLowerCase();
    }

}

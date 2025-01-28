package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;

public class BrowserFactory {
    //ToDo:configure browsers

    static WebDriver factoryDriver;
    private static HashMap <String, String> configurationMap = PropertiesFile.read( "src/test/resources/environnement/config.properties");

    static String webBrowserType = configurationMap.get("browser");
    static boolean headless = Boolean.parseBoolean( configurationMap.get("isheadless"));
    public static WebDriver getFactoryDriver() {
        switch (webBrowserType){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("start-maximized", "--ignore-certificate-errors", "--incognito");

                if (headless) {
                    options.addArguments("--headless=new");
                }

                factoryDriver = new ChromeDriver(options);


                break;
            case "ie":
                break;
            case "firefox":
                break;
            default:
                break;
        }

        return factoryDriver;
    }
   //chrome
    //ie
    //firefox

}

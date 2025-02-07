package modules;

import PageObjects.GoogleSearchPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import utils.PropertiesFile;

import java.time.Duration;
import java.util.HashMap;

import static utils.BrowserFactory.getFactoryDriver;


public class Hooks {
    //ToDo: configure actions to be run before and after scenario
    public static WebDriver driver;
    private GoogleSearchPage googleSearchPageObject = new GoogleSearchPage();
    private static HashMap<String, String> configurationMap = PropertiesFile.read( "src/test/resources/environnement/config.properties");

    static String baseUrl = configurationMap.get("baseUrl");
    @Before("@api")
    public void init() {
        RestAssured.baseURI = "https://swapi.dev/api/";
    }
   @Before
    public void SetUp() {

       driver = getFactoryDriver();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

       PageFactory.initElements(driver, googleSearchPageObject);
   }
    public static void addDelay() {
        try {
            Thread.sleep(2000); // Attendre 2 secondes
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Réinitialiser l'état interrompu
        }
    }

   @After
    public void TearDown() {
       driver.quit();
   }
}

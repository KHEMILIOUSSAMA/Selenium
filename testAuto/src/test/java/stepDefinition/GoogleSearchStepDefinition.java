package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;

import static PageObjects.GoogleSearchPage.searchFor;
import static modules.Hooks.driver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class GoogleSearchStepDefinition {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {

    driver.get("https://www.google.com");

    }

    @When("I lookup the word {string}")
    public void iLookupTheWord(String arg0) {
        /**
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.name("q")).clear();
        new Actions(driver).sendKeys(driver.findElement(By.name("q")),arg0)
                        .sendKeys(Keys.ENTER).build().perform();
        //driver.findElement(By.name("q")).sendKeys(arg0);
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]"));
        driver.switchTo().frame(iframe);
        WebElement checkBox = driver.findElement(By.xpath("//*[@role=\"checkbox\"]"));
        checkBox.click();
        **/
        searchFor(arg0);

    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertTrue(driver.getTitle().contains(arg0));

    }

    @When("I accept cookies")
    public void i_accept_cookies() {
        driver.manage().deleteAllCookies();
        WebElement btnAccept =  driver.findElement(By.xpath("//*[contains(text(),'Tout accepter')]/ancestor::button[1]"));
       Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", btnAccept);
       //actions.scrollToElement(btnAccept).moveToElement(btnAccept).click().build().perform();
        btnAccept.click();
    }
}

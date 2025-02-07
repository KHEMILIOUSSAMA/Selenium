package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static PageObjects.GoogleSearchPage.searchFor;
import static modules.Hooks.addDelay;
import static modules.Hooks.driver;

import java.time.Duration;

import static org.junit.Assert.assertTrue;


public class GoogleSearchStepDefinition {

    @Given("I open google search page")
    public void iOpenGoogleSearchPage() {
        addDelay();
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
        addDelay();

        searchFor(arg0);

    }

    @Then("search results display the word {string}")
    public void searchResultsDisplayTheWord(String arg0) {
        assertTrue(driver.getTitle().contains(arg0));
        WebElement iframe = driver.findElement(By.xpath("//iframe[@title=\"reCAPTCHA\"]"));
        driver.switchTo().frame(iframe);
        WebElement checkBox = driver.findElement(By.xpath("//*[@role=\"checkbox\"]"));
        checkBox.click();




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

    @And("I click on the first result")
    public void iClickOnTheFirstResult() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Attente maximale de 15 secondes

        try {
            // Attendre que le premier résultat soit visible et cliquable
            WebElement firstResultLink = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("(//h3)[1]"))
            );

            // Vérifier si l'élément est bien affiché et cliquable
            if (firstResultLink.isDisplayed() && firstResultLink.isEnabled()) {
                firstResultLink.click();
                System.out.println("✅ Clic effectué sur le premier résultat de recherche.");
            } else {
                System.err.println("⚠️ L'élément n'est pas visible ou cliquable.");
            }
        } catch (TimeoutException e) {
            System.err.println("❌ Timeout : Impossible de trouver le premier résultat dans le délai imparti.");
        } catch (NoSuchElementException e) {
            System.err.println("❌ Erreur : Aucun élément trouvé pour le premier résultat.");
        } catch (Exception e) {
            System.err.println("❌ Erreur inattendue lors du clic sur le premier résultat : " + e.getMessage());
        }
    }
}

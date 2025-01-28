package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static endPoints.people.getPeople;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class StarWarsStepDefinition {

    String requestBuilder;
    Response response;
    @Given("I am using resources {string}")
    public void iAmUsingResources(String arg0) {
        RestAssured.baseURI = "https://swapi.dev/api/";
        requestBuilder = arg0;
    }

    @And("searching for id {int}")
    public void searchingForId(int arg0) {
        requestBuilder = requestBuilder + "/" + arg0;
    }

    @When("I send {string} request")
    public void iSendRequest(String arg0) {
        response=getPeople(requestBuilder);

    }

    @Then("I get response {string}")
    public void iGetResponse(String arg0) {
        assertEquals(Integer.parseInt(arg0), response.getStatusCode());

        String name = response.path("name");
        if (name != null) {
            System.out.println("Name: " + name);
            response.getBody().prettyPrint();
        } else {
            System.out.println("Name not found in response.");
        }
    }
}

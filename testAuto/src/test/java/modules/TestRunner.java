package modules;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(

        plugin = {"pretty","json:target/json/results.json"},
        features = {"classpath:features"},
        glue = {"modules","stepDefinition"},
        tags = "@api "

)
public class TestRunner {
    //ToDo:create test run configuration
}

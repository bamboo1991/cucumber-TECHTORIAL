package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/MyAppAutoMation.feature",
        glue = "StepDefinitions",
        tags = "@db",
        dryRun = false
)
public class MyAppRunner {



}

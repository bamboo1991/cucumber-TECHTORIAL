package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


    @RunWith(Cucumber.class)
    @CucumberOptions(
                features = "src\\test\\resources\\com.cucumber.features.iceHRM\\ListOfMaps.feature",
            glue ="StepDefinitions",
            dryRun = false,
            monochrome = true,
            tags = {"@language2"}
    )
    public class IceHrmRunner {
}

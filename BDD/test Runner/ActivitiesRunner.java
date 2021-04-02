package cucumberTest;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "Features",
    glue = {"stepDefinitions"},
    tags = "@activity1_3",
    plugin = {"html: reports/test-reports-html"},
    monochrome = true
)

public class ActivitiesRunner {
	//empty
}

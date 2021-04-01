package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@activity2_4_HRM",
    plugin = {"html: reports/Activity2_4HRM_test-report-html"},
    monochrome = true
)

public class ProjectRunner {
	//empty
}
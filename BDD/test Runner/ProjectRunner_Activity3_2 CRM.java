package testRunner;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/java/Features",
    glue = {"stepDefinitions"},
    tags = "@activity3_2_CRM",
    plugin = {"html: reports/Activity3_2CRM_test-report-html"},
    monochrome = true
)

public class ProjectRunner {
	//empty
}
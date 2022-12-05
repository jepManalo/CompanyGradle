package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.*;
	
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/feature",
		glue = {"stepDefinition"},
		tags = "@AnalysisVerification",
		plugin = {"pretty", "html:target/cucumber-report.html"}
	)

public class TestRunner {
	
}
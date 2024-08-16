package cucumber.Options;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)	
@CucumberOptions(features ="src/test/java/com/features/PlaceValidations.feature",plugin ="json:target/jsonReports/cucumber-report.json",
               glue= "com.stepdefinition",
               dryRun = false
               )	


public class TestRunnerWithHooks {

}

package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
        ,plugin = {"json:target/cucumber/cucumber.json"} // JSON report for Jenkins
)
public class _04_SmokeTest extends AbstractTestNGCucumberTests {
}

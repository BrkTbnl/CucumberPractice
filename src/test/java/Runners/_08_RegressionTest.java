package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(

        tags = "@RegressionTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"}
        ,plugin = {"json:target/cucumber/cucumber.json"} // JSON report for Jenkins
)
public class _08_RegressionTest extends AbstractTestNGCucumberTests {
}
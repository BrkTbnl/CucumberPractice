package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(

        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue = {"StepDefinitions"},
        dryRun = false, // true status check if Features connected to Steps..
        plugin = {"html:target/site/cucumber-pretty.html"}
)
public class _05_TestRunnerSmokeWithPlugin extends AbstractTestNGCucumberTests {
}

package Runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/java/featureFiles/_01_Login.feature",
                "src/test/java/featureFiles/_02_AddEmployee.feature"
        },
        glue = {"StepDefinitions"}
)
public class _02_TestRunnerSpesificFeatures extends AbstractTestNGCucumberTests {

}
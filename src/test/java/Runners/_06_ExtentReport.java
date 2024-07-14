package Runners;

import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;


@CucumberOptions(
        tags = "@SmokeTest",
        features = {"src/test/java/FeatureFiles"},
        glue={"StepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}


)
public class _06_ExtentReport extends AbstractTestNGCucumberTests {

    @AfterClass
    //To add info in report
    public static void writeExtentReport() {
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name")); //Username: BT
        ExtentService.getInstance().setSystemInfo("Time Zone",System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("OS",System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("OS Version",System.getProperty("os.version"));
        ExtentService.getInstance().setSystemInfo("Application Name","Testing");
    }
}

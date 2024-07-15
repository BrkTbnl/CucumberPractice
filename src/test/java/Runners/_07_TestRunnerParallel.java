package Runners;

import Utilities.GWD;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;




@CucumberOptions(

        tags = ("@SmokeTest"),
        features = ("src/test/java/FeatureFiles"),
        glue = ("StepDefinitions"),
        plugin = ("com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")

)
public class _07_TestRunnerParallel extends AbstractTestNGCucumberTests {
    @BeforeClass
    @Parameters("browserType")
    public static void browserClass(String browserName){
        GWD.threadBrowserName.set(browserName);

    }
    @AfterClass
    public  static void writeExtentReport(){
        ExtentService.getInstance().setSystemInfo("Windows User Name",System.getProperty("user.name"));
        ExtentService.getInstance().setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        ExtentService.getInstance().setSystemInfo("Username", "Burak");
        ExtentService.getInstance().setSystemInfo("Application Name", "Test");
        ExtentService.getInstance().setSystemInfo("Operating System Info", System.getProperty("os.name"));
        ExtentService.getInstance().setSystemInfo("Department", "QA");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
        ExtentService.getInstance().setSystemInfo("Ek Satır", "Açıklama");
    }

}

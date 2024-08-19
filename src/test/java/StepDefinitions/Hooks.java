package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Utilities.ExcelUtility;
import Utilities.GWD;

public class Hooks {
    @Before
    public void before(){

    }

    @After
    public void after(Scenario scenario){

        //ExcelUtility.writeToExcel("src/test/java/apachePOI/resource/ScenarioResults.xlsx", scenario, GWD.threadBrowserName.get());

        // Keep the extent report's plugin open while it is active
//        if (scenario.isFailed()) {
//            TakesScreenshot screenshot = ((TakesScreenshot) GWD.getDriver());
//            byte[] stateInMemory = screenshot.getScreenshotAs(OutputType.BYTES);
//            scenario.attach(stateInMemory, "image/png", "screenshot name");
//        }
        GWD.quitDriver();
    }
}

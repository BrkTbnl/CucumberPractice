package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _01_LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate To page")
    public void navigateToPage() {
        GWD.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        dc.SendKeys(dc.username,"Admin");
        dc.SendKeys(dc.password,"admin123");
        dc.Click(dc.loginButton);

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
    }
}

package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class _02_AddEmployee {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @And("Navigate To PIM")
    public void navigateToPIM() {
        ln.myClick(ln.PIM);
    }

    @When("Create a new employee")
    public void createANewEmployee() {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,"Burak");
        dc.mySendKeys(dc.lastNameInput,"Tarik4");
        dc.myClick(dc.saveButton);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.employeeName,"Burak Tarik");
    }
}

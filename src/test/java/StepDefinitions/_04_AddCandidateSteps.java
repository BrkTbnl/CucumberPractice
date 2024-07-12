package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _04_AddCandidateSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate To Recruitment")
    public void navigateToRecruitment() {
        ln.myClick(ln.Recruitment);
    }

    @When("Create a new candidate")
    public void createANewCandidate() {
        dc.myClick(dc.addButtonCandidate);
        dc.mySendKeys(dc.nameInput,"Kurt");
        dc.mySendKeys(dc.lastNameInput,"Cobain");
        dc.mySendKeys(dc.emailInput,"test1test@gmail.com");
        dc.myClick(dc.saveButton);
    }

    @When("Create a new candidate name as {string} lastName as {string} and mail as {string}")
    public void createANewCandidateNameAsLastNameAsAndMailAs(String arg1, String arg2, String arg3) {
        dc.myClick(dc.addButtonCandidate);
        dc.mySendKeys(dc.nameInput,arg1);
        dc.mySendKeys(dc.lastNameInput,arg2);
        dc.mySendKeys(dc.emailInput,arg3);
        dc.myClick(dc.saveButton);

    }

    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        dc.verifyContainsText(dc.errorCheck,"exist");

    }


}

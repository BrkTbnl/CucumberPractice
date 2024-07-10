package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class _04_RecruitmentSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();

    @And("Navigate To Recruitment")
    public void navigateToRecruitment() {
        ln.myClick(ln.Recruitment);
    }

    @When("Create a new candidate")
    public void createANewCandidate() {
        dc.myClick(dc.AddButtonNew);
        dc.mySendKeys(dc.nameInput,"Kurt");
        dc.mySendKeys(dc.lastNameInput,"Cobain");
        dc.mySendKeys(dc.emailInput,"test1test@gmail.com");
        dc.myClick(dc.saveButton);
    }
}

package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.ExcelUtility;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _10_ApachePOISteps {

    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();

    @When("User create candidate with ApachePOI")
    public void userCreateCandidateWithApachePOI() {
        ArrayList<ArrayList<String>> table = ExcelUtility.getData("src/test/java/ApachePOI/resources/ApacheExcel.xlsx", "testCase", 3);

        for (int i = 0; i < table.size(); i++) {

            ArrayList<String > row = table.get(i);

            ln.myClick(ln.Recruitment);
            dc.myJsClick(dc.addButtonCandidate);
            dc.mySendKeys(dc.nameInput, row.get(0));
            dc.mySendKeys(dc.lastNameInput, row.get(1));
            dc.mySendKeys(dc.emailInput, row.get(2));
            dc.myClick(dc.saveButton);
            dc.verifyContainsText(dc.SuccessCheck,"Success");

        }

    }

    @And("User create new employee with ApachePOI")
    public void userCreateNewEmployeeWithApachePOI() {
        ArrayList<ArrayList<String>> table = ExcelUtility.getData("src/test/java/ApachePOI/resources/ApacheExcel.xlsx", "testCase", 2);

        for (int i = 0; i < table.size(); i++) {

            ArrayList<String > row = table.get(i);

            ln.myClick(ln.PIM);
            dc.myJsClick(dc.addButton);
            dc.mySendKeys(dc.nameInput, row.get(0));
            dc.mySendKeys(dc.lastNameInput, row.get(1));
            dc.myJsClick(dc.saveButton);
            dc.verifyContainsText(dc.SuccessCheck,"Success");

        }

    }
}

package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;

import java.util.List;

public class _09_DataTableSteps {
    DialogContent dc = new DialogContent();
    LeftNav ln = new LeftNav();
    @And("Click on the element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable links) {
        List<String> linksList = links.asList(String.class);

        for (int i = 0; i < linksList.size(); i++) {
            String link = linksList.get(i);
            WebElement webElement = ln.getWebElement(link);
            ln.myClick(webElement);

        }
    }

    @And("Click on the element in Dialog")
    public void clickOnTheElementInDialog(DataTable links) {
        List<String> linksList = links.asList(String.class);

        for (int i = 0; i < linksList.size(); i++) {
            String link = linksList.get(i);
            WebElement webElement = dc.getWebElement(link);
            dc.myClick(webElement);

        }

    }

    @And("user sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable dataTable) {

        List<List<String>> items = dataTable.asLists(String.class);

        for (int i = 0; i < items.size(); i++) {
            List<String> item = items.get(i);
            WebElement webElement = dc.getWebElement(item.get(0));
            String text = item.get(1);
            dc.mySendKeys(webElement,text);

        }

    }
}

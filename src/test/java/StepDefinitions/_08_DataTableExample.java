package StepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import java.util.List;

public class _08_DataTableExample {
    @When("write username {string}")
    public void writeUsername(String userName) {
        System.out.println(userName
        );
    }

    @And("Write username and Password {string} and {string}")
    public void writeUsernameAndPasswordAnd(String userName, String password) {
    }

    @And("Write username as DataTable")
    public void writeUsernameAsDataTable(DataTable users) {
        List<String> listUsers = users.asList(String.class);
        for(String user:listUsers){
            System.out.println(user);
        }

    }

    @And("Write username and Password as DataTable")
    public void writeUsernameAndPasswordAsDataTable(DataTable usersAndPasswords) {
        List<List<String>>ListUsersAndPasswords = usersAndPasswords.asLists(String.class);

        for(int i = 0; i < ListUsersAndPasswords.size(); i++) {
            System.out.println("ListItemler = " + ListUsersAndPasswords.get(i).get(0)+" "+
                    ListUsersAndPasswords.get(i).get(1));
        }

    }
}

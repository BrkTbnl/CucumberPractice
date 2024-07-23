package _JDBC.Part1;

import org.testng.annotations.Test;
import java.sql.*;

public class _03_NextPrevAbsRel extends JDBCParent{

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from language");

        rs.next(); // One step forward --> 1. Row
        System.out.println("1.Row = " + rs.getString(2));      // 1. Row and 2. Column                  - Italian

        rs.next();  // One step forward --> 2. Row
        System.out.println("2.Row = " + rs.getString("name")); // 2. Row and name Column (2. Column)    - English

        rs.previous(); // One step previous --> 1.Row
        System.out.println("1.Row = " + rs.getString(2));      // 1. Row and 2. Column                   - I

    }




    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from film");

        rs.absolute(10); // Go directly to line 10
        System.out.println("10.Row title = " + rs.getString("title")); // ALADDIN CALENDAR

        rs.absolute(5);  // Go directly to line 5
        System.out.println("5.Row title = " + rs.getString("title"));  // AFRICAN EGG

        rs.relative(5); // Wherever you are at the end, go 5 from there --> to line 10
        System.out.println("10.Row title = " + rs.getString("title")); // ALADDIN CALENDAR

        rs.next(); // Goes to 11
    }
    // rs.next()          : Next Line
    // rs.previous        : Previous Line
    // rs.absolute(10)    : Moves forward to line 10 from the beginning.
    // rs.relative(10)    : It moves forward from its current position to the 10th line.
    // rs.absolute(-10)   : - (minus) means from the end, 10th line from the end
    // rs.relative(-5)    : - (minus) 5 lines back from where it is

    // If we want to go back 5 from the first line with relative,
    // it will give an error because it exceeds the limit.

}

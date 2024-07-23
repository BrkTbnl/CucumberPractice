package _JDBC.Part1;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _02_test extends JDBCParent {

    @Test
    public void test_01() throws SQLException {
        ResultSet rs= statement.executeQuery("select * from customer");
        rs.next(); // at this stage I have completed the first line

        String name=rs.getString("first_name");   // I got the information  in this line
        String surname=rs.getString("last_name"); // I got the information in this line
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);

    }

}

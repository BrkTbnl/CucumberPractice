package _JDBC.Part1;


import org.testng.annotations.Test;
import java.io.IOException;
import java.sql.*;
import static Utilities.ConfigReader.*;

public class _01_Intro {

    @Test
    public void test1() throws SQLException, IOException {
        // What is done to make a query work

        // 1)- We entered the connection information --> Connection information was set.
        Connection conn = DriverManager.getConnection(getDbUrl(), getUsername(), getPassword());

        // 2)- We have chose the database --> This information was added to hostUrl in config file
        // (/sakila); no other additional action was taken


        // 3)- We opened the query screen
        Statement statement = conn.createStatement();

        // 4)- wrote the query to query screen then run
        ResultSet resultTable = statement.executeQuery("select * from customer");

        // 5)- The results appeared below
        resultTable.next(); // at this stage I have completed the first line

        String name=resultTable.getString("first_name");   // I got the information  in this line
        String surname=resultTable.getString("last_name"); // I got the information in this line
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);

        resultTable.next(); // At this stage I have completed the second line

        name=resultTable.getString("first_name");   // I got the information in this line
        surname=resultTable.getString("last_name"); // I got the information in this line
        System.out.println("name = " + name);
        System.out.println("surname = " + surname);

        conn.close();
    }

}

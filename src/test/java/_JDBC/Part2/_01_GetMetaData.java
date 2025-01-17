package _JDBC.Part2;

import _JDBC.Part1.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _01_GetMetaData extends JDBCParent {

    @Test
    public void test1() throws SQLException {
        ResultSet rs = statement.executeQuery("select city_id, city, country_id from city");

        rs.last();

        String id = rs.getString(1);

        System.out.println("id = " + id);

        //you can get int value too
        int intId = rs.getInt(1);
        System.out.println("intId = " + intId);
    }

    @Test
    public void test2() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        ResultSetMetaData rsmd = rs.getMetaData(); //
        rs.next();

        //  print the names and types of the columns
        int columnCount = rsmd.getColumnCount();
        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + " header: "
                    + rsmd.getColumnName(i)
                    + " " + rsmd.getColumnTypeName(i) + "\t");
            // I printed the names and types of the columns
        }

        System.out.println();

        for (int i = 1; i <= columnCount; i++) {
            System.out.println("Column " + i + ")- " + rs.getString(i) + "\t");
            // I can print data in all columns
        }
    }

    @Test
    public void test03() throws SQLException {

        /*
         -----------------------------------------------------------------------------------
         Print the contents of all rows and columns in the Language table as in the table.
         */

        ResultSet resultTable = statement.executeQuery("select * from language");
        // Other information other than data
        ResultSetMetaData resultSetMetaData = resultTable.getMetaData();
        // Number of columns
        int columnCount = resultSetMetaData.getColumnCount();

        resultTable.last();
        int numberOfRows = resultTable.getRow(); // Number of Rows

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(resultSetMetaData.getColumnName(i) + "\t");
        }

        resultTable.first();
        for (int i = 1; i <= numberOfRows; i++) {
            System.out.println();
            for (int j = 1; j <= columnCount; j++) {
                System.out.print(resultTable.getString(j) + "\t");
            }
            resultTable.next();
        }
    }

    @Test
    public void test04() throws SQLException {
        /*
        Print the contents of all rows and columns in the Language table as in the table.
         */

        ResultSet rs = statement.executeQuery("select * from language");

        int columnCount = rs.getMetaData().getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.print(rs.getMetaData().getColumnName(i) + "\t");
        }

        System.out.println();

        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.print(rs.getString(i)+ "\t");
            }
            System.out.println();
        }

    }

    @Test
    public void test04_2() throws SQLException {
        /*
        Print the contents of all rows and columns in the Language table as in the table.
         */

        ResultSet rs = statement.executeQuery("select * from language");

        int columnCount = rs.getMetaData().getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            System.out.printf("%-20s",rs.getMetaData().getColumnName(i) + "\t");
        }

        System.out.println();

        while (rs.next()){
            for (int i = 1; i <= columnCount; i++) {
                System.out.printf("%-20s",rs.getString(i)+ "\t");
            }
            System.out.println();
        }
        /*
         % : points to the value of the variable
         - : prints left aligned, default right aligned
         20: how many digits will be used each time its information
         s: is used for string values, d is used for numeric values
         "%5.2f" : use 5 digits for number, 2 digits for decimal part-
         */
    }
}

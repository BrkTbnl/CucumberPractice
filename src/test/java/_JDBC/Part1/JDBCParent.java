package _JDBC.Part1;

import org.testng.annotations.*;
import java.sql.*;
import static Utilities.ConfigReader.*;

public class JDBCParent {
    public static Connection connection;
    public static Statement statement;

    @BeforeClass
    public void dbConnect(){
        try{
            connection = DriverManager.getConnection(getDbUrl(), getUsername(), getPassword());
            statement = connection.createStatement();
        }catch (Exception ex){
            System.out.println("Exception in DBConnect" + ex.getMessage());
        }

    }

    @AfterClass
    public void dbDisconnect(){
        try{
            connection.close();
        }catch (SQLException ex){
            System.out.println("Exception in DBDisconnect" + ex.getMessage());
        }
    }

}

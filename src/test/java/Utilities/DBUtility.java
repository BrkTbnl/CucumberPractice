package Utilities;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static Utilities.ConfigReader.*;

public class DBUtility {

    public static Connection connection;
    public static Statement statement;

    public List<List<String>> getDataList(String sql) {
        List<List<String>> table = new ArrayList<>();

        dbConnect();

        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            //if you also need info for each column
//            ArrayList<String> columnNames = new ArrayList<>();
//            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//                columnNames.add(rsmd.getColumnName(i));
//
//            }
//            table.add(columnNames);

            while (rs.next()) {
                List<String> rowList = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    rowList.add(rs.getString(i));
                }
                table.add(rowList);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        dbDisconnect();
        return table;
    }

    public void dbConnect(){
        try{
            connection = DriverManager.getConnection(getDbUrl(), getUsername(), getPassword());
            statement = connection.createStatement();
        }catch (Exception ex){
            System.out.println("Exception in DBConnect" + ex.getMessage());
        }

    }

    public void dbDisconnect(){
        try{
            connection.close();
        }catch (SQLException ex){
            System.out.println("Exception in DBDisconnect" + ex.getMessage());
        }
    }

}

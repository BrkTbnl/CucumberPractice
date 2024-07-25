package _JDBC.Part2;

import _JDBC.Part1.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class _02_GetAllRowColumn extends JDBCParent {

    @Test
    public void test1() throws SQLException {

        String sql = "select * from language";
        List<List<String>> returningList = getDataList(sql);

        for (int rowIndex = 0; rowIndex < returningList.size() ; rowIndex++) {
            List<String> row = returningList.get(rowIndex);
            for (int columnIndex = 0; columnIndex < row.size(); columnIndex++) {
                System.out.printf("%-15s", row.get(columnIndex));
            }
            System.out.println();
        }

    }

    public List<List<String>> getDataList(String sql) {
        List<List<String>> table = new ArrayList<List<String>>();

        try {
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData rsmd = rs.getMetaData();

            ArrayList<String> columnNames = new ArrayList<>();
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                columnNames.add(rsmd.getColumnName(i));

            }
            table.add(columnNames);

            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    row.add(rs.getString(i));
                }
                table.add(row);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return table;
    }
}

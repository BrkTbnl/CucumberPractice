package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int numberOfColumns) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();

        Sheet sheet = null;
        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException exception) {
            System.out.println("exception = " + exception.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // each line
            ArrayList<String> row = new ArrayList<>();

            for (int j = 0; j < numberOfColumns; j++) {  // circulate as many columns as possible
                row.add(sheet.getRow(i).getCell(j).toString());
            }
            table.add(row);
        }
        return table;
    }
}
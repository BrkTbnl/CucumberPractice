package Utilities;

import org.apache.poi.ss.usermodel.*;
import java.io.*;
import java.util.ArrayList;

public class ExcelUtility {

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int numberOfColumns) {
        ArrayList<ArrayList<String>> table = new ArrayList<>();
        FileInputStream inputStream = null;
        Workbook workbook = null;

        try {
            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // each row
                Row sheetRow = sheet.getRow(i);

                // Check if the row is empty
                boolean isEmptyRow = true;
                for (int j = 0; j < numberOfColumns; j++) {
                    Cell cell = sheetRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    if (cell != null && cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
                        isEmptyRow = false;
                        break;
                    }
                }

                if (!isEmptyRow) {
                    ArrayList<String> row = new ArrayList<>();
                    for (int j = 0; j < numberOfColumns; j++) {  // circulate as many columns as possible
                        Cell cell = sheetRow.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                        row.add(cell.toString());
                    }
                    table.add(row);
                }
            }
        } catch (IOException exception) {
            System.out.println("exception = " + exception.getMessage());
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (workbook != null) workbook.close();
            } catch (IOException e) {
                System.out.println("exception = " + e.getMessage());
            }
        }
        return table;
    }
}

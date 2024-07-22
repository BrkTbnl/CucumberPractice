package Utilities;

import io.cucumber.java.Scenario;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
                        // If cell is empty this will create as blank.
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

    public static void writeToExcel(String path, Scenario scenario, String browserName) {

        File file = new File(path);
        FileInputStream inputStream = null;
        Workbook workbook = null;
        Sheet sheet = null;

        try {
            if (!file.exists()) {
                // Create a workbook in memory, create a sheet in memory
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Scenario Results");
                // Perform operations in memory
                Row row = sheet.createRow(0);

                Cell cell = row.createCell(0);
                cell.setCellValue("Scenario Name");

                cell = row.createCell(1);
                cell.setCellValue("Status");

                cell = row.createCell(2);
                cell.setCellValue("Browser");

                // Save the header
                try (FileOutputStream outputStream = new FileOutputStream(path)) {
                    workbook.write(outputStream);
                }
            }

            inputStream = new FileInputStream(path);
            workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheetAt(0);

            int lastRowIndex = sheet.getPhysicalNumberOfRows();
            Row row = sheet.createRow(lastRowIndex);

            Cell cell = row.createCell(0);
            cell.setCellValue(scenario.getName());

            cell = row.createCell(1);
            cell.setCellValue(scenario.getStatus().toString());

            cell = row.createCell(2);
            cell.setCellValue(browserName);

            inputStream.close();

            try (FileOutputStream outputStream = new FileOutputStream(path)) {
                workbook.write(outputStream);
            }
        } catch (IOException exception) {
            System.out.println("exception.getMessage() = " + exception.getMessage());
        } finally {
            try {
                if (inputStream != null) inputStream.close();
                if (workbook != null) workbook.close();
            } catch (IOException e) {
                System.out.println("exception.getMessage() = " + e.getMessage());
            }
        }
    }
}

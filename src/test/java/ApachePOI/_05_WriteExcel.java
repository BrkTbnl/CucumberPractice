package ApachePOI;

import org.apache.poi.ss.usermodel.*;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _05_WriteExcel {

    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resources/WriteExcel.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int lastRownum = sheet.getPhysicalNumberOfRows();
        Row newRow = sheet.createRow(lastRownum);
        Cell newCell = newRow.createCell(0);
        newCell.setCellValue("Hey There ");

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileOutputStream.close();

        System.out.println("The process is over.");



    }
}

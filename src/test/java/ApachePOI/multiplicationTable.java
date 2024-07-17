package ApachePOI;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class multiplicationTable {
    public static void main(String[] args) throws IOException {

        /*
         *  Copy the multiplication table into a blank excel file
         *  print below.
         */

        String path = "src/test/java/ApachePOI/resources/MultiplicationTable.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        int newRowIdex = 0; //sheet.getPhysicalNumberOfRows();

        for (int i = 1; i <=10 ; i++) {

            for (int j = 1; j <=10 ; j++) {
                Row row = sheet.createRow(newRowIdex++);

                row.createCell(0).setCellValue(i);
                row.createCell(1).setCellValue("x");
                row.createCell(2).setCellValue(j);
                row.createCell(3).setCellValue("=");
                row.createCell(4).setCellValue(i*j);

            }
            Row nextRow =sheet.createRow(newRowIdex++);
        }

        fileInputStream.close();

        FileOutputStream fileOutputStream = new FileOutputStream(path);

        workbook.write(fileOutputStream);
        workbook.close();
        fileOutputStream.close();

        System.out.println("the process is over");

    }
}

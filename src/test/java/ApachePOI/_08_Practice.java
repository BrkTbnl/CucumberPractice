package ApachePOI;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _08_Practice {
    public static void main(String[] args) throws IOException {

         /*  -------------------------------------------------------------------
         *
         *  Copy the multiplication table into a new excel file
         *  print below.
         */


        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sheet = wb.createSheet("Practice");


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

        String path = "src/test/java/ApachePOI/resources/Practice.xlsx";
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        wb.write(fileOutputStream);
        wb.close();
        fileOutputStream.close();

        System.out.println("the process is over");



    }
}

package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _02_ApachePOIStart {

    public static void main(String[] args) throws IOException {

        String path = "src/test/java/ApachePOI/resources/ApacheExcel.xlsx";

        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);
        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);

        System.out.println(cell.getStringCellValue());



    }



}

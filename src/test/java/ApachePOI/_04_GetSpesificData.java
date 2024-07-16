package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class _04_GetSpesificData {
    public static void main(String[] args) throws IOException {
        String returningResult = bringFromExcel("address");
        System.out.println(returningResult);
    }

    private static String bringFromExcel(String searchWord) throws IOException {

        String willReturn = "";

        String path = "src/test/java/ApachePOI/resources/LoginData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheetAt(0);

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(searchWord.toLowerCase())) {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    willReturn += sheet.getRow(i).getCell(j);
                }
            }
        }
        return willReturn;

        /** The Second Way --- With StringBuilder*/
//        StringBuilder willReturn = new StringBuilder();
//
//        String path = "src/test/java/apachePOI/resource/LoginData.xlsx";
//        FileInputStream fileInputStream = new FileInputStream(path);
//        Workbook workbook = WorkbookFactory.create(fileInputStream);
//        Sheet sheet = workbook.getSheetAt(0);
//
//        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
//            if (sheet.getRow(i).getCell(0).toString().toLowerCase().contains(searchWord.toLowerCase())) {
//                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
//                    willReturn.append(sheet.getRow(i).getCell(j));
//                }
//            }
//        }
//        return willReturn.toString();
    }
}

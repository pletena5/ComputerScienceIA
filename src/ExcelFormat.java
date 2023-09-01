/*

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFormat {

    public static  void readFile(String location){

        try {
            FileInputStream file = new FileInputStream(new File(location));
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            XSSFSheet sheet= workbook.getSheetAt(0);

            Row r = sheet.getRow(0);
            System.out.println(r.getCell(0));


        }catch(IOException e){
            e.printStackTrace();
        }// exception handler

    }// read excel file class

}// excel format class

 */
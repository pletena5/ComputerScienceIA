import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

public class ExcelFormat {

    public static  void readFile(String location){

        try {
            FileInputStream file = new FileInputStream(new File(location));
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            HSSFSheet sheet= workbook.getSheetAt(0);



        }catch(IOException e){
            e.printStackTrace();
        }// exception handler

    }// read excel file class

}// excel format class
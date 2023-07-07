import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import org.apache.*;

public class ExcelFormat {

    public static  void readFile(String location){

        try {
            FileInputStream file = new FileInputStream(new File(location));
            //Workbook workbook = new XSSFWorkbook(file);
        }catch(IOException e){
            e.printStackTrace();
        }// exception handler

    }// read excel file class

}// excel format class
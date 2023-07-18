import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //FloorPlan x = new FloorPlan("C:\\Users\\17karasimov_m\\IdeaProjects\\Computer science IA\\trump.png");
        //System.out.println("");

        //x.upload();
        //Integer[][] values = x.getArrValues();
        //PathFinder p = new PathFinder(values);

        //int a = x.getArea();
        //System.out.println(a);

        //WebsiteReader.readWebsite("https://www.bexleygs.co.uk");
        ExcelFormat e = new ExcelFormat();
        e.readFile("Document.xlsx");

        new Interface();
        new Music();

    }// main method

}// class main
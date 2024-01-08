import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){

        /*

        FloorPlan x = new FloorPlan("Square.png");
        //System.out.println("");

        //x.upload();
        Integer[][] values = x.getImageValues();

        x.FloodFill(13 , 5 , -1);

        for (int i = 0; i < x.imageValues.length; i++){
            for (int j = 0; j < x.imageValues[0].length; j++){
                System.out.print(x.imageValues[i][j] + " ");
            }
            System.out.println();
        }

*/
        GUI gui = new GUI();
        gui.construct();
        gui.loadingScreen();
        gui.mainMenu();


        //CostEstimationMenu e = new CostEstimationMenu();
        //e.getMaterial();

        //System.out.println(x.getArea());
        //PathFinder p = new PathFinder(values);

        //int a = x.getArea();
        //System.out.println(a);

        //WebsiteReader.readWebsite("https://www.bexleygs.co.uk");
        //ExcelFormat e = new ExcelFormat();
        //e.readFile(pathname);

        //GUI gui = new GUI();
        //String pathname = gui.directoryinput();

        //FloorPlan fp = new FloorPlan(pathname);
        //fp.getArea();

    }// main method

}// class main
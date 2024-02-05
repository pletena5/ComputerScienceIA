import java.awt.*;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args){


        MainMenu menu = new MainMenu();
        menu.construct();
        menu.loadingScreen();
        menu.mainMenu();


    }// main method

}// class main
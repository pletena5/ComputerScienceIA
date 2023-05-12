import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class ImageHandling {

    BufferedImage image;
    int width;
    int height;
    Integer[][] imageValues;

    public ImageHandling() {
        try {
            File input = new File("C:\\Users\\17karasimov_m\\IdeaProjects\\Computer science IA\\trump.png");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            imageValues = new Integer[height][width];

            int count = 0;

            for(int i=0; i<height; i++) {

                for(int j=0; j<width; j++) {

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println(" Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                    imageValues[i][j] = (c.getRed() + c.getGreen() + c.getBlue());
                }
            }
            //System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }// constructor

    public ArrayList<String> getFileValues(){
        FileHandling x = new FileHandling();
        ArrayList<String> a = x.lineReturn("e.txt");
        return a;
    }// getter

    public Integer[][] getArrValues(){
        return imageValues;
    }// get array values

    public void upload (){
        FileHandling x = new FileHandling();
        x.FileWrite("e.txt" , "" , false);
        for (int i = 0 ; i < imageValues.length ; i++){
            for (int j = 0; j < imageValues[0].length; j++){
                x.FileWriteLine("e.txt", imageValues[i][j].toString(), true);
            }// for j
        }// for loop
        //x.FileWrite("e" , "egg" , true);
    }// upload method

}// class
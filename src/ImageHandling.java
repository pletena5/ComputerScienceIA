import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.*;

import javax.imageio.ImageIO;


public class ImageHandling {

    BufferedImage image;
    int width;
    int height;

    public ImageHandling() {
        try {
            File input = new File("C:\\Users\\17karasimov_m\\IdeaProjects\\Computer science IA\\trump.jfif");
            image = ImageIO.read(input);
            width = image.getWidth();
            height = image.getHeight();

            int count = 0;

            for(int i=0; i<height; i++) {

                for(int j=0; j<width; j++) {

                    count++;
                    Color c = new Color(image.getRGB(j, i));
                    System.out.println(" Red: " + c.getRed() +"  Green: " + c.getGreen() + " Blue: " + c.getBlue());
                }
            }
            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}// class
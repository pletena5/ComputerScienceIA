import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class SettingsMenu extends GUI{

    public void settingsMenu(){

        try{


            frame.getContentPane().removeAll();

            BufferedImage bufferedImage = ImageIO.read(new File("SettingScreen.jpg"));
            Image loadingScreen = bufferedImage.getScaledInstance(1920 , 1080 , 0);

            ImageIcon image = new ImageIcon(loadingScreen);
            JLabel imageDisplay = new JLabel(image);

            imageDisplay.setLocation(-40 , 0);
            imageDisplay.setSize(2000 , 1000);

            frame.getContentPane().add(imageDisplay);
            panel.setLayer(imageDisplay , 1);



            //panel.add(imageDisplay);
            //frame.setContentPane(panel);

        }catch(Exception e){
            System.out.println("error");
        }// error handling



        // home button
        homeButton();



    }// creates the main menu

}// settings menu class

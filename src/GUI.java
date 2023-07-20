import javax.swing.*;
import java.awt.*;
import java.io.PrintStream;


public class GUI {

    public GUI(){

        JFrame frame;
        frame=new JFrame();
        frame.setTitle("Cost estimator 5000");
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setSize(1920,1080);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }// interface constructor

    public String directoryinput(){
        var pathname = JOptionPane.showInputDialog("What is the address of the image?");
        var output = "You have entered: " + pathname;
        JOptionPane.showMessageDialog(null, output);
        return pathname;
    }// directory input method

    public void text(String text){

    }// text output method

}// class interface
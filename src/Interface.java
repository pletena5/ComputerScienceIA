import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;


public class Interface {

    public Interface(){
        JFrame frame;
        frame=new JFrame();
        frame.setTitle("Cost estimator 5000");
        frame.getContentPane().setLayout(null);
        frame.getContentPane().setBackground(Color.CYAN);
        frame.setSize(1920,1080);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }// interface constructor

}// class interface

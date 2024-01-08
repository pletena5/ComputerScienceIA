import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class MainMenu extends GUI{

    public void mainMenu(){

        try{


            frame.getContentPane().removeAll();

            BufferedImage bufferedImage = ImageIO.read(new File("MainMenu.jpg"));
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



        // new project button
        newProjectButton();

        // delete project button
        deleteProjectButton();

        // home button
        homeButton();

        // settings button
        settingsButton();

        // displays the projects on screen
        projectDisplay();



    }// creates the main menu




    public void deleteProjectButton(){
        JPanel DeleteProject = new JPanel();
        DeleteProject.setVisible(true);
        DeleteProject.setSize(200 , 40);
        DeleteProject.setLocation(858 , 170);

        JButton DeleteProjectButton = new JButton("D e l e t e     P  r  o  j  e  c  t");
        DeleteProjectButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        DeleteProject.add(DeleteProjectButton);
        DeleteProjectButton.setVisible(true);


        DeleteProjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent c) {

                FileHandling fh = new FileHandling();
                ArrayList<String> numProjectsArr = fh.lineReturn("Projects.txt");
                ArrayList<String> projectDirectories = fh.lineReturn("ProjectDirectories.txt");
                Integer numProjects = Integer.parseInt(numProjectsArr.get(0));

                int projectToDelete = Integer.parseInt(JOptionPane.showInputDialog("Which project would you like to delete?"));

                if (projectToDelete <= 0 || projectToDelete > numProjects){
                    //JOptionPane.showMessageDialog();

                    JOptionPane.showMessageDialog(null , "Invalid!");


                }// checks if number in range
                else {

                    fh.FileWrite("Projects.txt", Integer.toString(numProjects - 1), false);
                    projectDirectories.remove(projectDirectories.get(projectToDelete - 1));

                    //fh.FileWriteLine("ProjectDirectories.txt", projectDirectories.get(0), false);



                    if(numProjects > 1) {
                        fh.FileWriteLine("ProjectDirectories.txt", projectDirectories.get(0), false);
                        for (int i = 0; i < numProjects - 2; i++) {
                            fh.FileWriteLine("ProjectDirectories.txt", projectDirectories.get(i + 1), true);
                        }// adds the correct data back to text files
                    }else{
                        fh.FileDelete("ProjectDirectories.txt");
                    }

                    mainMenu();
                }

            }
        });


        frame.getContentPane().add(DeleteProject);
        panel.setLayer(DeleteProject , 2);
    }// creates button to delete a project










    public void newProjectButton(){
        JPanel newProjectButtonPanel = new JPanel();
        newProjectButtonPanel.setVisible(true);
        newProjectButtonPanel.setSize(200 , 40);
        newProjectButtonPanel.setLocation(858 , 210);

        JButton newProjectButton = new JButton("N  e  w     P  r  o  j  e  c  t");
        newProjectButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        newProjectButtonPanel.add(newProjectButton);
        newProjectButton.setVisible(true);
        //newProjectButton.setOpaque(false);
        //newProjectButton.setContentAreaFilled(false);
        //newProjectButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        newProjectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String filename = directoryinput();
                if (filename != ""){
                    Project project = new Project(filename);
                    projectDisplay();

                    frame.setSize(1920,1080);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


                }// checks if cancel was pressed

            }
        });

        frame.getContentPane().add(newProjectButtonPanel);
        panel.setLayer(newProjectButtonPanel , 2);
    }// creates button for making a new project





    public void projectDisplay(){
        FileHandling fh = new FileHandling();
        ArrayList<String> numProjectsArr = fh.lineReturn("Projects.txt");
        Integer numProjects = Integer.parseInt(numProjectsArr.get(0));
        //System.out.println(numProjects);
        int offset = 0;

        if (numProjects != 0) {
            for (int i = 0; i < numProjects; i++) {
                offset = i * 80;
                IndividualProjectDisplay(offset);
            }// for loop
        }// makes sure it isnt 0


        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }// displays all projects saved in files








}// main menu class

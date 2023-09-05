import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GUI {

    JFrame frame;
    JLayeredPane panel = new JLayeredPane();

    public GUI(){

        /*
        frame=new JFrame();
        frame.setTitle("Cost estimator 5000");
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1920,1080);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */

        frame=new JFrame();
        frame.setTitle("Cost estimator 5000");
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setSize(1920,1080);
        frame.setVisible(true);
        frame.setSize(1000 , 1000);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setLayout(null);
        panel.setVisible(true);
        frame.setContentPane(panel);


    }// interface constructor

    public String directoryinput(){
        boolean incorrect = false;
        var pathname = "";

        while (incorrect == false) {
            pathname = JOptionPane.showInputDialog("What is the address of the floorplan?");
            String output = "You have entered: " + pathname;
            int i = JOptionPane.showConfirmDialog(null, output);

            if ( i == 0 ){
                incorrect = true;
            }// if statement stopping while loop
            else if (i == 2){
                return "";
            }// if cancel is pressed

        }// while loop

        return pathname;
    }// directory input method

    public void loadingScreen(){
        try {
            frame.getContentPane().removeAll();

            BufferedImage bufferedImage = ImageIO.read(new File("loadingScreen.jpg"));
            Image loadingScreen = bufferedImage.getScaledInstance(1920 , 1080 , 0);

            ImageIcon image = new ImageIcon(loadingScreen);
            JLabel imageDisplay = new JLabel(image);

            imageDisplay.setLocation(-40 , 0);
            imageDisplay.setSize(2000 , 1000);

            frame.getContentPane().add(imageDisplay);

            frame.setSize(1000 , 1000);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

            sleep(1000);

            frame.getContentPane().remove(imageDisplay);
            frame.setSize(1920,1080);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        } catch (Exception e ){
            System.out.println("error");
            e.printStackTrace();
        }// error handling
    }// loading screen

    public void sleep(int t) throws InterruptedException{
        Thread.sleep(t);
    }// sleep method

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


        JPanel newProjectButtonPanel = new JPanel();
        newProjectButtonPanel.setVisible(true);
        newProjectButtonPanel.setSize(180 , 40);
        newProjectButtonPanel.setLocation(870 , 190);

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


                    FileHandling fh = new FileHandling();
                    ArrayList<String> numProjectsArr = fh.lineReturn("Projects.txt");
                    Integer numProjects = Integer.parseInt(numProjectsArr.get(0));
                    //System.out.println(numProjects);
                    int offset = 0;

                    if (numProjects != 0) {
                        for (int i = 0; i < numProjects; i++) {
                            offset = i * 80;
                            ProjectDisplay(offset);
                        }// for loop
                    }// makes sure it isnt 0

                    frame.setSize(1920,1080);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);


                }// checks if cancel was pressed

            }
        });

        frame.getContentPane().add(newProjectButtonPanel);
        panel.setLayer(newProjectButtonPanel , 2);




// home button



        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(50 , 40);
        homeButtonPanel.setLocation(658 , 190);

        JButton homeButton = new JButton("Home");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);




        // settings button



        JPanel settingButtonPanel = new JPanel();
        settingButtonPanel.setVisible(true);
        settingButtonPanel.setSize(40 , 40);
        settingButtonPanel.setLocation(1202 , 190);

        JButton settingButton = new JButton("----");
        settingButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        settingButtonPanel.add(settingButton);
        settingButton.setVisible(true);
        //settingButton.setOpaque(false);
        //settingButton.setContentAreaFilled(false);
        //settingButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        settingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                settings();
            }
        });

        frame.getContentPane().add(settingButtonPanel);
        panel.setLayer(settingButtonPanel , 2);







        // displays the projects on screen

        FileHandling fh = new FileHandling();
        ArrayList<String> numProjectsArr = fh.lineReturn("Projects.txt");
        Integer numProjects = Integer.parseInt(numProjectsArr.get(0));
        //System.out.println(numProjects);
        int offset = 0;

        if (numProjects != 0) {
            for (int i = 0; i < numProjects; i++) {
                offset = i * 80;
                ProjectDisplay(offset);
            }// for loop
        }// makes sure it isnt 0


        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);



    }// creates the main menu






    public void ProjectDisplay(int offset){

            JPanel Project = new JPanel();
            Project.setVisible(true);
            Project.setSize(100, 60);
            Project.setLocation(900 , 370+offset);
            Project.setBackground(Color.GRAY);

            int num = offset/80 + 1;
            JButton projectButton = new JButton("Project " + num);
            projectButton. setFont(new FontUIResource("Helvetica", 0 , 15));
            Project.add(projectButton);
            projectButton.setVisible(true);
            //settingButton.setOpaque(false);
            //settingButton.setContentAreaFilled(false);
            //settingButton.setBorderPainted(false);
            //newProjectButton.setSize(200 , 200);

            projectButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    int pNum = offset/80;

                    FileHandling fh = new FileHandling();
                    ArrayList<String> numProjectsArr = fh.lineReturn("ProjectDirectories.txt");
                    String photoName = numProjectsArr.get(pNum);

                    BufferedImage bufferedImage = null;
                    try {
                        bufferedImage = ImageIO.read(new File(photoName));
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }// error handling

                    Image loadingScreen = bufferedImage.getScaledInstance(1000 , 1000 , 0);

                    ImageIcon image = new ImageIcon(loadingScreen);
                    JLabel imageDisplay = new JLabel(image);

                    imageDisplay.setLocation(500 , 20);
                    imageDisplay.setSize(1000 , 1000);

                    panel.add(imageDisplay);
                    panel.setLayer(imageDisplay , 1);


                    final int[] clickss = {0};
                    int dist = Integer.parseInt(JOptionPane.showInputDialog("Please select 2 points on the floorplan that are the specified distance apart (insert distance): "));
                    ArrayList<Integer> arrint = new ArrayList<Integer>();
                    final double[] singlePixDist = {0};

                    imageDisplay.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            clickss[0] = clickss[0] + 1;

                            if (clickss[0] < 2){
                                int y = e.getY();
                                int x = e.getX();

                                arrint.add(x , y);

                            } else if (clickss[0] == 2){
                                int y = e.getY();
                                int x = e.getX();

                                arrint.add(x , y);

                                int dx = Math.abs(arrint.get(0) - arrint.get(2));
                                int dy = Math.abs(arrint.get(1) - arrint.get(3));

                                double pixDist = Math.sqrt(Math.pow(dx , 2) + Math.pow(dy , 2));
                                singlePixDist[0] = dist / pixDist;

                                JOptionPane.showMessageDialog(null , "Please now click on the area you would like to calculate.");

                            }// if statement
                            else if (clickss[0] == 3){
                                int x = e.getX();
                                int y = e.getY();

                                FloorPlan fpm = new FloorPlan(photoName);
                                int pixelArea = fpm.getPixelArea(x , y);

                                double totalArea = pixelArea * Math.pow(singlePixDist[0] , 2);
                                JOptionPane.showMessageDialog(null , "The total area of that section is: " + totalArea);

                                panel.removeAll();
                                mainMenu();
                            }// checks if user is done clicking


                        }// mouse clicked event

                        @Override
                        public void mousePressed(MouseEvent e) {

                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {

                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {

                        }

                        @Override
                        public void mouseExited(MouseEvent e) {

                        }
                    });


                    frame.setSize(1920,1080);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

                }// opens project interaction menu
            });

            frame.getContentPane().add(Project);
            panel.setLayer(Project , 2);


    }// displays projects







    public void settings(){

        frame.getContentPane().removeAll();

        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(50 , 40);
        homeButtonPanel.setLocation(658 , 190);

        JButton homeButton = new JButton("Home");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainMenu();
            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);

        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    }// settings button



}// class interface
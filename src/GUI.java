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


abstract public class GUI {

    static JFrame frame;
    static JLayeredPane panel = new JLayeredPane();

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
/*
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
*/

    }// interface constructor

    public void construct(){
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
    }// constructs frame







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
        MainMenu menu = new MainMenu();
        menu.mainMenu();
    }// creates the main menu















    public void IndividualProjectDisplay(int offset){

            JPanel Project = new JPanel();
            Project.setVisible(true);
            Project.setSize(100, 60);
            Project.setLocation(800 , 370+offset);
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


        FileHandling fh = new FileHandling();
        ArrayList<String> numProjectsArr = fh.lineReturn("ProjectDirectories.txt");
        String photoName = numProjectsArr.get(offset/80);

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(photoName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }// error handling

        Image loadingScreen = bufferedImage.getScaledInstance(80 , 80, 0);

        ImageIcon image = new ImageIcon(loadingScreen);
        JLabel imageDisplay = new JLabel(image);

        imageDisplay.setLocation(1000 , 360 + offset);
        imageDisplay.setSize(80 , 80);

        panel.add(imageDisplay);
        panel.setLayer(imageDisplay , 2);






            projectButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    frame.getContentPane().removeAll();
                    homeButton();
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

                    Image loadingScreen = bufferedImage.getScaledInstance(2000 , 1000 , 0);

                    double ScaleFactorX = 2000.0  / bufferedImage.getWidth();
                    double ScaleFactorY = 1000.0 / bufferedImage.getHeight();

                    System.out.println("original width: " + bufferedImage.getWidth() + ", original height:  " + bufferedImage.getHeight());

                    ImageIcon image = new ImageIcon(loadingScreen);
                    JLabel imageDisplay = new JLabel(image);

                    imageDisplay.setLocation(0 , 20);
                    imageDisplay.setSize(2000 , 1000);

                    panel.add(imageDisplay);
                    panel.setLayer(imageDisplay , 1);


                    int[] clickss = {0};
                    Double dist = Double.parseDouble(JOptionPane.showInputDialog("Please select 2 points on the floorplan that are the specified distance apart (insert distance): "));
                    ArrayList<Double> arrint = new ArrayList<Double>();
                    double[] singlePixDist = {0};

                    imageDisplay.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            clickss[0] = clickss[0] + 1;
                            System.out.println("num clicks" + clickss[0]);

                            if (clickss[0] < 2){
                                int y = e.getY();
                                int x = e.getX();

                                System.out.println("x , y coordinates raw" + x + " " + y);

                                arrint.add((double)x / ScaleFactorX);
                                arrint.add((double)y / ScaleFactorY);

                            } else if (clickss[0] == 2){
                                int y = e.getY();
                                int x = e.getX();

                                System.out.println("raw x y coords 2" + x + " " + y);

                                arrint.add((double)x / ScaleFactorX);
                                arrint.add((double)y / ScaleFactorY);

                                double dx = (Math.abs(arrint.get(0) - arrint.get(2)));
                                //double dy = (Math.abs(arrint.get(1) - arrint.get(3)));

                                //double pixDist = Math.sqrt(Math.pow(dx , 2) + Math.pow(dy , 2));
                                double pixDist = dx;
                                singlePixDist[0] = dist / pixDist;

                                System.out.println("Distance in pixels measured " + pixDist);
                                System.out.println("metres in a pixel " + singlePixDist[0]);

                                JOptionPane.showMessageDialog(null , "Please now click on the area you would like to calculate.");

                            }// if statement
                            else if (clickss[0] == 3){
                                double x = (double)e.getX() / ScaleFactorX;
                                double y = (double)e.getY() / ScaleFactorY;

                                System.out.println("x y coords fed into floodfill: " + (int)x + "  " + (int)y);

                                FloorPlan fpm = new FloorPlan(photoName);
                                int pixelArea = fpm.FloodFill((int)y , (int)x , -1);


                                System.out.println(pixelArea);

                                double totalArea = (double)Math.round(100*(pixelArea * Math.pow(singlePixDist[0] , 2)))/100;
                                JOptionPane.showMessageDialog(null , "The total area of that section is: " + totalArea);

                                panel.removeAll();

                                frame.getContentPane().removeAll();
                                //homeButton();
                                costEstimationMenu(photoName , totalArea);
                                refresh();
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









    public void costEstimationMenu(String photoName , double area){

        CostEstimationMenu estmenu = new CostEstimationMenu();
        estmenu.costEstimationMenu(photoName , area);

    }// provides the cost estimation interface





    public void settings(){

        //frame.getContentPane().removeAll();

        SettingsMenu menu = new SettingsMenu();
        menu.settingsMenu();

        //homeButton();
        //refresh();

    }// settings button




    public void refresh(){
        frame.setSize(1920,1080);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }// refreshes jframe





    public void homeButton(){
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
    }// creates home button








    public void homeButton(int sizeAdd){
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(50 + sizeAdd, 40);
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
    }// creates home button















    public void settingsButton(){
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
    }// creates settings button



}// class interface
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CostEstimationMenu extends GUI{

    public void costEstimationMenu(String photoName , double area){

        try{
            frame.getContentPane().removeAll();

            BufferedImage bufferedImage = ImageIO.read(new File("EstimationScreen.jpg"));
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



        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(new File(photoName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }// error handling

        Image loadingScreen = bufferedImage.getScaledInstance(540 , 390, 0);

        ImageIcon image = new ImageIcon(loadingScreen);
        JLabel imageDisplay = new JLabel(image);

        imageDisplay.setLocation(1200 , 416);
        imageDisplay.setSize(540 , 390);

        panel.add(imageDisplay);
        panel.setLayer(imageDisplay , 2);


        //home button
        homeButton(30);

        calculateButton();

        addMaterialButton();

        createScrollDisplay();

        deleteMaterialButton();

    }// provides the cost estimation interface






    public ArrayList<ArrayList<String>> getMatArr(){
        ArrayList<ArrayList<String>> materials = new ArrayList<ArrayList<String>>();

        FileHandling fh = new FileHandling();
        ArrayList<String> mat1d = fh.lineReturn("Material data.txt");

        for (int i = 0; i < Math.ceil(mat1d.size()/3); i++){

            ArrayList<String> temp = new ArrayList<>();
            temp.add(mat1d.get(3*i));
            temp.add(mat1d.get(3*i + 1));
            temp.add(mat1d.get(3*i + 2));

            materials.add(temp);

        }// for loop filling 2d array

        return materials;



        /*System.out.println(materials.get(0).get(0));
        System.out.println(materials.get(0).get(1));
        System.out.println(materials.get(1).get(0));
        System.out.println(materials.get(1).get(1));
        System.out.println(materials.get(4).get(1));*/

    }// takes inputs for the image material data








    public ArrayList<ArrayList<String>> getInputMatArr() {
        ArrayList<ArrayList<String>> materials = new ArrayList<ArrayList<String>>();

        FileHandling fh = new FileHandling();
        ArrayList<String> mat1d = fh.lineReturn("Material Input Data.txt");

        for (int i = 0; i < Math.ceil(mat1d.size() / 2); i++) {

            ArrayList<String> temp = new ArrayList<>();
            temp.add(mat1d.get(2 * i));
            temp.add(mat1d.get(2 * i + 1));

            materials.add(temp);

        }// for loop filling 2d array

        return materials;
    }// get inputted materials








    public String getMaterial(){
        boolean incorrect = false;
        String mat = "";

        while (incorrect == false) {
            mat = JOptionPane.showInputDialog("Select material: ");
            System.out.println(mat);
            String output = "You have entered: " + mat;

            ArrayList<ArrayList<String>> matArrr;
            matArrr = getMatArr();
            boolean inArr = false;

            for (int i = 0; i < matArrr.size(); i++){
                System.out.println(matArrr.get(i).get(0));
                if (mat.equals(matArrr.get(i).get(0))){
                    inArr = true;
                }
            }// checks if material is available

            if (inArr == true) {

                int i = JOptionPane.showConfirmDialog(null, output);

                if (i == 0) {
                    incorrect = true;
                }// if statement stopping while loop
                else if (i == 2) {
                    incorrect = true;
                    return "";
                }// if cancel is pressed
                else {

                }// option pane options
            }else {
                JOptionPane.showMessageDialog(null , "That is not a valid material, please try again.");
                getMaterial();
            }// if in array


        }// while loop
        return mat;
    }//takes input for chosen material








    public void calculateButton(){
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(140 , 40);
        homeButtonPanel.setLocation(570 , 300);

        JButton homeButton = new JButton("Calculate Cost");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String mat = getMaterial();
            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// button to calculate cost










    public void addMaterialButton(){
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(120 , 40);
        homeButtonPanel.setLocation(858 , 190);

        JButton homeButton = new JButton("Add Material");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// creates button to manually add a material and price








    public void createScrollDisplay(){
        JPanel scrollPanel = new JPanel();
        scrollPanel.setLayout(new FlowLayout());
        JTextArea tArea = new JTextArea(10,10);
        JScrollPane scrollPane = new JScrollPane(tArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPanel.add(scrollPane);
        scrollPane.setVisible(true);
        scrollPanel.setVisible(true);
        scrollPanel.setLocation(400 , 350);
        scrollPanel.setSize(500 , 500);

        frame.getContentPane().add(scrollPanel);
        panel.setLayer(scrollPanel , 2);
    }// creates cost display










    public void deleteMaterialButton(){
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(135 , 40);
        homeButtonPanel.setLocation(1063 , 190);

        JButton homeButton = new JButton("Delete Material");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// creates button to manually add a material and price























}// cost estimation menu class
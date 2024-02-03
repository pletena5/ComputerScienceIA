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

    DefaultListModel<String> listModel = new DefaultListModel<>();
    private double area;

    public void costEstimationMenu(String photoName , double area){

        this.area = area;

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

        deleteAllButton();

        displayArea();

    }// provides the cost estimation interface






    public ArrayList<ArrayList<String>> getMatArr(String filename){
        ArrayList<ArrayList<String>> materials = new ArrayList<ArrayList<String>>();

        FileHandling fh = new FileHandling();
        ArrayList<String> mat1d = fh.lineReturn(filename);

        for (int i = 0; i < Math.ceil(mat1d.size()); i++){

            ArrayList<String> temp = new ArrayList<>();
            temp.add(mat1d.get(i));
            //temp.add(mat1d.get(3*i + 1));
            //temp.add(mat1d.get(3*i + 2));

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








    public int getMaterial(String filename){
        boolean incorrect = false;
        String mat = "";
        int location = -1;

        while (incorrect == false) {
            mat = JOptionPane.showInputDialog("Select material: ");

            if (mat.equals(null)){
                return location;
            }// if cancel pressed

            System.out.println(mat);
            String output = "You have entered: " + mat;

            ArrayList<ArrayList<String>> matArrr;
            matArrr = getMatArr(filename);
            boolean inArr = false;

            for (int i = 0; i < matArrr.size(); i++){
                System.out.println(matArrr.get(i).get(0));
                if (mat.equals(matArrr.get(i).get(0))){
                    inArr = true;
                    location = i;
                }
            }// checks if material is available

            if (inArr == true) {

                int i = JOptionPane.showConfirmDialog(null, output);

                if (i == 0) {
                    incorrect = true;
                }// if statement stopping while loop
                else if (i == 2) {
                    incorrect = true;
                    return -1;
                }// if cancel is pressed
                else {

                }// option pane options
            }else {
                JOptionPane.showMessageDialog(null , "That is not a valid material, please try again.");
                getMaterial(filename);
            }// if in array


        }// while loop
        return location;
    }//takes input for chosen material





    private boolean hasNumbers(String input) {
        // Iterate through each character in the string
        for (char c : input.toCharArray()) {
            // Check if the character is a digit
            if (Character.isDigit(c)) {
                System.out.println("It has numbers");
                return true; // The string contains at least one digit
            }
        }
        System.out.println("It does not have numbers");
        return false; // The string does not contain any digits
    }// has numbers method









    public ArrayList getInputMaterial(){
        boolean incorrect = false;
        String mat = "";
        Double cost = -1.0;

        while (incorrect == false) {
            mat = JOptionPane.showInputDialog("Select material: ");
            cost = Double.parseDouble(JOptionPane.showInputDialog("How much does it cost per square metre?"));
            System.out.println(mat);
            String output = "Are you sure you wish to add " + mat + " with a cost of " + cost.toString() + " per square metre?";


            if (cost > 0 && hasNumbers(cost.toString()) == true) {

                int i = JOptionPane.showConfirmDialog(null, output);

                if (i == 0) {
                    incorrect = true;
                }// if statement stopping while loop
                else if (i == 2) {
                    incorrect = true;
                    System.out.println("cancel");
                    return null;
                }// if cancel is pressed
                else {

                }// option pane options
            }else {
                JOptionPane.showMessageDialog(null , "That is not a valid material, please try again.");
                getInputMaterial();
            }// if in array


        }// while loop
        ArrayList<String> arr = new ArrayList<>();

        arr.add(mat);
        arr.add(cost.toString());

        return arr;
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
                //ArrayList<String> array = getMaterial();
                //String mat = array.get(0);
                //String cost = array.get(1);

                //panel.remove();
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

                FileHandling fh = new FileHandling();

                ArrayList<String> array = getInputMaterial();
                String mat = array.get(0);
                String cost = array.get(1);

                System.out.println(mat + cost);

                fh.FileWriteLine("Material Input Data.txt" , mat , true);
                fh.FileWriteLine("Material Input Data.txt" , cost , true);

            }
        });

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// creates button to manually add a material and price








    public void createScrollDisplay(){

        String heading = "Material          cost per square metre          cost       ";
        listModel.addElement(heading);


        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));


// Create a JScrollPane and add the JList to it
        JScrollPane scrollPane = new JScrollPane(textArea);
        //scrollPane.setSize(200 , 300);
        scrollPane.setPreferredSize(new Dimension(300, 300));
        scrollPane.createHorizontalScrollBar();
        scrollPane.createVerticalScrollBar();


        FileHandling fh = new FileHandling();
        ArrayList<String> Array = fh.lineReturn("Material Input Data.txt");

        String materialDisplay = "   " + heading + "\n";

        for (int i = 0 ; i < Array.size()/2 ; i++){
            materialDisplay = materialDisplay + "   " + Array.get(2*i);
            int length = Array.get(2*i).length();
            int spacesNeeded = 18 - length;

            System.out.println(spacesNeeded);

            for (int j = 0 ; j < spacesNeeded ; j ++){
                materialDisplay = materialDisplay + " ";
            }// loop to add spaces to the string

            length = Double.toString(Double.parseDouble(Array.get(2*i + 1))).length();
            spacesNeeded = 31 - length;
            materialDisplay = materialDisplay + Double.toString(Double.parseDouble(Array.get(2*i + 1)));

            System.out.println(spacesNeeded);

            for (int j = 0 ; j < spacesNeeded ; j ++){
                materialDisplay = materialDisplay + " ";
            }// loop to add spaces to the string

            materialDisplay = materialDisplay + (Double.toString(Double.parseDouble(Array.get(2 * i + 1)) * area));
            materialDisplay = materialDisplay + "\n";
            System.out.println(materialDisplay);
        }// looping through material array

        textArea.setText(materialDisplay);


// Set up the frame
        JPanel ScrollPanel = new JPanel();
        ScrollPanel.add(scrollPane);
        ScrollPanel.setVisible(true);
        ScrollPanel.setSize(500 , 400);
        ScrollPanel.setLocation(400 , 350);

        frame.getContentPane().add(ScrollPanel);
        panel.setLayer(ScrollPanel , 2);
    }// creates cost display






    public void displayArea (){
        JLabel areaLabel = new JLabel("Area of selected region:   " + area);
        JPanel areaLabelPanel = new JPanel();

        areaLabelPanel.add(areaLabel);
        areaLabelPanel.setVisible(true);
        areaLabelPanel.setSize(230 , 40);
        areaLabelPanel.setLocation(330 , 190);

        panel.add(areaLabelPanel);
        panel.setLayer(areaLabelPanel , 2);

    }// displays the area of the selected part of floorplan










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
                String filename = "Material Input Data.txt";

                int location = getMaterial(filename);
                FileHandling fh = new FileHandling();
                ArrayList<String> matArr = fh.lineReturn(filename);
                matArr.remove(location);
                matArr.remove(location);

                if (matArr.size() != 0) {
                    fh.FileDelete(filename);

                    for (int i = 0; i < matArr.size(); i++) {
                        fh.FileWriteLine(filename, matArr.get(i), true);
                    }// fills file back in
                } else {
                    fh.FileDelete(filename);
                }
            }
        });// action listener implementation

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// creates button to delete materials












    public void deleteAllButton(){
        JPanel homeButtonPanel = new JPanel();
        homeButtonPanel.setVisible(true);
        homeButtonPanel.setSize(165 , 40);
        homeButtonPanel.setLocation(1275 , 190);

        JButton homeButton = new JButton("Delete All Materials");
        homeButton. setFont(new FontUIResource("Helvetica", 0 , 15));
        homeButtonPanel.add(homeButton);
        homeButton.setVisible(true);
        //homeButton.setOpaque(false);
        //homeButton.setContentAreaFilled(false);
        //homeButton.setBorderPainted(false);
        //newProjectButton.setSize(200 , 200);

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String filename = "Material Input Data.txt";
                FileHandling fh = new FileHandling();
                fh.FileDelete(filename);

            }
        });// action listener implementation

        frame.getContentPane().add(homeButtonPanel);
        panel.setLayer(homeButtonPanel , 2);
    }// creates button to delete all saved materials














}// cost estimation menu class
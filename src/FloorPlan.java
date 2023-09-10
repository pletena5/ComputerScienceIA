import java.util.ArrayList;

public class FloorPlan {

    Integer[][] imageValues;

    public FloorPlan(String pathname){
        ImageHandling image = new ImageHandling(pathname);
        Integer[][] imageValues = image.getImageValues();
        this.imageValues = imageValues;
    }// constructor

    public Integer[][] getImageValues (){
        return imageValues;
    }// returns image values

    public Integer[] centre(){
        Boolean inWall = true;
        Integer[] cent = new Integer[2];

        int height = imageValues.length;
        int width = imageValues[0].length;
        cent[0] = height/2;
        cent[1] = width/2;

        while (inWall == true) {
            if (imageValues[cent[0]][cent[1]] > 100) {
                inWall = false;
            }else{
                cent[0] = cent[0] + 1;
            }// checks if centre is in a wall
        }// loop until chosen centre isnt in a wall

        return cent;
    }// centre finder

    public int getPixelArea(){
        int pCount = 0;

        System.out.println("getpixel area method active");

        for (int i = 0; i < imageValues.length ; i++){
            for (int j = 0; j < imageValues[0].length ; j++){
                System.out.print(imageValues[i][j]);
            }
            System.out.println();
        }

        for (int i = 0; i < imageValues.length ; i++){
            for (int j = 0; j < imageValues[0].length ; j++){
                if (imageValues[i][j] == -1){
                    pCount = pCount + 1;
                    //System.out.println("true");
                }
            }
        }

        return pCount;

    }// get area method

    public void FloodFill(int x , int y, int newValue){       //x is the height and y is width

        Stack pixels = new Stack();
        int width = imageValues[0].length;
        int height = imageValues.length;

        System.out.println("floodfill method active");
        System.out.println(width + "  " + height);

        pixels.push(x , y);
        int egg = 0;

        while (pixels.peek() != null){
            Integer[] p = pixels.pop();

            if(p[0] >0 && p[0] < height && p[1]>0 && p[1] < width && imageValues[p[0]][p[1]] > 100 && imageValues[p[0]][p[1]] != newValue){
                imageValues[p[0]][p[1]] = newValue;

                pixels.push(p[0] + 1, p[1]);
                pixels.push(p[0] - 1, p[1]);
                pixels.push(p[0], p[1] + 1);
                pixels.push(p[0] , p[1] - 1);

/*

                for (int i = 0; i < imageValues.length; i++){
                    for (int j = 0; j < imageValues[0].length; j++){
                        System.out.print(imageValues[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
                System.out.println();
*/
                // above code displays the floodfill algorithm filling with each iteration



            }// if statement
        }// while loop

    }// floodfill method

}// floorplan class

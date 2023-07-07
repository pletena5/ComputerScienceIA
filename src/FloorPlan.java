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

    public int getArea(){
        Pixel p = new Pixel(imageValues[centre()[0]][centre()[1]] , centre()[0] , centre()[1] );
        ArrayList<ArrayList<Integer>> usedPixels = new ArrayList<ArrayList<Integer>>();
        usedPixels = p.expand(p.coord[0] , p.coord[1] , imageValues , usedPixels);

        return usedPixels.size();

    }// get area method

}// floorplan class

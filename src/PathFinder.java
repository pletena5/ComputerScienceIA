public class PathFinder {
    int height;
    int width;
    Integer [] [] RGBvalues;
    int pixels;
    Integer[] usedPixels;

    public PathFinder(Integer[][] RGBvalues){
        int height = RGBvalues.length;
        int width = RGBvalues[0].length;

        this.height = height;
        this.width = width;
        this.RGBvalues = RGBvalues;
    }// constructor

    public Integer[] centre(){
        Boolean inWall = true;
        Integer[] cent = new Integer[2];
        cent[0] = height/2;
        cent[1] = width/2;

        while (inWall == true) {
            if (RGBvalues[cent[0]][cent[1]] > 100) {
                inWall = false;
            }else{
                cent[0] = cent[0] + 1;
            }// checks if centre is in a wall
        }// loop until chosen centre isnt in a wall

        return cent;
    }// centre finder

    public void getArea (){

    }// works out the area by spreading outward

}// class pathfinder

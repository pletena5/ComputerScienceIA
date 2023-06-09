
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

    public void getArea (FloorPlan fp){
        int ID = 0;
        boolean full = false;
        Integer [] centre = fp.centre();

        Pixel p = new Pixel(RGBvalues[height][width]);



    }// works out the area by spreading outward - floodfill method




}// class pathfinder

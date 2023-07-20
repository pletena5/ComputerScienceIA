import java.util.ArrayList;

public class PathFinder {
    int height;
    int width;
    Integer [] [] RGBvalues;
    int pixels;
    ArrayList<ArrayList<Integer>> usedPixels;

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



        Pixel p = new Pixel(RGBvalues[centre[0]][centre[1]] , centre[0] , centre[1]);
        ArrayList<ArrayList<Integer>> newUsedPixels = p.expand(centre[0] , centre[1] , RGBvalues , usedPixels);
        int pixNum = newUsedPixels.size();


    }


}// class pathfinder

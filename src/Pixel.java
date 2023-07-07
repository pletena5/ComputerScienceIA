import java.util.ArrayList;

public class Pixel {

    int rgb;
    int[] coord = new int[2];

    Pixel Left;
    Pixel Right;
    Pixel Top;
    Pixel Bottom;

    boolean completeExpansion = false;

    public Pixel (int rgb , int h , int w){
        this.rgb = rgb;
        this.coord[0] = h;
        this.coord[1] = w;
    }// constructor

    public int[] getCoord(){
        return coord;
    }// get ID method

    public ArrayList<ArrayList<Integer>> expand(int h, int w , Integer [] [] RGBvalues , ArrayList<ArrayList<Integer>> usedPixels){
        Left = new Pixel(RGBvalues[h][w-1] , h , w-1);
        Right = new Pixel(RGBvalues[h][w+1] , h , w+1);
        Top = new Pixel(RGBvalues[h+1][w] , h+1 , w);
        Bottom = new Pixel(RGBvalues[h-1][w] , h-1 , w);
        boolean added = false;

        int s = 0;
        boolean in = false;

        for(int i = 0; i < usedPixels.size() ; i++){
            if(usedPixels.get(i).get(0) == h && usedPixels.get(i).get(1) == w-1 && RGBvalues[h][w-1] < 100){
               in = true;
            }// if statement
        }// for loop

        if (in == false) {

            ArrayList<Integer> ad = new ArrayList<Integer>();
            ad.add(h);
            ad.add(w-1);

            usedPixels.add(ad);

            added = true;
        }// if statement

        in = false;

        for(int i = 0; i < usedPixels.size() ; i++){
            if(usedPixels.get(i).get(0) == h && usedPixels.get(i).get(1) == w+1 && RGBvalues[h][w+1] < 100){
                in = true;
            }// if statement
        }// for loop

        if (in == false) {
            ArrayList<Integer> ad = new ArrayList<Integer>();
            ad.add(h);
            ad.add(w+1);

            usedPixels.add(ad);

            added = true;
        }// if statement

        in = false;

        for(int i = 0; i < usedPixels.size() ; i++){
            if(usedPixels.get(i).get(0) == h-1 && usedPixels.get(i).get(1) == w && RGBvalues[h-1][w] < 100){
                in = true;
            }// if statement
        }// for loop

        if (in == false) {
            ArrayList<Integer> ad = new ArrayList<Integer>();
            ad.add(h-1);
            ad.add(w);

            usedPixels.add(ad);

            added = true;
        }// if statement

        in = false;

        for(int i = 0; i < usedPixels.size() ; i++){
            if(usedPixels.get(i).get(0) == h+1 && usedPixels.get(i).get(1) == w && RGBvalues[h+1][w] < 100){
                in = true;
            }// if statement
        }// for loop

        if (in == false) {
            ArrayList<Integer> ad = new ArrayList<Integer>();
            ad.add(h+1);
            ad.add(w);

            usedPixels.add(ad);

            added = true;
        }// if statement

        in = false;

        if (added == false){
            return usedPixels;
        }// checks if something added
        else if (added == true ){
            ArrayList<ArrayList<Integer>> newUsedPixels = Top.expand(h, w , RGBvalues , usedPixels);

            for (int i = 0; i < Bottom.expand(h, w , RGBvalues , usedPixels).size() ; i++) {
                for (int j = 0; j < Top.expand(h, w, RGBvalues, usedPixels).size(); j++) {
                    if (newUsedPixels.get(j) != Bottom.expand(h, w , RGBvalues , usedPixels).get(i)){
                        newUsedPixels.add(Bottom.expand(h, w , RGBvalues , usedPixels).get(i));
                    }// if statement
                }// for loop
            }// for loop bottom method

            for (int i = 0; i < Left.expand(h, w , RGBvalues , usedPixels).size() ; i++) {
                for (int j = 0; j < newUsedPixels.size(); j++) {
                    if (newUsedPixels.get(j) != Left.expand(h, w , RGBvalues , usedPixels).get(i)){
                        newUsedPixels.add(Left.expand(h, w , RGBvalues , usedPixels).get(i));
                    }// if statement
                }// for loop
            }// for loop bottom method

            for (int i = 0; i < Right.expand(h, w , RGBvalues , usedPixels).size() ; i++) {
                for (int j = 0; j < newUsedPixels.size(); j++) {
                    if (newUsedPixels.get(j) != Right.expand(h, w , RGBvalues , usedPixels).get(i)){
                        newUsedPixels.add(Right.expand(h, w , RGBvalues , usedPixels).get(i));
                    }// if statement
                }// for loop
            }// for loop bottom method

            return newUsedPixels;

        }// else if

        return usedPixels;

    }//expand method

} // pixel class
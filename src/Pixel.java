public class Pixel {

    int rgb;
    int ID;

    Pixel Left;
    Pixel Right;
    Pixel Top;
    Pixel Bottom;

    public Pixel (int rgb){
        this.rgb = rgb;
    }// constructor

    public int getID(){
        return ID;
    }// get ID method

} // pixel class
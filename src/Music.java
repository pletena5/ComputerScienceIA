import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import java.io.*;



public class Music {

    public Music(){
        File myFile = new File("C:\\Users\\17karasimov_m\\IdeaProjects\\Computer science IA\\E.mp3");


        FileInputStream fileInputStream;
        BufferedInputStream bufferedInputStream;
        Player player;


        try {
            //code for play button
            fileInputStream=new FileInputStream(myFile);
            bufferedInputStream=new BufferedInputStream(fileInputStream);
            player=new Player(bufferedInputStream);
            player.play();//starting music
        } catch (JavaLayerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }// constructor


}// class music

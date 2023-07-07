import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class WebsiteReader {

    public static ArrayList<String> readWebsite(String website){
        String websiteURL = website; // Replace with the actual URL of the website
        ArrayList<String> lines = new ArrayList<String>();

        try {
            URL url = new URL(websiteURL);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line of data here
                lines.add(line);
                System.out.println(line);
            }// while loop

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }// try catch

        return lines;
    }// read website class

}// website reader class

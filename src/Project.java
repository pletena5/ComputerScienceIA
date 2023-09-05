import java.io.IOException;
import java.util.ArrayList;

public class Project {
    FloorPlan fp;

    public Project(String filename){
        fp = new FloorPlan(filename);

        FileHandling fh = new FileHandling();
        ArrayList<String> numProjectsArr = fh.lineReturn("Projects.txt");
        Integer numProjects = Integer.parseInt(numProjectsArr.get(0));

        numProjects = numProjects+1;
        fh.FileWrite("Projects.txt" , numProjects.toString() , false);

        fh.FileWrite("ProjectDirectories.txt" , filename , true);


    }// creates the project

}// project class
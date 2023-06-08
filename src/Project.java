import java.util.ArrayList;

public class Project {
    ArrayList<FloorPlan> FloorPlans = new ArrayList<FloorPlan>();
    ArrayList<String> FloorPlanNames = new ArrayList<String>();

    public void addPlan(FloorPlan plan , String name){
        FloorPlans.add(plan);
        FloorPlanNames.add(name);
    }// add floorplan class

    public FloorPlan getPlan(String name){
        for (int i = 0 ; i < FloorPlanNames.size() ; i++){
            if (name == FloorPlanNames.get(i)){
                return FloorPlans.get(i);
            }// if statement
        }// for loop

        return null;
    }//get floor plan method

}// project class
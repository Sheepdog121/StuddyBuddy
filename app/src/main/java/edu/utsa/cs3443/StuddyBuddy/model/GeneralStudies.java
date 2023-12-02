package edu.utsa.cs3443.StuddyBuddy.model;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import edu.utsa.cs3443.StuddyBuddy.BuildingPageActivity;
import edu.utsa.cs3443.StuddyBuddy.InteractiveMap;

public class GeneralStudies {

    /**
     *      Attributes
     */
    private ArrayList<Building> buildings;

    /**
     *      Constructor
     */
    public GeneralStudies(){
        buildings = new ArrayList<Building>();
    }

    /**
     *      Getter and Setter
     */
    public void setBuildings(ArrayList<Building> buildings){
        this.buildings = buildings;
    }
    public ArrayList<Building> getBuildings(){
        return buildings;
    }


    public StudySpot getSpot(String buildingName, int idx){
        Building currBuilding = null;
        StudySpot spot = null;
        for (Building b : buildings){
            if (b.getName().equals(buildingName)){
                currBuilding = b;
                break;
            }
        }

        spot = currBuilding.getSpots().get(idx);

        return spot;
    }

    /**
     *      loadSpots
     * @param activity
     * @param filename
     */
    public void loadSpots(BuildingPageActivity activity, String filename){
        AssetManager manager = activity.getAssets();

        try{
            InputStream file = manager.open(filename);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()){
                String line = scan.nextLine();
                String[] tokens = line.split(",");

                if (buildings.isEmpty()) {
                    Building newBuilding = new Building(tokens[0], tokens[1], tokens[2], tokens[3], tokens[9]);
                    StudySpot newSpot = new StudySpot(tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]);
                    newBuilding.addSpot(newSpot);
                    buildings.add(newBuilding);
                } else {
                    Iterator<Building> iterator = buildings.iterator();
                    boolean buildingFound = false;

                    while (iterator.hasNext()) {
                        Building b = iterator.next();
                        if (b.getName().equals(tokens[0])) {
                            StudySpot newSpot = new StudySpot(tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]);
                            b.addSpot(newSpot);
                            buildingFound = true;
                            break;
                        }
                    }

                    if (!buildingFound) {
                        Building newBuilding = new Building(tokens[0], tokens[1], tokens[2], tokens[3], tokens[9]);
                        StudySpot newSpot = new StudySpot(tokens[4], tokens[5], tokens[6], tokens[7], tokens[8]);
                        newBuilding.addSpot(newSpot);
                        buildings.add(newBuilding);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Unable to open file!!");
        }

    }

}

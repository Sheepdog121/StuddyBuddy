package edu.utsa.cs3443.StuddyBuddy.model;

import java.util.ArrayList;

public class Building {

    /**
     *      Attributes
     */
    private String name;
    private String desc1;
    private String desc2;
    private String desc3;
    private String buildImage;
    private ArrayList<StudySpot> spots;

    /**
     *      Constructor
     * @param name
     * @param desc1
     * @param desc2
     * @param desc3
     */
    public Building(String name, String desc1, String desc2, String desc3, String buildImage){
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.desc3 = desc3;
        this.buildImage = buildImage;
        spots = new ArrayList<StudySpot>();
    }

    /**
     *      Getters and Setters
     */
    public void setSpots(ArrayList<StudySpot> spots){
        this.spots = spots;
    }
    public ArrayList<StudySpot> getSpots(){
        return spots;
    }
    public String getName(){
        return name;
    }
    public String getDesc1(){
        return desc1;
    }
    public String getDesc2(){
        return desc2;
    }
    public String getDesc3(){
        return desc3;
    }
    public String getBuildImage(){
        return buildImage;
    }

    /**
     *      addSpot
     * @param spot
     */
    public void addSpot(StudySpot spot){

        spots.add(spot);
    }
}

package edu.utsa.cs3443.StuddyBuddy.model;

public class StudySpot {

    /**
     *      Attributes
     */
    private String name;
    private String desc1;
    private String desc2;
    private String location; //optional for now
    private String image;

    /**
     *      Constructor
     * @param name
     * @param desc1
     * @param desc2
     * @param location
     */
    public StudySpot(String name, String desc1, String desc2, String location, String image){
        this.name = name;
        this.desc1 = desc1;
        this.desc2 = desc2;
        this.location = location;
        this.image = image;
    }

    /**
     *      Getters and Setters
     */
    public String getName(){
        return name;
    }
    public String getDesc1(){
        return desc1;
    }
    public String getDesc2(){
        return desc2;
    }
    public String getLocation(){
        return location;
    }
    public String getImage(){
        return image;
    }

}

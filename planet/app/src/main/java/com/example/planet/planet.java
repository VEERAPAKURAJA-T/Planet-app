package com.example.planet;
/*
This class is acting as Model Class for our ListView.It is in the context of an
Android list view is a fundamental component that represents the data structure
for each individual item in the list. It defines the attributes and behavior associated
with each item.
 */
public class planet {
    //Attributes
    private String planetName;
    private String moonCount;
    private int image;/*one integer that represent the image resource.
    Image are not stored inside in variables.Rather resource identifiers represented
    as int values are used to efficiently manage and access images and other resources
    within your app.These identifier provide a way to reference resources in your code
    and xml layout files without having to deal with the actual image data directly in
    your code.
    */
    //constructor

    public planet(String planetName, String moonCount, int image) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.image = image;
    }
    //Getters & Setters --to access the attribute of the model class
    /*
    Getters--From outside the class you often provide getter methods.These methods
    allow other parts of your code ,like the adapter, to retrieve the values
    stored in the model instance.
    Setters--on the other hand ,are used to update the attribute values if needed.
     */
    //The main purpose of the model class is to hold the data.

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public String getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(String moonCount) {
        this.moonCount = moonCount;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}

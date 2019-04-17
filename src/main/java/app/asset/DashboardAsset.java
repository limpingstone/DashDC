package app.asset;

import java.io.*;

// Abstract class
// Used for default field declarations and variable implementations
// Parent class for all asset classes (e.g. AssetNote, AssetList, etc.)
public abstract class DashboardAsset implements Serializable {
    protected int id;
    protected String name;

    protected int[] position = new int[2];
    protected int[] size = new int[2];
    // private Style style;

    // Constructor
    // Takes in an id and name as arguments
    // Sets the field variables to the parameter inputs
    public DashboardAsset(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Sets the id attribute to the input parameter
    public void setId(int id){
        this.id = id;
    }

    // Returns the id attribute
    public int getId() {
        return id;
    }

    // Sets the name attribute to the input parameter
    public void setName(String name){
        this.name = name;
    }

    // Returns the name attribute
    public String getName() {
        return name;
    }

    // Sets the position attribute to the input array parameter
    public void setPosition(int[] position) {
        this.position = position;
    }

    // Returns the position attribute array
    public int[] getPosition() {
        return this.position;
    }

    // Sets the size attribute to the input array parameter
    public void setSize(int[] size) {
        this.size = size;
    }

    // Returns the size attribute array
    public int[] getSize() {
        return this.size;
    }

    // Returns a String of HTML code to display that asset
    // Abstractly defined
    public abstract String display();

    /*
     * public Style setStyle(Style style){ this.Style = style; }
     * 
     * public Style getStyle(){ return this.style; }
     */

}

package app.asset;

import java.io.*;

public abstract class DashboardAsset implements Serializable {
    protected int id;
    protected String name;

    protected int[] position = new int[2];
    protected int[] size = new int[2];
    // private Style style;

    public DashboardAsset(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }

    public int[] getPosition() {
        return this.position;
    }

    public void setSize(int[] size) {
        this.size = size;
    }

    public int[] getSize() {
        return this.size;
    }

    /*
     * public Style setStyle(Style style){ this.Style = style; }
     * 
     * public Style getStyle(){ return this.style; }
     */

    public abstract String display();
}

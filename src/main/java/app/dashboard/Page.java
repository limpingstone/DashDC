package app.dashboard;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Page implements Serializable {
    String name;
    int id;
    List<Tile> tileList;

    // Default constructor
    // Sets the default id and name attribute
    // Instantiates the tileList
    public Page() {
        name = "Default.";
        id = 0;
        tileList = new ArrayList<Tile>();
    }

    // Overloaded constructor
    // Sets the id and name attribute to the input parameter
    // Instantiates the tileList
    public Page(int pageID, String pageName) {
        name = pageName;
        id = pageID;
        tileList = new ArrayList<Tile>();
    }

    // Returns a List of Tile objects contained in the page
    public List<Tile> getTiles() {
        return tileList;
    }

    // Returns a List of Strings of Tile names
    public List<String> getTileNames() {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < tileList.size(); i++) {
            names.add(tileList.get(i).getName());
        }
        return names;
    }

    // Returns the Tile object with specified id
    public Tile getTile(int id) {
        for (int i = 0; i < tileList.size(); i++) {
            if (id == tileList.get(i).getId())
                return tileList.get(i);
        }
        return null; // should be an error if not found
    }

    // Returns the name attribute
    public String getName() {
        return name;
    }

    // Returns id attribute
    public int getId() {
        return id;
    }

    // Creates a new Tile object to be contained in this Page
    // Adds the Tile object to the list of tiles
    public void addTile(int id, String name) {
        Tile newTile = new Tile(id, name);
        tileList.add(newTile);
    }

}

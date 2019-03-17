package app;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Page implements Serializable{
    String name;
    int id;
    List<Tile> tileList;

    public Page() {
        name = "Default.";
        id = 0;
        tileList = new ArrayList<Tile>();
    }

    public Page(int pageID, String pageName) {
        name = pageName;
        id = pageID;
        tileList = new ArrayList<Tile>();
    }

    // returns a list of tile objects
    public List<Tile> getTiles() {
        return tileList;
    }

    // returns a list of tile names
    public List<String> getTileNames() {
        List<String> names = new ArrayList<String>();
        for ( int i = 0; i < tileList.size(); i++ ) {
            names.add(tileList.get(i).getName());
        }
        return names;
    }

    // returns the tile object with specified id
    public Tile getTile(int id) {
        for ( int i = 0; i < tileList.size(); i++ ) {
            if ( id == tileList.get(i).getId() )
                return tileList.get(i);
        }
        return null; // should be an error if not found
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // creates a new tile object contained in this Page
    public void addTile(int id, String name) {
        Tile newTile = new Tile(id, name);
        tileList.add(newTile);
    }

}

package app;

import java.util.List;
import java.util.ArrayList;

public class Tile {
    String name;
    int id;
    String contents; // replace with a list of Assets

    public Tile() {
        name = "Default.";
        id = 0;
        contents = "null";
    }

    public Tile(int tileID, String tileName) {
        id = tileID;
        name = tileName;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // for prototyping only---
    public void setContents(String textData) {
        contents = textData;
    }

    public String getContents() {
        return contents;
    }
}

package app.asset;

import java.io.*;

public class AssetFile extends DashboardAsset implements Serializable {

    private String filePath;

    // Constructor for AssetFile
    // Takes an int id and a String name
    // Calls the parent constructor on the parameter inputs
    public AssetFile(int id, String name) {
        super(id, name);
    }

    // Takes an String input filePath
    // Sets the field variable filePath to the paramter input
    public void setFile(String filePath) {
        this.filePath = filePath;
    }

    // Returns the filePath field
    public String getFile() {
        return this.filePath;
    }

    @Override
    public String display() {
        return null;
    }
}

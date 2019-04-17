package app.asset;

import java.io.*;

public class AssetImage extends DashboardAsset implements Serializable {

    // String to hold image path.
    private String imagePath;

    // Constructor,
    // Takes parameters id, name, path, size, and position for the asset
    // Calls the parent constructor with id and name nputs
    // Sets the rest of the field variables to the parameter inputs
    public AssetImage(int id, String name, String imagePath, int[] size, int[] position) {
        super(id, name);
        this.imagePath = imagePath;
        this.size = size;
        this.position = position;
    }

    // Sets the imagePath field variable to the input parameter
    public void setPath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Returns the imagePath field for the image
    public String getPath() {
        return imagePath;
    }

    // Returns a String of the HTML code to display the image asset
    @Override
    public String display() {
        //return "/fragments/assets.html :: testFrag";
        //return "../../../resources/templates/fragments/assets.html :: image(src = \"" + this.imagePath + "\", width = \"" + this.size[0] + "\", height = \"" + this.size[1] + "\")";
        return "<img src=\"" + imagePath + "\" style=\"width:" + size[0] + "px; height: " + size[1] + "px;\"><br>";
    }
}

package app.asset;

import java.io.*;

public class AssetImage extends DashboardAsset implements Serializable {

    // String to hold image path.
    private String imagePath;

    // Constructor, takes id, name, path, size and position for the asset
    public AssetImage(int id, String name, String imagePath, int[] size, int[] position) {
        super(id, name);
        this.imagePath = imagePath;
        this.size = size;
        this.position = position;
    }

    // Sets the path to the image
    public void setPath(String imagePath) {
        this.imagePath = imagePath;
    }

    // Gets the path for the image
    public String getPath() {
        return imagePath;
    }

    // Generates the HTML code to display the image
    @Override
    public String display() {
        //return "/fragments/assets.html :: testFrag";
        //return "fragments/assets :: image(src = \"" + this.imagePath + "\", width = \"" + this.size[0] + "\", height = \"" + this.size[1] + "\")";
        return "<img src=\"" + imagePath + "\" style=\"width:" + size[0] + "px; height: " + size[1] + "px;\"><br>";
    }
}

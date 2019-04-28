package app.asset;

import java.io.*;

public class AssetYoutube extends DashboardAsset implements Serializable {

    // String to hold image path.
    private String videoUrl;

    // Constructor,
    // Takes parameters id, name, url, size, and position for the asset
    // Calls the parent constructor with id and name nputs
    // Sets the rest of the field variables to the parameter inputs
    public AssetYoutube(int id, String name, String url, int[] size, int[] position) {
        super(id, name);
        this.videoUrl = url;
        this.size = size;
        this.position = position;
    }

    // Sets the videoUrl field variable to the input parameter
    public void setUrl(String url) {
        this.videoUrl = url;
    }

    // Returns the imagePath field for the image
    public String getUrl() {
        return videoUrl;
    }

    // Returns a String of the HTML code to display the image asset
    @Override
    public String display() {	
        return "<iframe src=\"" + videoUrl + "\" style=\"width:" + size[0] + "px; height: " + size[1] + "px;\" title='" + getName() + "' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe><br>";
    }
}

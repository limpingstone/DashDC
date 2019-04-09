package app.asset;

import java.io.*;

public class AssetLink extends DashboardAsset implements Serializable {

    // String to hold image path.
    private String link;

    // Constructor, takes id, name, link for the asset
    public AssetLink(int id, String name, String link) {
        super(id, name);
        this.link = link;
    }

    // Sets the link to the asset
    public void setLink(String link) {
        this.link = link;
    }

    // Gets the link for the asset
    public String getLink() {
        return link;
    }

    // Generates the HTML code to display the image
    @Override
    public String display() {
        String retStr = "<br>";
	// specify the link attribute
	retStr += "<a href='" + getLink() + "' target='_blank'>";
	// specify the link text
	retStr += getName();
	retStr += "</a><br>";

	return retStr;
    }
}

package app.asset;

import java.io.*;

public class AssetLink extends DashboardAsset implements Serializable {

    // String to hold image path.
    private String link;

    // Constructor takes parameters id, name, link for the asset
    // Calls the parent constructor on id and name
    // Sets the other field variables as appropriate
    public AssetLink(int id, String name, String link) {
        super(id, name);
        this.link = link;
    }

    // Sets the link field variable to the input parameter
    public void setLink(String link) {
        this.link = link;
    }

    // Returns the link field variable of the asset
    public String getLink() {
        return link;
    }

    // Returns a String of the HTML code to display the link asset
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

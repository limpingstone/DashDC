package app.dashboard;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

import app.asset.*;

public class Tile implements Serializable {
    String name;
    int id;
    List<DashboardAsset> assetList;

    public Tile() {
        name = "Default.";
        id = 0;
        assetList = new ArrayList<DashboardAsset>();

    }

    public Tile(int tileID, String tileName) {
        id = tileID;
        name = tileName;
        assetList = new ArrayList<DashboardAsset>();
    }

    // returns a list of asset objects
    public List<DashboardAsset> getAssets() {
        return assetList;
    }

    // returns a list of asset names
    public List<String> getAssetNames() {
        List<String> names = new ArrayList<String>();
        for (int i = 0; i < assetList.size(); i++) {
            names.add(assetList.get(i).getName());
        }
        return names;
    }

    // returns the asset object with specified id
    public DashboardAsset getAsset(int id) {
        for (int i = 0; i < assetList.size(); i++) {
            if (id == assetList.get(i).getId())
                return assetList.get(i);
        }
        return null; // should be an error if not found
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    // generic
    // creates a new asset object contained in this tile
    public void addAsset(int id, String name) {

    }

    // creates a new AssetImage object
    // adds the AssetImage to assetList
    public void addAssetImage(int id, String name, String path, int[] size, int[] position) {
        AssetImage image = new AssetImage(id, name, path, size, position);
        assetList.add((DashboardAsset) image);
    }

    // creates a new AssetLink object
    // adds the AssetLink to assetList
    public void addAssetLink(int id, String name, String path) {
	AssetLink link = new AssetLink(id, name, path);
	assetList.add((DashboardAsset) link);
    }
    
    // creates a new AssetList object
    // adds the AssetList to assetList
    public void addAssetList(int id, String name, String type) {
	// determine list type
	char listType;
	if ( type.equals("ordered") )
	    listType = 'o';
	else // type.equals("unordered")
	    listType = 'u';
	
	AssetList list = new AssetList(id, name, listType);
	assetList.add((DashboardAsset) list);
	
    }

    // creates a new AssetNote object
    // ads the AssetNote to assetList
    public void addAssetNote(int id, String name) {
	AssetNote note = new AssetNote(id, name);
	assetList.add((DashboardAsset) note);
    }
    
    public String display() {
        // return assetList.toString();

        String retStr = "";
        retStr += "<div name='" + this.id + "' style='border:1px solid black'>";
        for (int i = 0; i < assetList.size(); i++) {
            retStr += assetList.get(i).display();
        }
        retStr += "</div>";
        retStr += "<br>";
        return retStr;
    }
}

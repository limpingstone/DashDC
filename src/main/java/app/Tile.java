package app;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class Tile implements Serializable{
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
	for ( int i = 0; i < assetList.size(); i++ ) {
	    names.add(assetList.get(i).getName());
	}
	return names;
    }

    // returns the asset object with specified id
    public DashboardAsset getAsset(int id) {
	for ( int i = 0; i < assetList.size(); i++ ) {
	    if ( id == assetList.get(i).getId() )
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
    
    public void addAssetImage(int id, String name, String path, int[] size, int[] position) {
	AssetImage image = new AssetImage(id, name, path, size, position);
	assetList.add((DashboardAsset) image);
    }

    public String display() {
	//return assetList.toString();
	
	String retStr = "";
	retStr += "<div name='" + this.id + "'>";
	for ( int i = 0; i < assetList.size(); i++ ) {
	    retStr += assetList.get(i).display();
	}
	retStr += "</div>";
	retStr += "<br>";
	return retStr;
    }
}

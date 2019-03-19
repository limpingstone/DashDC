package app.asset;

import java.util.List;
import java.util.ArrayList;
import java.io.*;

public class AssetList extends DashboardAsset implements Serializable{
    List<String> listContents = new ArrayList<String>();

    public AssetList(int id, String name) {
	super(id, name);
    }
    
    @Override
    public String display(){
        return null;
    }
}

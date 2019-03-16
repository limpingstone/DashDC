package app;

import java.util.List;
import java.util.ArrayList;

public class AssetList extends DashboardAsset{
    List<String> listContents = new ArrayList<String>();

    public AssetList(int id, String name) {
	super(id, name);
    }
    @Override
    public String display(){
        return null;
    }
}

package app;
import java.io.*;

public class AssetFile extends DashboardAsset implements Serializable {
    
    private String filePath;

    public AssetFile(int id, String name) {
	super(id, name);
    }
    
    public void setFile(String filePath){
        this.filePath = filePath;
    }

    public String getFile(){
        return this.filePath;
    }

    @Override
    public String display(){
        return null;
    }
}

package app;

public class AssetFile extends DashboardAsset{
    
    private String filePath;

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
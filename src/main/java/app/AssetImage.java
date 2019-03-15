public class AssetImage extends DashboardAsset{
    private String imagePath;

    public AssetImage(String imagePath, int[] size, int[] position){
        this.imagePath = imagePath;
        this.size = size;
        this.position = position;
    }
    
    public void setPath(String imagePath){
        this.imagePath = imagePath;
    }

    public String getPath(){
        return imagePath;
    }

    @Override
    public String display(){
        return "<img src=\"" + imagePath + "\">";
    }
}